package br.odb.supremewizardry.core.card;

import br.odb.supremewizardry.core.Card;
import br.odb.supremewizardry.core.Wizard;

public class ArcadeShieldCard extends Card {

	public ArcadeShieldCard() {
		super("Arcade Shield", "Arcane Shield");
	}

	@Override
	public void actOn(Wizard caster, Wizard target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Card clone() {
		return new ArcadeShieldCard();
	}
}
