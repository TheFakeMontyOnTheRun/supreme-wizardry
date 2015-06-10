package br.odb.supremewizardry.core.cards.legacy;

import br.odb.supremewizardry.core.Card;
import br.odb.supremewizardry.core.Wizard;

public class GuidanceSpell extends Card {

	public GuidanceSpell() {
		super( "Guidance", "provide clarity (and bonus vitality) to the target, so that all his summoned creatures will be called off." );
	}
	
	@Override
	public void consequencesOn(Wizard caster) {
	}

	@Override
	public void actOn(Wizard target) {
		target.addLifePoints( 2, 1 );
		target.destroyAllSummonedCreatures();
	}
}
