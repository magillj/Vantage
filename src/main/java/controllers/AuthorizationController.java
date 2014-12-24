package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by btaylor5 on 12/23/14.
 *
 */

@Controller
@RequestMapping("Login")
public class AuthorizationController {

    @RequestMapping(method = RequestMethod.GET)
    public static String printWelcome(ModelMap model) {
        model.addAttribute("testMessage", "This message is from the Controller!");
        return "authorization/login";

    }


}
