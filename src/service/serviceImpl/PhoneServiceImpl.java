package service.serviceImpl;

import db.DataBase;
import model.Phone;
import service.PhoneService;

import java.util.List;

public class PhoneServiceImpl implements PhoneService {
    private DataBase dataBase;

    public PhoneServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addPhone(List<Phone> phones) {
        dataBase.getPhones().addAll(phones);
        return "Phone is successfully added";
    }
    @Override
    public Phone getPhoneById(Long phoneId) {
        List<Phone> list = dataBase.getPhones().stream()
                .filter(phone -> phone.getId() == phoneId)
                .toList();
        return list.get(0);
    }
    @Override
    public Phone updatePhoneNameById(Long phoneId, String newName) {
        dataBase.getPhones().stream()
                .filter(phone ->phone.getId()==phoneId)
                .forEach(phone -> phone.setName(newName));
        return getPhoneById(phoneId);
    }
    @Override
    public List<Phone> getAllPhones() {
        return dataBase.getPhones();
    }
    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        dataBase.getPhones().stream()
                .filter(phone -> phone.getBrand().equalsIgnoreCase(brand))
                .forEach(System.out::println);
        return null;
    }
    @Override
    public void deletePhoneById(Long phoneId) {
        dataBase.getPhones().removeIf(phone -> phone.getId()==phoneId);
        System.out.println("Element is successfully deleted");
    }
}
