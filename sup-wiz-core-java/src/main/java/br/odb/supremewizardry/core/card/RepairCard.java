package br.odb.supremewizardry.core.card;

import br.odb.supremewizardry.core.Card;
import br.odb.supremewizardry.core.Wizard;

public class RepairCard extends Card {

	public RepairCard() {
		super( "Repair", "Repait" );
	}

	@Override
	public void actOn(Wizard caster, Wizard target) {
		target.repairRandomEquipment();		
	}

	@Override
	public Card clone() {
		return new RepairCard();
	}
}
