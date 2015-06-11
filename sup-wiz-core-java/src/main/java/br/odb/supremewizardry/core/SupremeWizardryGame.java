package br.odb.supremewizardry.core;

import br.odb.gameapp.ConsoleApplication;
import br.odb.supremewizardry.core.commands.EndTurnCommand;
import br.odb.supremewizardry.core.commands.PickCardCommand;
import br.odb.supremewizardry.core.commands.UseCardCommand;
import br.odb.supremewizardry.core.commands.DisplayStatusCommand;

public class SupremeWizardryGame extends ConsoleApplication {

	private Wizard wizard1;
	private Wizard wizard2;
	public Wizard currentWizard;

	public SupremeWizardryGame() {
		super();
		
		wizard1 = new DummyWizard1();
		wizard2 = new DummyWizard2();
		currentWizard = wizard1;
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
