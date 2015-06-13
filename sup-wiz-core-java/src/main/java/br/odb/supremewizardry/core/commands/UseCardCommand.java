package br.odb.supremewizardry.core.commands;

import br.odb.gameapp.ConsoleApplication;
import br.odb.gameapp.UserCommandLineAction;
import br.odb.supremewizardry.core.SupremeWizardryGame;

public class UseCardCommand extends UserCommandLineAction {

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int requiredOperands() {
		return 1;
	}

	@Override
	public void run(ConsoleApplication app, String arg1) throws Exception {
		SupremeWizardryGame game = (SupremeWizardryGame) app;
		game.currentWizard.useCard( arg1 );
	}

	@Override
	public String toString() {
		return "use-card";
	}
}
