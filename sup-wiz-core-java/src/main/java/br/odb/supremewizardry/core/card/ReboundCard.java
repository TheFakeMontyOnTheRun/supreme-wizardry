package br.odb.supremewizardry.core.card;

import br.odb.supremewizardry.core.Card;
import br.odb.supremewizardry.core.Wizard;

public class ReboundCard  extends Card {

	public ReboundCard() {
		super( "Rebound", "Rebound" );
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
		return new ReboundCard();
	}
}
