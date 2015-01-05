package br.odb.supremewizardry.core;

public class FloatRange {
	
	public interface ValueObserver {
		public void onMinimumValueReached( FloatRange range );
		public void onMaximumValueReached( FloatRange range );
	}

	private float min;
	private float max;
	private float current;
	private float delta;
	private float defaultValue;
	private ValueObserver valueObserver;
	
	public void setCurrent( float current ) {
		this.current = current;
	}
	
	public void setDelta( float delta ) {
		this.delta = delta;
	}
	
	public FloatRange( float min, float max, float defaultValue, ValueObserver observer ) {
		
		this.min = min;
		this.max = max;
		this.current = this.defaultValue = defaultValue;
		this.valueObserver = observer;
	}
	
	public void update() {

		current += delta;

		if ( current < min ) {
			current = min;
			
			if ( valueObserver != null ) {
				valueObserver.onMinimumValueReached( this );
			}
		}
		
		if ( current > max ) {

			current = max;
			
			if ( valueObserver != null ) {
				valueObserver.onMaximumValueReached( this );
			}
		}
	}
	
	public boolean isAtMaximum() {

		return current >= max;
	}
	
	public boolean isAtMinimum() {

		return current <= min;
	}
}
