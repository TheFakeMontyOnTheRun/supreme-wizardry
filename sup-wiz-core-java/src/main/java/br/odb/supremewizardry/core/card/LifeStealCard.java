package br.odb.supremewizardry.core.card;

import br.odb.supremewizardry.core.Card;
import br.odb.supremewizardry.core.Wizard;

public class LifeStealCard extends Card {

	int suckedLife;
	
	public LifeStealCard() {
		super( "Life Steal", "Life Steal" );
	}

	@Override
	public void consequencesOn(Wizard caster) {
		int turns = 1;
		caster.addLifePoints( turns, suckedLife );
	}

	@Override
	public void actOn(Wizard target) {
		suckedLife = 20;
		int turns = 1;
		target.takeLifePoints( turns , suckedLife );		
	}

	@Override
	public Card clone() {
		return new LifeStealCard();
	}
}
