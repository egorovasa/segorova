package ru.job4j.tracker;

public class Item {
    private String id;
    public String name;
    public String description;
    public long create;
    public String[] comments;

    public Item() {
    }

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name; }

    public long getCreate() {
        return this.create;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

}
