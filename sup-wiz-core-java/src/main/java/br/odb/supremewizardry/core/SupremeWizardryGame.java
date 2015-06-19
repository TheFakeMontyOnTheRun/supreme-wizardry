package br.odb.supremewizardry.core;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.odb.gameapp.ConsoleApplication;
import br.odb.supremewizardry.core.card.*;
import br.odb.supremewizardry.core.commands.EndTurnCommand;
import br.odb.supremewizardry.core.commands.PickCardCommand;
import br.odb.supremewizardry.core.commands.UseCardCommand;
import br.odb.supremewizardry.core.commands.DisplayStatusCommand;

public class SupremeWizardryGame extends ConsoleApplication implements MultiplayerClient {

public static enum Teams {
	EMPTY("[#]"), ICE("[O]"), FIRE("[X]");

	String representation;

	Teams(String representation) {
		this.representation = representation;
	}

	@Override
	public String toString() {
		return representation;
	}
}

	Card[] possibleCards = new Card[]{
//		new ArcadeShieldCard(),
//		new ArcadeSwordCard(),
		new ArcaneBlastCard(),
		new ChainLightningCard(),
//		new ConcentrateCard(),
		new CorrosionCard(),
//		new CurseCard(),
//		new FireboltCard(),
//		new FlameWeaponCard(),
//		new IceboltCard(),
//		new LifeStealCard(),
//		new MindTwistCard(),
		new ParalyzeCard(),
//		new PlagueCard(),
//		new ReboundCard(),
		new RepairCard(),
		new SilenceCard(),
//		new SummonCard()
	};

	private Wizard wizard1;
	private Wizard wizard2;
	public Wizard currentWizard;
	final public List< Card > tableCards = new ArrayList<>(); 
	private ServerProxy serverProxy = new ServerProxy(
			"http://localhost:8080/multiplayer-server");
	private int playerId;
	private int gameId;
	private Teams winnerTeam;
	private Teams currentTeam;
	private Teams localPlayerTeam;

	
	public SupremeWizardryGame() {
		super();
		
		shuffleCardsIntoTable();
		
		wizard1 = new DummyWizard1( this );
		wizard2 = new DummyWizard2( this );
		wizard1.target = wizard2;
		wizard2.target = wizard1;
		currentWizard = wizard1;
		
		wizard1.takeCards( 4, tableCards );
		wizard2.takeCards( 4, tableCards );
		
		tableCards.add( 0, new LifeStealCard());
		wizard1.takeCards( 1, tableCards);
		//requestGameFromServer();
	}

	public void requestGameFromServer() {
		serverProxy.startConnection(this);
	}

	
	private void shuffleCardsIntoTable() {
		for ( int c = 0; c < 50; ++c ) {
			tableCards.add( (Card) possibleCards[ (int)(Math.random() * possibleCards.length) ].clone() );
		}
	}

	public void endTurn() {
		currentWizard.restoreActionPoints();
		
		if ( currentWizard != wizard1 ) {
			currentWizard = wizard1;
		} else {
			currentWizard = wizard2;
		}
		
		if ( currentWizard.lifePoints.isAtMinimum() ) {
			this.getClient().printNormal( "This match is over" );
			doQuit();
		}
		
		currentWizard.takeCardsMake4( tableCards );
		this.updateGameState();
	}
	
	
	@Override
	public ConsoleApplication init() {
		
		super.init();
		
		this.registerCommand(new UseCardCommand());
		this.registerCommand(new EndTurnCommand());
		this.registerCommand(new PickCardCommand());
		this.registerCommand(new DisplayStatusCommand());
		
		
		return this;
	}

	@Override
	public void onDataEntered(String data) {

		super.onDataEntered(data);
		
		if ( currentWizard.actionPoints.isAtMinimum() ) {
			endTurn();
			return;
		}
		
		try {			
			runCmd( data );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ConsoleApplication showUI() {
		this.getClient().printNormal( this.currentWizard.toString() );
		return super.showUI();
	}

	@Override
	public void update(long ms) {
		super.update(ms);
	}
	
	void updateGameState() {
		this.currentWizard.update();
	}

	@Override
	public void log(String arg0, String arg1) {
	}

	@Override
	protected void doQuit() {
		System.out.println( 0 );
	}
	
	@Override
	public void receiveGameId(int gameId) {
		this.gameId = gameId;
		getClient().printVerbose("got game id: " + gameId);
	}

	@Override
	public void receivePlayerId(int playerId) {
		this.playerId = playerId;
		getClient().printVerbose("got player id: " + playerId);
	}

	@Override
	public void receiveTeamId(int teamId) {
		this.localPlayerTeam = Teams.values()[teamId];
		getClient().printVerbose("got local player team: " + localPlayerTeam);
	}

	@Override
	public void receiveMove(Node gameNode) {

		Teams[] teams = Teams.values();

		int i = 0;

		NodeList nodeLst = gameNode.getChildNodes();

		for (int s = 0; s < nodeLst.getLength(); s++) {

			Node fstNode = nodeLst.item(s);

			if (fstNode != null) {

				if (fstNode.getNodeType() == Node.ELEMENT_NODE) {

					if (fstNode.getNodeName().equals("state")) {

						String statusData = fstNode.getTextContent();


					} else if (fstNode.getNodeName().equals("current")) {
						this.currentTeam = teams[Integer.parseInt(fstNode
								.getTextContent())];
					} else if (fstNode.getNodeName().equals("winner")) {
						this.winnerTeam = teams[Integer.parseInt(fstNode.getTextContent())];
					}
				}
			}
		}

		if (this.winnerTeam != teams[0]) {

			getClient().printNormal("team " + winnerTeam + " wins the match");
		}
	}

	@Override
	public void endOfTurn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void allowedToSendMove() {
		// TODO Auto-generated method stub

	}

	public void receiveStatus() {
		serverProxy.requestUpdate(this);
	}

	@Override
	public int getAppId() {
		return gameId;
	}

	public void sendRemoteMove(int x, int y) {
		serverProxy.sendData(x, y, this);

	}

	@Override
	public int getUserId() {
		return playerId;
	}	
}
