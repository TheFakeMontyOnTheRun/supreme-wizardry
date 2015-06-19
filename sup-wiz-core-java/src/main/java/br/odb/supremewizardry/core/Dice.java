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
		return (int)( Math.random() * ( sides - 1 ) ) + 1;
				
	}
	
	public static Dice from( int sides ) {
		
		if ( sides % 2 == 1 ) {
			--sides;
		}
		
		if  ( sides < 4 ) {
			return D4;
		}
		
		if  ( sides > 20 ) {
			return D20;
		}
		
		for ( Dice d : Dice.values() ) {
			if ( d.sides == sides ) {
				return d;
			}
		}
		
		return null;
	}
}
