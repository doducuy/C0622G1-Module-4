package com.example.demo.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserDto implements Validator {
    private int id;
    private String name;
    private String email;
    private Integer age;
    private String phoneNumber;

    public UserDto() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        if (!userDto.getName().matches("^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,50}$")){
            errors.rejectValue("name","name.forbidden","Tên phải đúng định dạng !");
        }
        if (!(userDto.getAge() >= 18)){
            errors.rejectValue("age","","Phải trên 18 tuổi!");
        }
        if (!userDto.getEmail().matches("[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)")){
            errors.rejectValue("email","","Không đúng định dạng !");
        }
        if (!userDto.getPhoneNumber().matches("[0][0-9]{9}")){
            errors.rejectValue("phoneNumber","","Số điện thoại không đúng định dạng !");
        }
    }
}
