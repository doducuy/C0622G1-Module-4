package calculator.controller;

import calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class CalculatorController {
    @Autowired
    ICalculatorService calculatorService;
    @GetMapping()
    public String calculator(){
        return "index";
    }
    @GetMapping("/calculate")
    public String calculate(@RequestParam(value = "operatorOne") double operatorOne,
                            @RequestParam(value = "operatorTwo") double operatorTwo,
                            @RequestParam(value = "calculation") String calculation,
                            Model model){
        model.addAttribute("result",calculatorService.calculate(operatorOne,operatorTwo,calculation));
        model.addAttribute("operatorOne",operatorOne);
        model.addAttribute("operatorTwo",operatorTwo);
        return "index";
    }

}
