package br.odb.supremewizardry.core;

import br.odb.supremewizardry.core.cards.legacy.AlchemySpell;
import br.odb.supremewizardry.core.cards.legacy.FireballSpell;
import br.odb.supremewizardry.core.cards.legacy.GuidanceSpell;

public class DummyWizard2 extends Wizard {

	public DummyWizard2() {
		super( "Merlin", "Wise and resourceful" );
		
		spells.add( new GuidanceSpell() );
		spells.add( new FireballSpell() );
		spells.add( new AlchemySpell() );
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
