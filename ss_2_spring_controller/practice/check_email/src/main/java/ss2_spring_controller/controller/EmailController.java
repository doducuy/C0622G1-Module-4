package ss2_spring_controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ss2_spring_controller.service.IEmailService;

@Controller
@RequestMapping()
public class EmailController {
    @Autowired
    private IEmailService emailService;

    @GetMapping("/check")
    public String checkEmail(@RequestParam(value = "email") String email, Model model){
        model.addAttribute("result",emailService.checkEmail(email));
        model.addAttribute("email",email);
        return "index";
    }
    @GetMapping()
    public String checkEmail(){
        return "index";
    }

}
