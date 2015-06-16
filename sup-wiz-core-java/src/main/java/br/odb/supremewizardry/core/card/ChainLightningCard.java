package br.odb.supremewizardry.core.card;

import br.odb.supremewizardry.core.Card;
import br.odb.supremewizardry.core.Dice;
import br.odb.supremewizardry.core.Wizard;

public class ChainLightningCard extends Card {

	public ChainLightningCard() {
		super( "Chain Lightning", "Chain Lightning" );
	}

	@Override
	public void actOn(Wizard caster, Wizard target) {
		target.takeLifePoints( 1, 2 * Dice.from( ( int )caster.inteligencePoints.getCurrentValue() ).roll() );
		
	}

	@Override
	public Card clone() {
		return new ChainLightningCard();
	}
}
