package br.odb.supremewizardry.core;

public class SummonGiantOwlSpell extends Spell {

	GiantOwl owl;
	
	public SummonGiantOwlSpell() {
		super("Summon giant owl", "Summon giant owl to attack target (unless said target is under the influence of Guidance) for 5 turns. Can only be cast once per match." );
	}

	@Override
	public void consequencesOn(Wizard caster) {
		owl = (GiantOwl) caster.summon( new GiantOwl() );
	}

	@Override
	public void actOn(Wizard target) {
		owl.attack( target, 5 );
	}

}
