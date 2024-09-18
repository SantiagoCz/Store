package santiagoczarny.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping(value = { "/", "/home", "/inicio", "/index" })
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        boolean includeScript = true;
        mav.setViewName("fragments/base");
        mav.addObject("title", "Inicio");
        mav.addObject("view", "index/home");
        mav.addObject("includeScript", includeScript);
        return mav;
    }

}
