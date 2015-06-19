package br.odb.supremewizardry.core;

public class Effect {

	private int turnsToDie;
	final private float delta;
	final private FloatRange target;

	public int getTurnsLeft() {
		return turnsToDie;
	}
	
	public String toString() {
		return "" + ( delta ) + " on " + target;
	}
	
	public void update() {
		if ( turnsToDie > 0 ) {
			target.setCurrent( target.getCurrentValue() + delta );	
		}
		--turnsToDie;
	}
	
	public Effect(FloatRange statAffected, float delta, int turns) {
		this.turnsToDie = turns;
		this.delta = delta;
		this.target = statAffected;
	}
}
