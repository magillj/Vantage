package controllers;

import DAO.MajorDAO;
import DAO.MemberDAO;
import DAO.ParentDAO;
import DAO.TitleDAO;
import DAO.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by btaylor5 on 12/28/14.
 */
@Controller
public class NewAccountControllor {

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("/authorization/signup", "account", new NewAccount());
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public ModelAndView RequestAccount(@ModelAttribute("NewAccount") NewAccount account, BindingResult result, ModelMap p_model)  {

        p_model.addAttribute("FirstName", account.getFirstName());
        p_model.addAttribute("MiddleName", account.getMiddleName());
        p_model.addAttribute("LastName", account.getLastName());
        p_model.addAttribute("Email", account.getEmail());
        p_model.addAttribute("PC", account.getPC());
        p_model.addAttribute("InitiateNumber", account.getInitiationNumber());
        p_model.addAttribute("CellNumber", account.getCellNumber());
        p_model.addAttribute("HighSchool", account.getCellNumber());
        p_model.addAttribute("HomeAddress", account.getHomeAddress());
        p_model.addAttribute("Major", account.getMajor());
        p_model.addAttribute("Password", account.getPassword());
        p_model.addAttribute("Title", account.getTitle());
        p_model.addAttribute("ParentFname", account.getParentFname());
        p_model.addAttribute("ParentLname", account.getParentLname());
        p_model.addAttribute("ParentEmail", account.getParentEmail());
        p_model.addAttribute("MagicPhrase", account.getMagicPhrase());



        ModelAndView model = new ModelAndView();

        if (result.hasErrors()) {
            model.setViewName("/authorization/signup");
            return model;
        }

        if (p_model.get("MagicPhrase").equals("P455W()RD_1$_T4K()!&#P3N!$OK4Y")) {

            ApplicationContext context =
                    new ClassPathXmlApplicationContext("Spring-Module.xml");

            MemberDAO memberDAO = (MemberDAO) context.getBean("memberDAO");
            ParentDAO parentDAO = (ParentDAO) context.getBean("parentDAO");
            TitleDAO titleDAO = (TitleDAO) context.getBean("titleDAO");
            MajorDAO majorDAO = (MajorDAO) context.getBean("majorDAO");

            //If the title is not found it will insert it, returning the ID
            int titleID = titleDAO.lookUpOrInsert(account.getTitle());


            Parent parent2 = new Parent(titleID, account.getParentFname(), account.getParentLname(), account.getParentEmail());
            parentDAO.insert(parent2);
            int parentID = parentDAO.lookUpIDByEmail(account.getParentEmail());

            int majorID = majorDAO.lookUpOrInsert(account.getMajor());


            byte[] salt = Member.generateSalt();
            byte[] password = Member.hashIt(account.getPassword() + salt);


            Member member = new Member(account.getFirstName(), account.getMiddleName(), account.getLastName(), account.getEmail(),
                    account.getPC(), account.getInitiationNumber(), account.getCellNumber(), account.getHighSchool(), account.getHomeAddress(), parentID, majorID, password, salt);
            memberDAO.insert(member);
            
            int memberID = memberDAO.lookUpMemberByEmail(account.getEmail());

            if (memberID == 0) {
                model.addObject("error", "Account Was Not Made. Contact an admin to Help you!");

            }
        } else {
            model.addObject("error", "Magic Phrase Was Wrong.");
        }

        model.setViewName("/authorization/login");
        return model;
    }
}
