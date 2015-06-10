package br.odb.supremewizardry.core.cards.legacy;

import br.odb.supremewizardry.core.Card;
import br.odb.supremewizardry.core.Wizard;

public class AlchemySpell extends Card {

	public AlchemySpell() {
		super("Alchemy", "Extract magic points from all his summoned creatures in the game, thus claiming one turn from their lifespan. This will also drain magic points from the target's creatures, but without conceding any bonus.");
	}

	@Override
	public void consequencesOn(Wizard caster) {
		caster.getMagicPointsFromAllSummoned();
	}

	@Override
	public void actOn(Wizard target) {
		target.drainMagicPointsFromAllSummoned();
	}
}
