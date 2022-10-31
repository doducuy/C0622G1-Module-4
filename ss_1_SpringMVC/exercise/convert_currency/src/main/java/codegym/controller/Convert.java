package codegym.controller;

import codegym.service.IConvertCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping()
public class Convert {
    @Autowired
    private IConvertCurrencyService convertCurrencyService;

    @GetMapping
    public String showForm() {
        return "convert";
    }
    @PostMapping("/result")
    public String Convert(@RequestParam("usd") double usd, @RequestParam double rate, Model model){
        model.addAttribute("result",convertCurrencyService.Convert(usd,rate));
        model.addAttribute("usd",usd);
        model.addAttribute("rate",rate);
        return "convert";
    }
}
