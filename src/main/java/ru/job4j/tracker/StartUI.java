package ru.job4j.tracker;

public class StartUI {

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("one");
        tracker.add(item);
        item = new Item();
        item.setName("two");
        tracker.add(item);
        item = new Item();
        tracker.add(item);
        item = new Item();
        item.setName("three");
        tracker.add(item);
        item = new Item();
        item.setName("one");
        tracker.add(item);
        Item rsl = tracker.findById(1);
        System.out.println("Find by id - " + rsl.getId() + ", " + rsl.getName());
        Item[] rsls = tracker.findByName("one");
        for (int i = 0; i < rsls.length; i++) {
            System.out.println("Find by name - " + rsls[i].getId() + ", " + rsls[i].getName());
        }
        rsls = tracker.findAll();
        for (int i = 0; i < rsls.length; i++) {
            System.out.println("Find all - " + rsls[i].getId() + ", " + rsls[i].getName());
        }
    }
}
