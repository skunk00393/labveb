package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.service.BalloonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BalloonController {

    private final BalloonService balloonService;

    public BalloonController(BalloonService balloonService) {
        this.balloonService = balloonService;
    }

    @RequestMapping(value = "/balloons")
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model) {

        return null;
    }

}
