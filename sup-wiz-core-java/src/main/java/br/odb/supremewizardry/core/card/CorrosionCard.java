package br.odb.supremewizardry.core.card;

import br.odb.supremewizardry.core.Card;
import br.odb.supremewizardry.core.Wizard;

public class CorrosionCard extends Card {

	public CorrosionCard() {
		super("Corrosion", "Corrosion");
	}

	@Override
	public void consequencesOn(Wizard caster) {


	}

	@Override
	public void actOn(Wizard target) {


	}

	@Override
	public Card clone() {
		return new CorrosionCard();
	}
}
