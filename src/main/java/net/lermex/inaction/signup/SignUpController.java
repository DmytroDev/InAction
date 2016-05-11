package net.lermex.inaction.signup;

import net.lermex.inaction.model.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SignUpController {

/*    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView redirectToSignUp() {
        ModelAndView mav = new ModelAndView("signup/signup");
        return mav;
    }*/

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String doSignUp(@ModelAttribute("userForm") User user, BindingResult result,
                           Model model,
                           final RedirectAttributes redirectAttributes) {
        //ModelAndView mav = null;

        if (result.hasErrors()) {
            return "userForm";
        } else {

            /*HttpSession session = req.getSession();
            session.setAttribute("name", user.getEmail());*/
            //mav = new ModelAndView("redirect:/homesignin");
            // form input is OK
            redirectAttributes.addFlashAttribute("css", "success");
            redirectAttributes.addFlashAttribute("msg", "User added successfully!");

            User newUser = new User(user.getEmail(), user.getPassword());
            // TODO: save user to container

            // POST/REDIRECT/GET
            return "redirect:/homesignin";
        }

        // process registration...
        //return "Success";

        //return "Success";
    }



}
