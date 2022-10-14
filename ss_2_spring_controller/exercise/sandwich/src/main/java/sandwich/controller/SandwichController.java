package sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping()
public class SandwichController {
    @GetMapping
    public String showList(){
        return "index";
    }
    @GetMapping("/condiment")
    public String chooseCondiment(@RequestParam(value = "lettuce", required = false) String lettuce,
                                  @RequestParam(value = "tomato",required = false) String tomato,
                                  @RequestParam(value = "mustard",required = false) String mustard,
                                  @RequestParam(value = "sprouts",required = false) String sprouts, Model model){
        model.addAttribute("lettuce",lettuce);
        model.addAttribute("tomato",tomato);
        model.addAttribute("mustard",mustard);
        model.addAttribute("sprouts",sprouts);
        return "index";
    }
}
