package br.odb.supremewizardry.core;

public class Equipment {
	
	private boolean inUse;

	public void toggle() {
		inUse = !inUse;
	}
	
	public boolean isInUse() {
		return inUse;
	}
}
