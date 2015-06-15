package br.odb.supremewizardry.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.odb.supremewizardry.core.FloatRange.ValueObserver;

public abstract class Wizard implements ValueObserver {

	final FloatRange lifePoints = new FloatRange("HP", 0.0f, 12.0f, 12.0f,
			this);

	final FloatRange actionPoints = new FloatRange("AP", 0.0f, 5.0f, 5.0f,
			this);

	final FloatRange vitalityPoints = new FloatRange("VIT", 0.0f, 4.0f, 1.0f,
			this);
	final FloatRange strengthPoints = new FloatRange("STR", 0.0f, 4.0f,
			1.0f, this);
	final FloatRange inteligencePoints = new FloatRange("INT", 0.0f, 4.0f,
			1.0f, this);
	
	final List<Card> spells = new ArrayList<Card>();
	final Set<Equipment> equipment = new HashSet<Equipment>();
	public Wizard target;
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

		sb.append("-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
		sb.append(name);
		sb.append('\n');
		sb.append(lifePoints);
		sb.append('\n');
		sb.append(actionPoints);
		sb.append('\n');
		sb.append('\n');
		sb.append(vitalityPoints);
		sb.append('\n');
		sb.append(strengthPoints);
		sb.append('\n');
		sb.append(inteligencePoints);
		sb.append("\n------\nCards:\n");
		
		for (Card c : this.spells) {
			sb.append(c.toString());
			sb.append('\n');
		}
		sb.append("-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
		return sb.toString();
	}

	public Wizard(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public abstract void update();

	public abstract void onDeath();

	public abstract void onMagicDepleted();

	public abstract void onSuperPowered();

	public void onMinimumValueReached(FloatRange range) {
		if (range == lifePoints) {
			onDeath();
		}
	}

	public void onMaximumValueReached(FloatRange range) {
	}

	public void takeLifePoints(int turns, int pointsToTake) {
		this.lifePoints.setDelta( -pointsToTake);
		this.lifePoints.update();
		this.lifePoints.setDelta( 0 );
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

	public void addLifePoints(int turns, int pointsToAdd ) {
		this.lifePoints.setDelta( pointsToAdd );
		this.lifePoints.update();
		this.lifePoints.setDelta( 0 );
	}

	// TODO Auto-generated method stub
	public void destroyAllSummonedCreatures() {
		// TODO Auto-generated method stub

	}

	public void takeCards(int howMany, List<Card> tableCards) {
		Card cardToTake;
		for (int c = 0; c < howMany; ++c) {
			cardToTake = tableCards.get(0);
			this.spells.add(cardToTake);
			tableCards.remove(cardToTake);
		}
	}

	public void useCard(String arg1) {

		Card card = getCard(arg1);
		card.actOn(target);
		card.consequencesOn(this);
		spells.remove(card);
	}

	private Card getCard(String arg1) {
		for (Card card : spells) {

			if (!card.name.equals(arg1)) {
				continue;
			}

			return card;
		}
		return null;
	}

	public void takeCardsMake4(List<Card> cards) {
		if ( this.spells.size() < 4 ) {
			this.takeCards( 4 - this.spells.size(), cards);
		}
	}
}
