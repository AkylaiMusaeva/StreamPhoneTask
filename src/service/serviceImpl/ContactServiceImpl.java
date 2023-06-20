package service.serviceImpl;

import db.DataBase;
import model.Contact;
import model.Phone;
import service.ContactService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContactServiceImpl implements ContactService {
    private DataBase dataBase;

    public ContactServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String toString() {
        return "ContactServiceImpl{" +
                "dataBase=" + dataBase +
                '}';
    }

    @Override
    public String addContactToPhone(Long phoneId, Contact contact) {
        dataBase.getPhones().stream()
                .filter(phone -> phone.getId().equals(phoneId))
                .forEach(phone -> phone.getContacts().add(contact));
        return "Contact is successfully saved to a contact";
    }

    @Override
    public Contact findContactByName(Long phoneId, String contactName) {
        List<Phone> list = dataBase.getPhones().stream()
                .filter(phone -> phone.getId() == phoneId).toList();
        List<Contact>list1=list.get(0).getContacts().stream()
                .filter(contact -> contact.getName().equalsIgnoreCase(contactName)).toList();
        return list1.get(0);
    }
    @Override
    public Contact findContactByPhoneNumber(Long phoneId, String phoneNumber) {
        List<Phone> list = dataBase.getPhones().stream()
                .filter(phone -> phone.getId() == phoneId).toList();
        List<Contact>list1=list.get(0).getContacts().stream()
                .filter(contact -> contact.getPhoneNumber().equalsIgnoreCase(phoneNumber)).toList();
        return list1.get(0);
    }
    @Override
    public List<Contact> sortContactsByName(Long phoneId) {
        List<Phone> list = dataBase.getPhones().stream()
                .filter(phone -> phone.getId() == phoneId).toList();

        List<Contact>list1= new java.util.ArrayList<>(list.get(0).getContacts().stream().toList());
        list1.sort(comparator);
        for (int i = 0; i < list1.size(); i++) {
            list1.get(i).getName();
        }
       return list1;
    }
    Comparator<Contact>comparator=new Comparator<Contact>() {
        @Override
        public int compare(Contact o1, Contact o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    @Override
    public void deleteContactByNameFromPhone(Long phoneId, String contactName) {
        List<Phone> list = dataBase.getPhones().stream()
                .filter(phone -> phone.getId() == phoneId).toList();
        list.get(0).getContacts().removeIf(contact -> contact.getName().equalsIgnoreCase(contactName));
        System.out.println("Contact is successfully deleted.");
    }
}
