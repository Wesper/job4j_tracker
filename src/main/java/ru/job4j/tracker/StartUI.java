package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        String name;
        int id;
        Item item;
        Item[] items;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt(input.askStr("Select: "));
            switch (select) {
                case 0:
                    System.out.println("=== Create a new Item ====");
                    name = input.askStr("Enter name: ");
                    item = new Item(name);
                    tracker.add(item);
                    break;
                case 1:
                    System.out.println("=== All items ====");
                    items = tracker.findAll();
                    for (Item element : items) {
                        System.out.println(element);
                    }
                    break;
                case 2:
                    System.out.println("=== Edit item ====");
                    id = Integer.parseInt(input.askStr("Enter id: "));
                    name = input.askStr("Enter new name: ");
                    item = new Item(name);
                    if (tracker.replace(id, item)) {
                        System.out.println("Success");
                    } else {
                        System.out.println("Error");
                    }
                    break;
                case 3:
                    System.out.println("=== Delete item ====");
                    id = Integer.parseInt(input.askStr("Enter id: "));
                    if (tracker.delete(id)) {
                        System.out.println("Success");
                    } else {
                        System.out.println("Error");
                    }
                    break;
                case 4:
                    System.out.println("=== Find item by id ====");
                    id = Integer.parseInt(input.askStr("Enter id: "));
                    item = new Item();
                    item = tracker.findById(id);
                    if (item == null) {
                        System.out.println("Item not found by this id " + id);
                    } else {
                        System.out.println(item);
                    }
                    break;
                case 5:
                    System.out.println("=== Find items by name ====");
                    name = input.askStr("Enter name: ");
                    items = tracker.findByName(name);
                    if (items.length > 0) {
                        for (Item element : items) {
                            System.out.println(element);
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

}
