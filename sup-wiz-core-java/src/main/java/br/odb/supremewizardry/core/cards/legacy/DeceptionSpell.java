package br.odb.supremewizardry.core.cards.legacy;

import br.odb.supremewizardry.core.Card;
import br.odb.supremewizardry.core.Wizard;

public class DeceptionSpell extends Card {

	public DeceptionSpell() {
		super( "Deception", "For the 5 turns, the target will not see the correct spell that hits him or that he casts, causing him to cast the wrong spells, but not realizing so." );
	}
	
	public void actOn( Wizard target ) {
		target.confuseFor( 5 );
	}

	@Override
	public void consequencesOn(Wizard caster) {

	}
}
