package com.example.demo.model;

import com.example.demo.service.ICustomerService;
import com.example.demo.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.swing.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
public class CustomerDTO implements Validator {
    private int id;
    @NotBlank(message = "Name k được để trống!")
    private String name;
    @NotBlank(message = "Date Of Birth k được để trống!")
    private String dateOfBirth;
    private int gender;
    @NotBlank(message = "Id Card k được để trống!")
    private String idCard;
    private String phoneNumber;
    @Email(message = "Email k đúng định dạng")
    private String email;
    @NotBlank(message = "Address k được để trống!")
    private String address;
    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;
    @OneToMany(mappedBy = "customer")
    private Set<Contract> contracts;
    private List<String> emailList;

    public List<String> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<String> emailList) {
        this.emailList = emailList;
    }

    public CustomerDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customerDTO = (CustomerDTO) target;
        if(!customerDTO.getName().matches("^[A-Z][a-z]*(?: [A-Z][a-z]*)*$") ){
            errors.rejectValue("name","","Tên k được chứa số ,các kí tự đầu tiên của mỗi từ phải viết hoa và có từ 5 đến 50 kí tự");
        }
        if(!customerDTO.getPhoneNumber().matches("^[(][8][4][)][+][9][01]\\d{7}$")){
            errors.rejectValue("phoneNumber","","SĐT k đúng định dạng :(84)+91xxxxxxx");
        }
        if(customerDTO.getEmail().matches("")){
            errors.rejectValue("email","","Email k được để trống");
        }
        for (String email:customerDTO.emailList
             ) {
            if(email.equals(customerDTO.getEmail())){
                errors.rejectValue("email","","Email đã tồn tại");
                break;
            }
        }
    }
}
