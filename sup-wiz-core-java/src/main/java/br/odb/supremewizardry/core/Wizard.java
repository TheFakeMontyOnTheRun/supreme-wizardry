package br.odb.supremewizardry.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import br.odb.supremewizardry.core.FloatRange.ValueObserver;
import br.odb.supremewizardry.core.Spell.SpellType;

public abstract class Wizard implements ValueObserver {

	final Map< SpellType, FloatRange > magicalPoints = new HashMap< SpellType, FloatRange>();
	final FloatRange lifePoints = new FloatRange( "HP", 0.0f, 100.0f, 100.0f, this );
	final Set<Spell> spells = new HashSet< Spell>();
	final String name;
	final String description;
	
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append( "-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
		sb.append( name );
		sb.append( '\n' );
		sb.append( lifePoints);
		sb.append( '\n' );
		for ( FloatRange r : magicalPoints.values()) {
			sb.append( r );
			sb.append( '\n' );
		}
		
 		sb.append( "-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
		return sb.toString();
	}

	public Wizard( String name, String description ) {
		this.name = name;
		this.description = description;
		
		for ( SpellType st : SpellType.values() ) {
			magicalPoints.put( st, new FloatRange( st.prettyName, 0.0f, 100.0f, 50.0f ) );
		}

	}
	
	public abstract void update();
	

	public abstract void onDeath();
	
	public abstract void onMagicDepleted();
	
	public abstract void onSuperPowered();
	
	public void onMinimumValueReached( FloatRange range ) {
		if ( range == lifePoints ) {
			onDeath();
		}
	}
	
	public void onMaximumValueReached( FloatRange range ) {
		for ( FloatRange r : magicalPoints.values() ) {
			if ( r.isAtMaximum() ) {
				return;
			}
		}
		
		onSuperPowered();
	}
}
