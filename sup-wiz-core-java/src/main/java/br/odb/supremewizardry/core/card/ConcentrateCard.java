package br.odb.supremewizardry.core.card;

import br.odb.supremewizardry.core.Card;
import br.odb.supremewizardry.core.Wizard;

public class ConcentrateCard extends Card {

	public ConcentrateCard() {
		super("Concentrate", "Concentrate" );
	}

	@Override
	public void consequencesOn(Wizard caster) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actOn(Wizard target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Card clone() {
		return new ConcentrateCard();
	}
}
