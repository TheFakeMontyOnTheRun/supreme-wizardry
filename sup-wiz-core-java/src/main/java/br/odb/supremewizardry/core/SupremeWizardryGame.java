package br.odb.supremewizardry.core;

import br.odb.gameapp.ConsoleApplication;
import br.odb.supremewizardry.core.commands.CastSpellCommand;
import br.odb.supremewizardry.core.commands.DisplayStatusCommand;

public class SupremeWizardryGame extends ConsoleApplication {

	private DummyWizard1 wizard1;
	private DummyWizard2 wizard2;
	public final Wizard playerWizard;
	public final Wizard CPUWizard;

	public SupremeWizardryGame() {
		super();
		
		wizard1 = new DummyWizard1();
		wizard2 = new DummyWizard2();

		playerWizard = wizard1;
		CPUWizard = wizard2;
	}
	
	
	@Override
	public ConsoleApplication init() {
		
		super.init();
		
		this.registerCommand(new CastSpellCommand());
		this.registerCommand(new DisplayStatusCommand());
		
		return this;
	}

	@Override
	public void onDataEntered(String data) {

		super.onDataEntered(data);

	}

	@Override
	public ConsoleApplication showUI() {
		this.getClient().printNormal( this.playerWizard.toString() );
		return super.showUI();
	}

	@Override
	public void update(long ms) {
		super.update(ms);
		
		this.playerWizard.update();
		this.CPUWizard.update();
	}

	@Override
	public void log(String arg0, String arg1) {
	}

	@Override
	protected void doQuit() {
	}
}
