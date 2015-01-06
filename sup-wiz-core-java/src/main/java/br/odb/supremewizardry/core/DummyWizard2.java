package br.odb.supremewizardry.core;

public class DummyWizard2 extends Wizard {

	public DummyWizard2() {
		super( "Merlin", "Wise and resourceful" );
		
		spells.add( new GuidanceSpell() );
		spells.add( new FireballSpell() );
		spells.add( new AlchemySpell() );
		spells.add( new SummonGiantOwlSpell() );
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
