package br.odb.supremewizardry.core.card;

import br.odb.supremewizardry.core.Card;
import br.odb.supremewizardry.core.Wizard;

public class LifeStealCard extends Card {

	public LifeStealCard() {
		super( "Life Steal", "Life Steal" );
	}

	@Override
	public void actOn(Wizard caster, Wizard target) {
		int suckedLife = 20;
		int turns = 1;
		target.takeLifePoints( turns , suckedLife );
		caster.addLifePoints( turns, suckedLife );
	}

	@Override
	public Card clone() {
		return new LifeStealCard();
	}
}
