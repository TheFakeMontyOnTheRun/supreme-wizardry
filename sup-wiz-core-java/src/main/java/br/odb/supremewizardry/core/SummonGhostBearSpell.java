package br.odb.supremewizardry.core;

public class SummonGhostBearSpell extends Spell {

	public SummonGhostBearSpell() {
		super( "Summon Ghostly Bear", "For 3 turns, ant action from caster will inflict extra damage to target, due to spectral bear attacks");
	}

	@Override
	public void consequencesOn(Wizard caster) {
	}

	@Override
	public void actOn(Wizard target) {
	}
}
