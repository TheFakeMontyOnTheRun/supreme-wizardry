package br.odb.supremewizardry.core.card;

import br.odb.supremewizardry.core.Card;
import br.odb.supremewizardry.core.Wizard;

public class SummonCard extends Card {

	public SummonCard() {
		super( "Summon", "Summon");
	}

	@Override
	public void actOn(Wizard caster, Wizard target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Card clone() {
		return new SummonCard();
	}
}
