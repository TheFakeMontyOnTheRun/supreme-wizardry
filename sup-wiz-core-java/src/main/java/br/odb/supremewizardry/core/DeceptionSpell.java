package br.odb.supremewizardry.core;

public class DeceptionSpell extends Spell {

	public DeceptionSpell() {
		super( "Deception", "For the 5 turns, the target will not see the correct spell that hits him." );
	}
	
	public void actOn( Wizard target ) {
		
	}

	@Override
	public void consequencesOn(Wizard caster) {
	}
}
