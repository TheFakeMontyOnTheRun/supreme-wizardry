package br.odb.supremewizardry.core.cards.legacy;

import br.odb.supremewizardry.core.Card;
import br.odb.supremewizardry.core.Wizard;

public class FireballSpell extends Card {

	public FireballSpell() {
		super("Fireball", "Creates a deadly fireball with instant damage to the target( and some to it's caster as well)");
	}

	@Override
	public void consequencesOn(Wizard caster) {
		caster.takeLifePoints( 2, 1 );

	}

	@Override
	public void actOn(Wizard target) {
		target.takeLifePoints( 10, 1 );
	}

}
