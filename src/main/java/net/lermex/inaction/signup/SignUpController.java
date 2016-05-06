package net.lermex.inaction.signup;

import net.lermex.inaction.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpController {

    @Autowired
    private TestBean testBean;

    @RequestMapping(value = "/signup")
    @ResponseBody
    public ModelAndView signin() {
        ModelAndView modelAndView = new ModelAndView("signup/signup");
        // working code bellow
		/*		Foo foo = new Foo();
		foo.setName("TestName");
		foo.setAge(100);
		modelAndView.addObject("foo", foo);
		modelAndView.addObject("test1", "test line :)");*/

        // we may put values to pages via Map (modelAndView)
        return modelAndView;
    }
}
