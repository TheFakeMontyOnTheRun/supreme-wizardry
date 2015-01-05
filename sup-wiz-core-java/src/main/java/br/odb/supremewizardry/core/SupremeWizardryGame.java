package br.odb.supremewizardry.core;

import br.odb.gameapp.ConsoleApplication;

public class SupremeWizardryGame extends ConsoleApplication {

	
	
	private DummyWizard1 wizard1;
	private DummyWizard2 wizard2;

	@Override
	public ConsoleApplication init() {
		
		wizard1 = new DummyWizard1();
		wizard2 = new DummyWizard2();
		
		return super.init();
	}

	@Override
	public void onDataEntered(String data) {
		// TODO Auto-generated method stub
		super.onDataEntered(data);
	}

	@Override
	public ConsoleApplication showUI() {
		// TODO Auto-generated method stub
		return super.showUI();
	}

	@Override
	public void update(long ms) {
		// TODO Auto-generated method stub
		super.update(ms);
	}

	@Override
	public void log(String arg0, String arg1) {
	}

	@Override
	protected void doQuit() {
	}
}
