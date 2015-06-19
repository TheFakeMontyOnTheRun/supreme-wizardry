package br.odb.supremewizardry.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.odb.supremewizardry.core.FloatRange.ValueObserver;

public abstract class Wizard implements ValueObserver {

	public final FloatRange currentActionPointExpenditure = new FloatRange("EX", 0.0f, 4.0f, 2.0f,
			this);

	
	public final FloatRange lifePoints = new FloatRange("HP", 0.0f, 12.0f, 12.0f,
			this);

	public final FloatRange actionPoints = new FloatRange("AP", 0.0f, 5.0f, 5.0f,
			this);

	public final FloatRange vitalityPoints = new FloatRange("VIT", 0.0f, 4.0f, 1.0f,
			this);
	public final FloatRange strengthPoints = new FloatRange("STR", 0.0f, 4.0f,
			1.0f, this);
	public final FloatRange inteligencePoints = new FloatRange("INT", 0.0f, 4.0f,
			1.0f, this);
	
	public final List<Card> spells = new ArrayList<Card>();
	
	public final Set<Equipment> equipment = new HashSet<Equipment>();
	
	public Wizard target;
	final String name;
	final String description;

	private Set<Equipment> destroyedItems;

	private SupremeWizardryGame game;


	private final List<Effect> effects = new ArrayList<>();



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

	public Wizard(String name, String description, SupremeWizardryGame game ) {
		this.name = name;
		this.description = description;
		this.game = game;
	}

	public void update() {
		currentActionPointExpenditure.update();
		lifePoints.update();
		actionPoints.update();
		vitalityPoints.update();
		strengthPoints.update();
		inteligencePoints.update();
		
		ArrayList< Effect > toRemove = new ArrayList<>();
		
		for ( Effect e : effects ) {
			
			e.update();
			System.out.println( e + " is in effect" );
			
			if ( e.getTurnsLeft() <= 0 ) {
				toRemove.add( e );
			}
		}
		
		for ( Effect e : toRemove ) {
			effects.remove( e );
			System.out.println( e + " is done" );
		}		
	}

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
		card.actOn( this, target);
		spells.remove(card);
		onAction();
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

	public void destroyRandomEquipmentPiece() {
		if ( equipment.size() > 0 ) {
			int randomIndex = (int) (Math.random() * equipment.size());
			Equipment toDestroy = (Equipment) equipment.toArray()[ randomIndex ];
			equipment.remove( toDestroy );
			destroyedItems.add( toDestroy );
		}
	}

	public void repairRandomEquipment() {
		if ( destroyedItems.size() > 0 ) {
			int randomIndex = (int) (Math.random() * destroyedItems.size());
			Equipment toDestroy = (Equipment) destroyedItems.toArray()[ randomIndex ];
			destroyedItems.remove( toDestroy );
			equipment.add( toDestroy );	
		}
	}

	public void takeCardsFromMainPile(int amount) {
		takeCards( amount, game.tableCards );		
	}

	public void restoreActionPoints() {
		actionPoints.setCurrent( actionPoints.getMaximum() );
	}
	
	private void onAction() {
		actionPoints.setCurrent( actionPoints.getCurrentValue() -currentActionPointExpenditure.getCurrentValue() );
	}

	public void addLingeringEffect(FloatRange statAffected, int delta, int turns) {
		Effect effect = new Effect( statAffected, delta, turns );
		effects.add( effect );
	}
}
