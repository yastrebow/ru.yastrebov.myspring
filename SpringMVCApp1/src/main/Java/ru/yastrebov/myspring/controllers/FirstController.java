package ru.yastrebov.myspring.controllers;

import jdk.internal.icu.text.NormalizerBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage() {
        return "first/ello";
    }
@GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
     //ДЗ Урок 20. Калькулятор
    @GetMapping("/calculator")
    //задаем требования к запросу пользователя
    public String calculartor(@RequestParam("a") int a, @RequestParam("b") int b,
                              @RequestParam("action") String action, Model model){
        double result;

        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / (double)b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "addition":
                result = a + b;
                break;
            default:
               result = 0;
        }

        model.addAttribute("result", result);
        return "first/calculator";
    }
}
