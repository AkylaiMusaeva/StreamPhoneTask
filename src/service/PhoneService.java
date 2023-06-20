package service;

import model.Phone;

import java.util.List;

public interface PhoneService {
    String addPhone(List<Phone> phones);
    Phone getPhoneById(Long phoneId);// with stream
    Phone updatePhoneNameById(Long phoneId, String newName);// with stream
    List<Phone> getAllPhones();// with stream
    List<Phone> getAllPhonesByBrand(String brand);// with stream
    void deletePhoneById(Long phoneId);



}
