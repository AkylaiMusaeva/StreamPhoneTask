import db.DataBase;
import model.Contact;
import model.Phone;
import service.ContactService;
import service.serviceImpl.ContactServiceImpl;
import service.serviceImpl.PhoneServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**Жаны проект тузунуз.
 3 пакет тузунуз model, db, service.
 model пакеттин ичине Phone жана Contact деген класс тузунуз.
 Phone (id, name, brand, contacts(List)) полелери болуш керек.
 Contact (name, phoneNumber).
 db пакеттин ичинде DataBase класс бар, свойствасы катары телефондордун листин алат, бул класс бизге база данных болот.
 service пакет ичинде PhoneService жана ContactService interface тер болот.
 Ушул 2 interface ти implements кылган 2 класс тузунуз(PhoneServiceImpl жана ContactServiceImpl)ушул 2 класстын ичине свойства катары биздин DataBase класс келсин жана маалыматтарды ошол жактан алып, сактап, очуруп жана башка манипуляция кылсак болот
 PhoneService methods :
 - String addPhone(Phone phone);
 // with stream
 - Phone getPhoneById(int phoneId);
 // with stream
 - Phone updatePhoneNameById(int phoneId, String newName);
 // with stream
 - List<Phone> getAllPhones();
 // with stream
 - List<Phone> getAllPhonesByBrand(String brand);
 - void deletePhoneById(int phoneId);
 10. ContactService methods :
 - String addContactToPhone(int phoneId, Contact contact);
 // with stream (телефонду phoneId мн табып, ичинен контантактардын арасынан contactName мн табып кайтарып берсин)
 - Contact findContactByName(int phoneId, String contactName);
 // with stream
 - Contact findContactByPhoneNumber(int phoneId, String phoneNumber);
 // with stream (телефонду phoneId мн табып, ичинен контантактарды аттарын осуу тартибинде чыгарып берсин)
 -List<Contact>sortContactsByName(int phoneId);
 - void deleteContactByNameFromPhone(int phoneId, String contactName);*/
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num;
        DataBase dataBase=new DataBase();
        PhoneServiceImpl phoneService=new PhoneServiceImpl(dataBase);
        ContactServiceImpl contactService=new ContactServiceImpl(dataBase);
        while(true){
            System.out.println("""
                    1-add phone                     7-add contact to phone
                    2-get phone by id               8-find contact by name
                    3-update phone name by id       9-find contact by phone number
                    4-get all phones                10-sort contacts by name
                    5-get all phones by brand       11-delete contact by name from phone
                    6-delete phone by id            12-add one more contact
                                                    13-add one more contact
                              """);

            switch (num= scanner.nextInt()){
                case 1->System.out.println(phoneService.addPhone(
                        List.of(new Phone(1L, "Samsung J5", "Samsung",new ArrayList<>()),
                                new Phone(2L, "Samsung A-20", "Samsung",new ArrayList<>()),
                                new Phone(2L, "Redmi Note-10", "Xiaomi",new ArrayList<>()),
                                new Phone(3L, "Iphone 8", "Apple",new ArrayList<>()))));

                case 2-> System.out.println(phoneService.getPhoneById(2L));
                case 3-> System.out.println(phoneService.updatePhoneNameById(3L, "Iphone 7"));
                case 4-> System.out.println(phoneService.getAllPhones());
                case 5-> System.out.println(phoneService.getAllPhonesByBrand("Samsung"));
                case 6-> phoneService.deletePhoneById(1L);

                case 7-> System.out.println(contactService.addContactToPhone(1L,
                        new Contact("Mihail", "+996773543669")));
                case 12-> System.out.println(contactService.addContactToPhone(1L,
                        new Contact("Akylai", "+996778507181")));
                case 13-> System.out.println(contactService.addContactToPhone(1L,
                        new Contact("Vladimir", "+996708915871")));

                case 8-> System.out.println(contactService.findContactByName(1L, "Akylai"));
                case 9-> System.out.println(contactService.findContactByPhoneNumber(1L, "+996773543669"));
                case 10-> System.out.println(contactService.sortContactsByName(1L));
                case 11-> contactService.deleteContactByNameFromPhone(1L,"Vladimir");



            }
        }



    }
}