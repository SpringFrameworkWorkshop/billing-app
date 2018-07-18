package io.spring.billing;

import io.spring.commandlinemenu.Menu;
import io.spring.commandlinemenu.MenuBuilder;

import java.util.Scanner;


public class BillingRunner {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String option;


        do {
            option = generateMenu().play();
            if (option != null) {
                switch (option) {
                    case "1.1":
                        System.out.println(ClientManager.getInstance().findAll());
                        break;
                    case "1.2":
                        ClientManager.getInstance().save(clientBuilder());
                        break;
                    case "1.3":
                        ClientManager.getInstance().delete(selectClient());
                        break;
                    case "2.1":
                        System.out.println(ProductManager.getInstance().findAll());
                        break;
                    case "2.2":
                        ProductManager.getInstance().save(productBuilder());
                        break;
                    case "2.3":
                        ProductManager.getInstance().delete(selectProduct());
                        break;
                    case "3.1":
                        System.out.println(BillManager.getInstance().findAll());
                        break;
                    case "3.2":
                        BillManager.getInstance().save(billBuilder());
                        break;
                    case "3.3":
                        BillManager.getInstance().delete(selectBill());
                        break;
                    case "4.1":
                        System.out.println(LineManager.getInstance().findAll());
                        break;
                    case "4.2":
                        LineManager.getInstance().save(lineBuilder());
                        break;
                    case "4.3":
                        LineManager.getInstance().delete(selectLine());
                        break;
                }
            }
        } while (option != null);

        System.out.println("GOOD BYE");

    }

    private static Menu generateMenu() {
        io.spring.commandlinemenu.Menu submenu1 = MenuBuilder.createSubMenu("CLIENTS", 1)
                .addSimpleOption(1, "List")
                .addSimpleOption(2, "New")
                .addSimpleOption(3, "Delete")
                .addExitOption(4, "Back")
                .build();
        Menu submenu2 = MenuBuilder.createSubMenu("PRODUCTS", 2)
                .addSimpleOption(1, "List")
                .addSimpleOption(2, "New")
                .addSimpleOption(3, "Delete")
                .addExitOption(4, "Back")
                .build();
        Menu submenu3 = MenuBuilder.createSubMenu("BILLS", 3)
                .addSimpleOption(1, "List")
                .addSimpleOption(2, "New")
                .addSimpleOption(3, "Delete")
                .addExitOption(4, "Back")
                .build();
        Menu submenu4 = MenuBuilder.createSubMenu("LINES", 4)
                .addSimpleOption(1, "List")
                .addSimpleOption(2, "New")
                .addSimpleOption(3, "Delete")
                .addExitOption(4, "Back")
                .build();

        return MenuBuilder.createMainMenu("BILLING MENU")
                .addSubMenuOption("Clients", submenu1)
                .addSubMenuOption("Products", submenu2)
                .addSubMenuOption("Bills", submenu3)
                .addSubMenuOption("Lines", submenu4)
                .addExitOption(5, "Exit")
                .build();
    }

    private static Client selectClient() {
        //TODO:
        return null;
    }

    private static Product selectProduct() {
        //TODO:
        return null;
    }

    private static Bill selectBill() {
        //TODO:
        return null;
    }

    private static Line selectLine() {
        //TODO:
        return null;
    }

    private static Client clientBuilder() {
        //TODO:
        return null;
    }

    private static Product productBuilder() {
        //TODO:
        return null;
    }

    private static Bill billBuilder() {
        //TODO:
        return null;
    }

    private static Line lineBuilder() {
        //TODO:
        return null;
    }

}
