package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        String name;
        int id;
        Item item;
        Item[] items;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 0:
                    System.out.println("=== Create a new Item ====");
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    item = new Item();
                    item.setName(name);
                    tracker.add(item);
                    break;
                case 1:
                    System.out.println("=== All items ====");
                    items = tracker.findAll();
                    for (Item element : items) {
                        System.out.println(element.getId() + " " + element.getName());
                    }
                    break;
                case 2:
                    System.out.println("=== Edit item ====");
                    System.out.print("Enter id: ");
                    id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new name: ");
                    name = scanner.nextLine();
                    item = new Item();
                    item.setName(name);
                    if (tracker.replace(id, item)) {
                        System.out.println("Success");
                    } else {
                        System.out.println("Error");
                    }
                    break;
                case 3:
                    System.out.println("=== Delete item ====");
                    System.out.print("Enter id: ");
                    id = Integer.parseInt(scanner.nextLine());
                    if (tracker.delete(id)) {
                        System.out.println("Success");
                    } else {
                        System.out.println("Error");
                    }
                    break;
                case 4:
                    System.out.println("=== Find item by id ====");
                    System.out.print("Enter id: ");
                    id = Integer.parseInt(scanner.nextLine());
                    item = new Item();
                    item = tracker.findById(id);
                    if (item == null) {
                        System.out.println("Item not found by this id " + id);
                    } else {
                        System.out.println(item.getId() + " " + item.getName());
                    }
                    break;
                case 5:
                    System.out.println("=== Find items by name ====");
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    items = tracker.findByName(name);
                    if (items.length > 0) {
                        for (Item element : items) {
                            System.out.println(element.getId() + " " + element.getName());
                        }
                    } else {
                        System.out.println("Items not found by this name " + name);
                    }
                    break;
                case 6:
                    run = false;
                    break;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }

}
