package br.odb.supremewizardry.core;

public class SummonGhostBearSpell extends Spell {
	
	GhostlyBear bear;
	
	public SummonGhostBearSpell() {
		super( "Summon Ghostly Bear", "For 3 turns, ant action from caster will inflict extra damage to target, due to spectral bear attacks");
	}

	@Override
	public void consequencesOn(Wizard caster) {
		bear = (GhostlyBear) caster.summon( new GhostlyBear() );
	}

	@Override
	public void actOn(Wizard target) {
		bear.attack( target, 3 );
	}
}
