package br.odb.supremewizardry.core.commands;

import br.odb.gameapp.ConsoleApplication;
import br.odb.gameapp.UserCommandLineAction;

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
	public void run(ConsoleApplication arg0, String arg1) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "use-card";
	}
}
