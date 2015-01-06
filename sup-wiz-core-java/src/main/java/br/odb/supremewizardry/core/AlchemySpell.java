package br.odb.supremewizardry.core;

public class AlchemySpell extends Spell {

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
