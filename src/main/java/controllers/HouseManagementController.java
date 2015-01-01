package controllers;

/**
 * Created by btaylor5 on 12/17/14.
 */

import DAO.model.Duty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;


@Controller
@RequestMapping(value = {"/HM", "Home/HM", "Home/hm" })
public class HouseManagementController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("testMessage", "This message is from LandingPageController!");
        return "/Home/HM/hmlanding";
    }

    @RequestMapping(value = {"/Duties", "/Home/HM/Duties", "/Home/Duties"}, method = RequestMethod.GET)
    public ModelAndView goToDuties() {
        ModelAndView model = new ModelAndView();
        model.setViewName("Home/HM/Duties");
        return model;
    }

    @RequestMapping(value= {"/GetDuties"}, method = RequestMethod.POST)
    public @ResponseBody
    String getDuties() {
        ArrayList<Duty> dutyList = new ArrayList<Duty>();

        String result = "Result from HouseManagementController";
        return result;
    }

    @RequestMapping(value= {"/NewDuty"}, method = RequestMethod.POST)
    public @ResponseBody
    String newDuty() {
        String result = "Result from HouseManagementController";
        return result;
    }

    @RequestMapping(value= {"/EditDuty"}, method = RequestMethod.POST)
    public @ResponseBody
    String editDuty() {
        String result = "Result from HouseManagementController";
        return result;
    }


    @RequestMapping(value = {"/Fines", "/Home/HM/Fines", "/Home/Fines"}, method = RequestMethod.GET)
    public ModelAndView goToFines() {
        ModelAndView model = new ModelAndView();
        model.setViewName("Home/HM/Fines");
        return model;
    }

    @RequestMapping(value = {"/150Request", "/Home/HM/150Request", "/Home/150Request"}, method = RequestMethod.GET)
    public ModelAndView goTo150Request() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/Home/HM/150Request");
        return model;
    }
}
