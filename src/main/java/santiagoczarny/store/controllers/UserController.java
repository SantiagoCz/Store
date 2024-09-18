package santiagoczarny.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import santiagoczarny.store.services.PersonService;
import santiagoczarny.store.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PersonService personService;

    @GetMapping(value = {"/new"})
    public ModelAndView newUser() {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/base");
        mav.addObject("title", "Registrar Usuario");
        mav.addObject("view", "createForms/user-form");
        mav.addObject("includeScript", true);
        return mav;
    }

}
