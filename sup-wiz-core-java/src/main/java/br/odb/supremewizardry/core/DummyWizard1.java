package br.odb.supremewizardry.core;

public class DummyWizard1 extends Wizard {

	public DummyWizard1() {
		super( "Rasputin", "Powerful and mysterious" );
		
		spells.add( new DeceptionSpell() );
		spells.add( new MagicDaggerSpell() );
		spells.add( new SummonGhostBearSpell() );
		spells.add( new SiberianIceWindSpell() );
	}
	
	
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDeath() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMagicDepleted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSuperPowered() {
		// TODO Auto-generated method stub
		
	}

}
