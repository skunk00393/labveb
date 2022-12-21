package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class BalloonController {

    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }

    @RequestMapping(value = "/balloons", method = GET)
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("balloons",balloonService.listAll());
        return "listBalloons";
    }

    @RequestMapping(value = "/balloonChosen", method = GET)
    public String redirectToSize(@RequestParam("color") int color){
        return "redirect:/balloonSize/"+color;
    }

    @RequestMapping(value = "/balloons/add", method = POST)
    public String saveBalloon(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("manId") Long manId){
            balloonService.add(name,description,manId);
            return "redirect:/balloons";
    }
    @RequestMapping(value = "/balloons/edit", method = POST)
    public String editBalloon(@RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("manId") Long manId){
        balloonService.edit(id,name,description,manId);
        return "redirect:/balloons";
    }
    @RequestMapping(value = "/balloons/delete/{id}", method = DELETE)
    public String deleteBalloon(@PathVariable Long id){
        if(balloonService.findById(id).isPresent()){
        balloonService.remove(id);
        }
        return "redirect:/balloons";
    }
    @RequestMapping(value = "/balloons/add-form", method = GET)
    public String addBalloonForm(Model model){
        model.addAttribute("balloons",balloonService.listAll());
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("link", "/balloons/add");
        return "add-balloon";
    }
    @RequestMapping(value = "/balloons/edit-form/{id}", method = GET)
    public String deleteBalloonForm(@PathVariable Long id, Model model){
        model.addAttribute("balloon",balloonService.findById(id).get());
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("link", "/balloons/edit");
        return "add-balloon";
    }

}
