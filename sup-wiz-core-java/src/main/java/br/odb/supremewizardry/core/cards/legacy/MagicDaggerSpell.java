package br.odb.supremewizardry.core.cards.legacy;

import br.odb.supremewizardry.core.Card;
import br.odb.supremewizardry.core.Wizard;

public class MagicDaggerSpell extends Card {

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
