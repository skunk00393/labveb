package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.service.BalloonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class BalloonSizeController {

    private final BalloonService balloonService;

    public BalloonSizeController(BalloonService balloonService) {
        this.balloonService = balloonService;
    }

    @RequestMapping(value = "/balloonSize/{id}", method = GET)
    public String getBalloonSizePage(@PathVariable Long id, Model model) {
        Balloon balloon = balloonService.findById(id).orElseThrow(null);
        model.addAttribute("balloonColor",balloon.getDescription());
        model.addAttribute("balloonId", id);
        return "selectBalloonSize";
    }

    @RequestMapping(value = "/balloonSize/{id}", method = POST)
    public String setBalloonSize(@PathVariable Long id ,@RequestParam("size") String size, Model model) {
        Balloon balloon = balloonService.findById(id).orElseThrow(null);
        return "redirect:/getDeliveryInfo/"+id+"/"+size;
    }
}
