package controllers;

/**
 * Created by btaylor5 on 12/17/14.
 */

import DAO.AnnouncementDAO;
import DAO.DutyDAO;
import DAO.model.Announcement;
import DAO.model.Duty;
import DAO.model.NewDuty;
import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

    @RequestMapping(value= {"/GetDuties"}, method = RequestMethod.POST,
            produces="application/json")
    public @ResponseBody
    String getDuties() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("Spring-Module.xml");
        DutyDAO dutyDAO = (DutyDAO) context.getBean("dutyDAO");

        ArrayList<Duty> dutyList = dutyDAO.getActiveDuties();

        String dutyJson = new Gson().toJson(dutyList);
        System.out.println(dutyJson);
        return dutyJson;
    }

    @RequestMapping(value= {"/NewDuty"}, method = RequestMethod.POST)
    public @ResponseBody String newDuty(@ModelAttribute("NewDuty") NewDuty newDuty, BindingResult result, ModelMap p_model) {

        p_model.addAttribute("DutyID", newDuty.getDutyID());
        p_model.addAttribute("DutyName", newDuty.getDutyName());
        p_model.addAttribute("DutyDescription", newDuty.getDutyDesc());
        p_model.addAttribute("Active", newDuty.isActive());
        p_model.addAttribute("FineAmount", newDuty.getFineAmount());
        p_model.addAttribute("TargetedClass", newDuty.getTargetedClass());


        System.out.println("From newDuty()");
        if (result.hasErrors()) {
            System.out.println("BindingResult had errors in newDuty()");
        }

        ApplicationContext context =
                new ClassPathXmlApplicationContext("Spring-Module.xml");

        DutyDAO dutyDAO = (DutyDAO) context.getBean("dutyDAO");

        Duty insertion = new Duty(newDuty.getDutyName(), newDuty.getDutyDesc(), newDuty.isActive(), newDuty.getFineAmount(), newDuty.getTargetedClass());

        dutyDAO.insert(insertion);
        return "Success";
    }

    @RequestMapping(value= {"/EditDuty"}, method = RequestMethod.POST)
    public @ResponseBody
    String editDuty() {
        String result = "Result from /EditDuty";
        return result;
    }


    @RequestMapping(value = {"/Fines", "/Home/HM/Fines", "/Home/Fines"},
            method = RequestMethod.GET)
    public ModelAndView goToFines() {
        ModelAndView model = new ModelAndView();
        model.setViewName("Home/HM/Fines");
        return model;
    }

    @RequestMapping(value = {"/150Request", "/Home/HM/150Request",
            "/Home/150Request"}, method = RequestMethod.GET)
    public ModelAndView goTo150Request() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/Home/HM/150Request");
        return model;
    }
}
