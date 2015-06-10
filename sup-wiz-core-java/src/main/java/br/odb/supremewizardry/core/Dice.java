package br.odb.supremewizardry.core;

public enum Dice {
	D4( 4 ),
	D6( 6 ),
	D8( 8 ),
	D20( 20 );
	
	
	final int sides;
	
	Dice( int sides ) {
		this.sides = sides;
	}
	
	public int roll() {
		return (int)( Math.random() * ( sides + 1) );
				
	}
}
