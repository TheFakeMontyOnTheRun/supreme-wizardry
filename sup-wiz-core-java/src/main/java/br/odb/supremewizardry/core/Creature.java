package br.odb.supremewizardry.core;

import java.util.Map;
import java.util.HashMap;

import br.odb.supremewizardry.core.Spell.SpellType;

public abstract class Creature {
	public int turnsToLive;
	public final Map< SpellType, Float > cost = new HashMap< SpellType, Float >();
	private Wizard target;
	
	
	public void attack(Wizard target, int i) {
		this.target = target;
		turnsToLive = i;
	}
}
