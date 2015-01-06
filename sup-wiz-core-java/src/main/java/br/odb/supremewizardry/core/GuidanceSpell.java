package br.odb.supremewizardry.core;

public class GuidanceSpell extends Spell {

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
