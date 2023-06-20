package model;

import java.util.ArrayList;
import java.util.List;

public class Phone {
    private Long id;
    private String name;
    private String brand;
    private List<Contact> contacts;
    public Phone(){

    }

    public Phone(Long id, String name, String brand) {
        this.id = id;
        this.name = name;
        this.brand = brand;
    }

    public Phone(Long id, String name, String brand, List<Contact> contacts) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.contacts = contacts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
    public void setContact(Contact contact){
        if(this.contacts==null){
            this.contacts=new ArrayList<>();
        }
        this.contacts.add(contact);
    }
    @Override
    public String toString() {
        return "\nPhone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
