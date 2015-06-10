package br.odb.supremewizardry.core;

import java.util.HashSet;
import java.util.Set;

import br.odb.supremewizardry.core.FloatRange.ValueObserver;

public abstract class Wizard implements ValueObserver {

	final FloatRange lifePoints = new FloatRange( "VIT", 0.0f, 100.0f, 100.0f, this );
	final FloatRange strengthPoints = new FloatRange( "STR", 0.0f, 100.0f, 100.0f, this );
	final FloatRange inteligencePoints = new FloatRange( "INT", 0.0f, 100.0f, 100.0f, this );
	final Set<Card> spells = new HashSet< Card>();
	final Set<Equipment> equipment = new HashSet< Equipment>();
	
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
		sb.append( strengthPoints);
		sb.append( '\n' );
		sb.append( inteligencePoints);
		sb.append( "-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
		return sb.toString();
	}

	public Wizard( String name, String description ) {
		this.name = name;
		this.description = description;
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
	}

	public void takeLifePoints(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public void confuseFor(int i) {
		// TODO Auto-generated method stub
		
	}

	public void getMagicPointsFromAllSummoned() {
		// TODO Auto-generated method stub
		
	}

	public void drainMagicPointsFromAllSummoned() {
		// TODO Auto-generated method stub
		
	}

	public void addLifePoints(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public void destroyAllSummonedCreatures() {
		// TODO Auto-generated method stub
		
	}
}
