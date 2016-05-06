package net.lermex.inaction.home;

import net.lermex.inaction.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private TestBean testBean;

	@RequestMapping(value = "/homenotsign")
	//@ResponseBody
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("home/homeNotSignedIn");
		// we may put values to pages via Map (modelAndView)
		modelAndView.addObject("greetings", "Hello my Friend!");
		return modelAndView;
	}

	@RequestMapping(value = "/homesignin")
	@ResponseBody
	public ModelAndView signin() {
		ModelAndView modelAndView = new ModelAndView("home/homeSignedIn");
		// working code bellow
		/*		Foo foo = new Foo();
		foo.setName("TestName");
		foo.setAge(100);
		modelAndView.addObject("foo", foo);
		modelAndView.addObject("test1", "test line :)");*/

		// we may put values to pages via Map (modelAndView)
		return modelAndView;
	}

/*	@RequestMapping(value = "/signup")
	@ResponseBody
	public ModelAndView signup() {
		ModelAndView modelAndView = new ModelAndView("home/homeSignedIn");
		// working code bellow
		*//*		Foo foo = new Foo();
		foo.setName("TestName");
		foo.setAge(100);
		modelAndView.addObject("foo", foo);
		modelAndView.addObject("test1", "test line :)");*//*

		// we may put values to pages via Map (modelAndView)
		return modelAndView;
	}*/

}
