package br.odb.supremewizardry.core.commands;

import br.odb.gameapp.ConsoleApplication;
import br.odb.gameapp.UserCommandLineAction;
import br.odb.supremewizardry.core.SupremeWizardryGame;

public class PickCardCommand extends UserCommandLineAction {

	public PickCardCommand() {
		
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int requiredOperands() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void run(ConsoleApplication app, String arg1) throws Exception {
		SupremeWizardryGame game = (SupremeWizardryGame) app;
		game.currentWizard.takeCards( 1, game.tableCards);
	}

	@Override
	public String toString() {
		return "pick-card";
	}
}
