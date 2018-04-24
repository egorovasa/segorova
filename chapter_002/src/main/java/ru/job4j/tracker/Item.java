package ru.job4j.tracker;

public class Item {
    private String id;
    public String name;
    public String description;
    /*public String create;
    public String[] comments;*/

    public Item() {
    }
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name; }
    /*public String getCreate() {
        return this.create;
    }*/
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

}