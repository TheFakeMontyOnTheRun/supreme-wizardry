package br.odb.supremewizardry.core.card;

import br.odb.supremewizardry.core.Card;
import br.odb.supremewizardry.core.Dice;
import br.odb.supremewizardry.core.Wizard;

public class ParalyzeCard  extends Card {

	public ParalyzeCard() {
		super( "Paralyze", "Paralyze" );
	}

	@Override
	public void actOn(Wizard caster, Wizard target) {
		int intDice = Dice.from( (int)caster.inteligencePoints.getCurrentValue() ).roll();
		target.addLingeringEffect( target.actionPoints, -1, intDice );
		System.out.println( "target paralyzed for " + intDice + " turns" );
	}

	@Override
	public Card clone() {
		return new ParalyzeCard();
	}
}
