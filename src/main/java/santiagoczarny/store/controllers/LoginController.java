package santiagoczarny.store.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

    @GetMapping("/login")
    public ModelAndView loginForm(Model model,
                                         @RequestParam(name = "error", required = false) String error,
                                         @RequestParam(name = "logout", required = false) String logout) {

        ModelAndView maw = new ModelAndView();
        maw.setViewName("auth/login");
        maw.addObject("title", "Login");
        //maw.addObject("view", "auth/login");
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        maw.addObject("includeLoginFormScript", true);
        return maw;
    }

}
