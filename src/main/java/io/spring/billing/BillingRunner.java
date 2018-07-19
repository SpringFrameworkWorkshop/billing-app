package io.spring.billing;

import io.spring.billing.entities.Bill;
import io.spring.billing.entities.Client;
import io.spring.billing.entities.Line;
import io.spring.billing.entities.Product;
import io.spring.billing.manager.BillManager;
import io.spring.billing.manager.ClientManager;
import io.spring.billing.manager.LineManager;
import io.spring.billing.manager.ProductManager;
import io.spring.commandlinemenu.Menu;
import io.spring.commandlinemenu.MenuBuilder;

import java.util.Scanner;

import static java.lang.System.exit;


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

        exit(0);

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
        System.out.println(ClientManager.getInstance().findAll());
        System.out.println("Select an element of the list");
        int element = in.nextInt();
        return ClientManager.getInstance().get(element);
    }

    private static Product selectProduct() {
        System.out.println(ProductManager.getInstance().findAll());
        System.out.println("Select an element of the list");
        int element = in.nextInt();
        return ProductManager.getInstance().get(element);
    }

    private static Bill selectBill() {
        System.out.println(BillManager.getInstance().findAll());
        System.out.println("Select an element of the list");
        int element = in.nextInt();
        return BillManager.getInstance().get(element);
    }

    private static Line selectLine() {
        System.out.println(LineManager.getInstance().findAll());
        System.out.println("Select an element of the list");
        int element = in.nextInt();
        return LineManager.getInstance().get(element);
    }

    private static Client clientBuilder() {
        System.out.println("Set the name value");
        String name = in.nextLine();
        System.out.println("Set the surname value");
        String surname = in.nextLine();
        System.out.println("Set the  email value");
        String email = in.nextLine();

        final Client client = new Client();
        client.setName(name);
        client.setSurname(surname);
        client.setEmail(email);
        return client;
    }

    private static Product productBuilder() {
        System.out.println("Set the name value");
        String name = in.nextLine();
        System.out.println("Set the price value");
        Double price = in.nextDouble();

        final Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        return product;
    }

    private static Bill billBuilder() {
        System.out.println("Set the description value");
        String description = in.nextLine();
        System.out.println("Set the observation value");
        String observation = in.nextLine();
        System.out.println("Set the client id value");
        Long client = in.nextLong();

        final Bill bill = new Bill();
        bill.setDescription(description);
        bill.setObservation(observation);
        bill.setClient(ClientManager.getInstance().get(client));
        return bill;
    }

    private static Line lineBuilder() {
        System.out.println("Set the quantity value");
        Integer quantity = in.nextInt();
        System.out.println("Set the product id value");
        Long product = in.nextLong();
        System.out.println("Set the bill id value");
        Long bill = in.nextLong();

        final Line line = new Line();
        line.setQuantity(quantity);
        line.setProduct(ProductManager.getInstance().get(product));
        line.setBill(BillManager.getInstance().get(bill));
        return line;
    }

}
