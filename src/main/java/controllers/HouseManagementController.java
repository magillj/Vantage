package controllers;

/**
 * Created by btaylor5 on 12/17/14.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/HM")
public class HouseManagementController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("testMessage", "This message is from LandingPageController!");
        return "HM/hmlanding";
    }
}
