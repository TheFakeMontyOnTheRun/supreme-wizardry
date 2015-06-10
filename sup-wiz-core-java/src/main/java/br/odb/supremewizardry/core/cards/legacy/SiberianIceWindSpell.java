package br.odb.supremewizardry.core.cards.legacy;

import br.odb.supremewizardry.core.Card;
import br.odb.supremewizardry.core.Wizard;

public class SiberianIceWindSpell extends Card {

	public SiberianIceWindSpell() {
		super("Siberian Icy Wind", "Blows a strong gush of wind towards the caster, causing damage due to ice crystals");	
	}

	@Override
	public void consequencesOn(Wizard caster) {
		caster.takeLifePoints( 1, 2 );

	}

	@Override
	public void actOn(Wizard target) {
		target.takeLifePoints( 2, 4 );
	}
}
