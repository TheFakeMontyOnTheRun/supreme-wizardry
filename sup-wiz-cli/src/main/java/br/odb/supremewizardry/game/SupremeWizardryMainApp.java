package br.odb.supremewizardry.game;

import br.odb.supremewizardry.core.SupremeWizardryGame;

/**
 * 
 */

/**
 * @author monty
 * 
 */
public class SupremeWizardryMainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new SupremeWizardryGame().createDefaultClient().setAppName("Supreme Wizardry")
				.setAuthorName("Daniel Monteiro")
				.setLicenseName("3 Clause BSD").setReleaseYear(2015).start();
	}
}
