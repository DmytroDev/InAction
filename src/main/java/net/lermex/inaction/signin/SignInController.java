package net.lermex.inaction.signin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignInController {

    @RequestMapping(value = "/authenticate")
    @ResponseBody
    public ModelAndView signin() {
        ModelAndView modelAndView = new ModelAndView("signin/signin");
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
