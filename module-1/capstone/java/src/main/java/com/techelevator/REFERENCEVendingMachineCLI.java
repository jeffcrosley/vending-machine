package com.techelevator;

import com.techelevator.view.REFERENCEMenu;

public class REFERENCEVendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private REFERENCEMenu menu;

	public REFERENCEVendingMachineCLI(REFERENCEMenu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
		}
	}

	public static void main(String[] args) {
		REFERENCEMenu menu = new REFERENCEMenu(System.in, System.out);
		REFERENCEVendingMachineCLI cli = new REFERENCEVendingMachineCLI(menu);
		cli.run();
	}
}
