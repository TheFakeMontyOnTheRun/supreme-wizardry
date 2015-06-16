package br.odb.supremewizardry.core;

public class FloatRange {
	
	public interface ValueObserver {
		public void onMinimumValueReached( FloatRange range );
		public void onMaximumValueReached( FloatRange range );
	}
	
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append( label );
		sb.append( ": [" );
		sb.append( (int)min );
		sb.append( "..." );
		sb.append( (int)current );
		sb.append( "..." );
		sb.append( (int)max );
		sb.append( "]" );
		
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(current);
		result = prime * result + Float.floatToIntBits(defaultValue);
		result = prime * result + Float.floatToIntBits(delta);
		result = prime * result + Float.floatToIntBits(max);
		result = prime * result + Float.floatToIntBits(min);
		result = prime * result
				+ ((valueObserver == null) ? 0 : valueObserver.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FloatRange other = (FloatRange) obj;
		if (Float.floatToIntBits(current) != Float
				.floatToIntBits(other.current))
			return false;
		if (Float.floatToIntBits(defaultValue) != Float
				.floatToIntBits(other.defaultValue))
			return false;
		if (Float.floatToIntBits(delta) != Float.floatToIntBits(other.delta))
			return false;
		if (Float.floatToIntBits(max) != Float.floatToIntBits(other.max))
			return false;
		if (Float.floatToIntBits(min) != Float.floatToIntBits(other.min))
			return false;
		if (valueObserver == null) {
			if (other.valueObserver != null)
				return false;
		} else if (!valueObserver.equals(other.valueObserver))
			return false;
		return true;
	}

	private String label;
	private float min;
	private float max;
	private float current;
	private float delta;
	private float defaultValue;
	private ValueObserver valueObserver;
	
	public void setCurrent( float current ) {
		this.current = current;
		checkBounds();
	}
	
	public void setDelta( float delta ) {
		this.delta = delta;
	}
	
	public FloatRange( String label, float min, float max, float defaultValue, ValueObserver observer ) {
		this.label = label;
		this.min = min;
		this.max = max;
		this.current = this.defaultValue = defaultValue;
		this.valueObserver = observer;
	}
	
	public FloatRange(String label, float min, float max, float defaultValue) {
		this( label, min, max, defaultValue, null );
	}

	public void update() {

		current += delta;

		checkBounds();
	}

	private void checkBounds() {
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

	public float getCurrentValue() {
		return current;
	}
}
