package br.odb.supremewizardry.core.commands;

import br.odb.gameapp.ConsoleApplication;
import br.odb.gameapp.UserCommandLineAction;
import br.odb.supremewizardry.core.SupremeWizardryGame;

public class EndTurnCommand extends UserCommandLineAction {

	public EndTurnCommand() {
		// TODO Auto-generated constructor stub
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
		app.getClient().printNormal( "New turn!" );
		game.endTurn();
	}

	@Override
	public String toString() {
		return "end-turn";
	}
}
