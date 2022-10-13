package codegym.controller;

import codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping()
public class TranslateController {
    @Autowired
    private IDictionaryService convertCurrencyService;

    @GetMapping
    public String showForm() {
        return "dictionary";
    }

    @PostMapping("/result")
    public String Convert(@RequestParam String eng, Model model){
        model.addAttribute("result",convertCurrencyService.translate(eng));
        model.addAttribute("eng",eng);
        return "dictionary";
    }
}
