package br.odb.supremewizardry.core.card;

import br.odb.supremewizardry.core.Card;
import br.odb.supremewizardry.core.Wizard;

public class CorrosionCard extends Card {

	public CorrosionCard() {
		super("Corrosion", "Corrosion");
	}

	@Override
	public void actOn(Wizard caster, Wizard target) {
		target.destroyRandomEquipmentPiece();
	}

	@Override
	public Card clone() {
		return new CorrosionCard();
	}
}
