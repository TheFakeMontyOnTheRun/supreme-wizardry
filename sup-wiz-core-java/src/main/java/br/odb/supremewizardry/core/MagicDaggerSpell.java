package br.odb.supremewizardry.core;

public class MagicDaggerSpell extends Spell {

	public MagicDaggerSpell() {
		super( "Magic Dagger", "A energy aura will surround the caster's dagger as it stabs the target" );
	}

	@Override
	public void consequencesOn(Wizard caster) {
	}

	@Override
	public void actOn(Wizard target) {
		target.takeLifePoints( 3, 1 );
	}
}
