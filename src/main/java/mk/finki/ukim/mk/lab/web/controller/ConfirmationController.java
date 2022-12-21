package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.model.Balloon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ConfirmationController {

    private final BalloonService balloonService;

    public ConfirmationController(BalloonService balloonService) {
        this.balloonService = balloonService;
    }

    @RequestMapping(value = "/getOrderInfo/{id}/{size}", method = GET)
    public String getOrderPage(@PathVariable Long id, @PathVariable String size, Model model){
        Balloon balloon = balloonService.findById(id).orElseThrow(null);
        model.addAttribute("balloonColor",balloon.name);
        model.addAttribute("balloonSize",size);
        return "confirmationInfo";
    }
}
