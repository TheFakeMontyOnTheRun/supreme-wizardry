package br.odb.supremewizardry.core;

import java.util.ArrayList;
import java.util.List;

import br.odb.gameapp.ConsoleApplication;
import br.odb.supremewizardry.core.card.*;
import br.odb.supremewizardry.core.commands.EndTurnCommand;
import br.odb.supremewizardry.core.commands.PickCardCommand;
import br.odb.supremewizardry.core.commands.UseCardCommand;
import br.odb.supremewizardry.core.commands.DisplayStatusCommand;

public class SupremeWizardryGame extends ConsoleApplication {

	Card[] possibleCards = new Card[]{
		new ArcadeShieldCard(),
		new ArcadeSwordCard(),
		new ArcaneBlastCard(),
		new ChainLightningCard(),
		new ConcentrateCard(),
		new CorrosionCard(),
		new CurseCard(),
		new FireboltCard(),
		new FlameWeaponCard(),
		new IceboltCard(),
		new LifeStealCard(),
		new MindTwistCard(),
		new ParalyzeCard(),
		new PlagueCard(),
		new ReboundCard(),
		new RepairCard(),
		new SilenceCard(),
		new SummonCard()
	};

	private Wizard wizard1;
	private Wizard wizard2;
	public Wizard currentWizard;
	final public List< Card > tableCards = new ArrayList<>(); 
	
	public SupremeWizardryGame() {
		super();
		
		shuffleCardsIntoTable();
		
		wizard1 = new DummyWizard1();
		wizard2 = new DummyWizard2();
		wizard1.target = wizard2;
		wizard2.target = wizard1;
		currentWizard = wizard1;
		
		wizard1.takeCards( 4, tableCards );
		wizard2.takeCards( 4, tableCards );
		
		tableCards.add( 0, new LifeStealCard());
		wizard1.takeCards( 1, tableCards);
	}
	
	private void shuffleCardsIntoTable() {
		for ( int c = 0; c < 50; ++c ) {
			tableCards.add( (Card) possibleCards[ (int)(Math.random() * possibleCards.length) ].clone() );
		}
	}

	public void endTurn() {
		if ( currentWizard != wizard1 ) {
			currentWizard = wizard1;
		} else {
			currentWizard = wizard2;
		}
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
		
		this.wizard1.update();
		this.wizard2.update();
	}

	@Override
	public void log(String arg0, String arg1) {
	}

	@Override
	protected void doQuit() {
	}
}
