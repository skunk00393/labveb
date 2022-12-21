package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.model.Balloon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class BalloonOrderController {

    private final BalloonService balloonService;

    public BalloonOrderController(BalloonService balloonService) {
        this.balloonService = balloonService;
    }

    @RequestMapping(value = "/getDeliveryInfo/{id}/{size}", method = GET)
    public String getOrderPage(@PathVariable Long id, @PathVariable String size, Model model){
        Balloon balloon = balloonService.findById(id).orElseThrow(null);
        model.addAttribute("balloonColor",balloon.name);
        model.addAttribute("balloonSize",size);
        return "deliveryInfo";
    }

    @RequestMapping(value = "/getDeliveryInfo/{id}/{size}", method = POST)
    public String setClientData(HttpServletRequest req,@PathVariable Long id, @PathVariable String size, @RequestParam("clientName") String name, @RequestParam("clientAddress") String address, Model model){
        Balloon balloon = balloonService.findById(id).orElseThrow(null);
        model.addAttribute("balloonColor",balloon.name);
        model.addAttribute("balloonSize",size);
        model.addAttribute("clientName", name);
        model.addAttribute("clientAddress",address);
        model.addAttribute("ipAddress", req.getRemoteAddr());
        model.addAttribute("browser", req.getHeader("User-Agent"));
        return "confirmationInfo";
    }
}
