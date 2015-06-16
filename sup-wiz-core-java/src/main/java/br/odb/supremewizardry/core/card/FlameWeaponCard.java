package br.odb.supremewizardry.core.card;

import br.odb.supremewizardry.core.Card;
import br.odb.supremewizardry.core.Wizard;

public class FlameWeaponCard extends Card {

	public FlameWeaponCard() {
		super( "Flame Weapon", "Flame Weapon" );
	}

	@Override
	public void actOn(Wizard caster, Wizard target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Card clone() {
		return new FlameWeaponCard();
	}
}
