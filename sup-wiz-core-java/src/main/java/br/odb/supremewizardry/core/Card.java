package br.odb.supremewizardry.core;

import java.util.HashMap;
import java.util.Map;

public abstract class Card {
	
	public enum SpellType {
		
		Fire( "Fire" ),
		Ice( "Ice" ),
		Wind( "Wind"),
		Earth( "Earth" ),
		Water( "Water");
		
		public final String prettyName;

		SpellType( String prettyName ) {
			this.prettyName = prettyName;
		}
	}

	public final Map<SpellType, Float> atributes = new HashMap< SpellType, Float>();
	public final Map<SpellType, Float> requirements = new HashMap< SpellType, Float>();
	public final String name;
	public final String description;
	
	public Card( String name, String description ) {
		this.name = name;
		this.description = description;
	}
	
	public abstract void consequencesOn( Wizard caster );
	public abstract void actOn( Wizard target );
}