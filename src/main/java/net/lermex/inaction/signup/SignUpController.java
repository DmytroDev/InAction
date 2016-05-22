package net.lermex.inaction.signup;

import net.lermex.inaction.helper.Impl.UserServiceImpl;
import net.lermex.inaction.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class SignUpController {

    private static org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(SignUpController.class);

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView redirectToSignUp() {
        ModelAndView mav = new ModelAndView("signup/signup");
        mav.addObject("signupForm", new User());
        return mav;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String doSignUp(@ModelAttribute("signupForm") User user, BindingResult result,
                           Model model,
                           final RedirectAttributes redirectAttributes,
                           HttpSession session) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("message", "fail");

            return "signup";
        } else {
            model.addAttribute("signupForm",user);
            userService.addUser( new User(user.getEmail(), user.getPassword()) );
            LOG.info("New user successful signup: " + user.getEmail() );
            session.setAttribute("username", user.getEmail());

            return "redirect:/homesignin";
        }
    }

}
