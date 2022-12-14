package com.codegym.furama.dto;

import com.codegym.furama.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;

public class CustomerDto implements Validator {
    private int id;
    private String nameCustomer;
    private String birthday;
    private boolean gender;
    private String id_card;
    private String phone;
    private String email;
    private String address;
    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(int id, String nameCustomer, String birthday, boolean gender, String id_card, String phone, String email, String address, CustomerType customerType) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.birthday = birthday;
        this.gender = gender;
        this.id_card = id_card;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if (!customerDto.getNameCustomer().matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
            errors.rejectValue("nameCustomer", "nameCustomer", "1.\tT??n kh??ch h??ng kh??ng ???????c ch???a s???. V?? c??c k?? t??? ?????u ti??n c???a m???i t??? ph???i vi???t hoa");
        }
        if (!customerDto.getPhone().matches("^0[0-9]{9}$")) {
            errors.rejectValue("phone", "phone", "S??? ??i???n tho???i kh??ng ???????c ????? tr???ng,ph???i b???t ?????u b???ng 0 v?? c?? 10 s???");
        }
        if (!customerDto.getId_card().matches("[0-9]{5}")) {
            errors.rejectValue("id_card", "id_card", "S??? CMND kh??ng ???????c ????? tr???ng, ph???i l?? 5 s??? v?? kh??ng ???????c ch???a b???t k?? k?? t??? n??o kh??c");
        }
        if (!customerDto.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.rejectValue("email", "email", "Email kh??ng ????ng ?????nh d???ng");
        }
        if (!customerDto.getAddress().matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
            errors.rejectValue("address", "address", "Ghi hoa ch??? c??i ?????u");
        }
        String birthDay = customerDto.getBirthday();
        if (birthDay.matches("")) {
            errors.rejectValue("birthday", "birthday", "Vui l??ng ch???n ng??y sinh");
        } else {

        LocalDate dayOfBirth = LocalDate.parse(birthDay);
        LocalDate now = LocalDate.now();
        Period checkAge = Period.between(dayOfBirth, now);
        if (checkAge.getYears() < 18 | checkAge.getYears() > 100) {
            errors.rejectValue("birthday", "birthday", "Tu???i ph???i l???n h??n ho???c b???ng 18 v?? nh??? h??n 100");
        }
        }
    }
}
