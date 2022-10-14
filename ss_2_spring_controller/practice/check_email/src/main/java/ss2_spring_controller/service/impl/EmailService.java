package ss2.spring.controller.service.impl;

import org.springframework.stereotype.Service;
import ss2.spring.controller.service.IEmailService;
@Service
public class EmailService implements IEmailService {

    @Override
    public String checkEmail(String email) {
        String regex ="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        if(email.matches(regex)){
            return "Email bạn nhập hợp lệ";
        }
        return "Email bạn nhập không hợp lệ";
    }
}
