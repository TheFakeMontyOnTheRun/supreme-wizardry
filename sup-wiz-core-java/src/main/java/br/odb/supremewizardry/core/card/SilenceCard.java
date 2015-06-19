package br.odb.supremewizardry.core.card;

import br.odb.supremewizardry.core.Card;
import br.odb.supremewizardry.core.Wizard;

public class SilenceCard extends Card {

	public SilenceCard() {
		super( "Silence", "Silence");
	}

	@Override
	public void actOn(Wizard caster, Wizard target) {
		target.actionPoints.setCurrent( target.actionPoints.getMinimum());
		
	}

	@Override
	public Card clone() {
		return new SilenceCard();
	}
}
