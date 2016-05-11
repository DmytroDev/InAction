package net.lermex.inaction.signup;

import net.lermex.inaction.model.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SignUpController {

    // working
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    @ResponseBody // отключает отработку итоговой строки как редирект на страницу. Т.е. передает просто строку.
    public ModelAndView redirectToSignUp() {
        ModelAndView mav = new ModelAndView("signup/signup");
        mav.addObject("signupForm", new User());
        return mav;
    }

    // TODO: need testing and fixing code bellow
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String doSignUp(@ModelAttribute("signupForm") User user, BindingResult result,
                           Model model,
                           final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("message", "fail");
            return "signupForm";
        } else {
            /*HttpSession session = req.getSession();
            session.setAttribute("name", user.getEmail());*/
            //mav = new ModelAndView("redirect:/homesignin");
            // form input is OK

            //redirectAttributes.addFlashAttribute("msg", "User added successfully!");

            User newUser = new User(user.getEmail(), user.getPassword());
            // TODO: save user to container
            // POST/REDIRECT/GET
            return "redirect:/homesignin";
        }

        // process registration...
        //return "Success";
    }

}
