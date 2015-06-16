package br.odb.supremewizardry.core.card;

import br.odb.supremewizardry.core.Card;
import br.odb.supremewizardry.core.Wizard;

public class ArcaneBlastCard extends Card {

	public ArcaneBlastCard() {
		super("Arcane Blast", "Arcane Blast" );
	}

	@Override
	public void actOn(Wizard caster, Wizard target) {
		target.takeLifePoints( 1, 1 );
		caster.takeCardsFromMainPile( 1 );
	}

	@Override
	public Card clone() {
		return new ArcaneBlastCard();
	}
}
