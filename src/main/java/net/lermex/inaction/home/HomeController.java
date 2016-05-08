package net.lermex.inaction.home;

import net.lermex.inaction.TestBean;
import net.lermex.inaction.model.entity.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class HomeController {

	@Autowired
	private TestBean testBean;

	// Well done!!!
	@RequestMapping(value = "/homenotsign", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("home/homeNotSignedIn");
		Statistics stat = new Statistics();
		List<Integer> statistics = Arrays.asList(1, 2, 3, 4, 5);
		stat.setStatisticsList(statistics);
		mav.addObject("statistics", stat);
		return mav;
	}

	@RequestMapping(value = "/homesignin", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView signin() {
		ModelAndView mav = new ModelAndView("home/homeSignedIn");

		// working code bellow
		/*		Foo foo = new Foo();
		foo.setName("TestName");
		foo.setAge(100);
		modelAndView.addObject("foo", foo);
		modelAndView.addObject("test1", "test line :)");*/

		// we may put values to pages via Map (modelAndView)
		return mav;
	}

	@RequestMapping(value = "/updatestatistics", method = RequestMethod.GET)
	@ResponseBody
	public void updatestatistics(HttpServletResponse resp) throws IOException {
		PrintWriter writer = resp.getWriter();
		writer.print("[3,3,3,3,3]");

/*
		ModelAndView mav = new ModelAndView("home/homeNotSignedIn");
		Statistics stat = new Statistics();
		List<Integer> statistics = Arrays.asList(1, 2, 3, 4, 5);
		stat.setStatisticsList(statistics);
		mav.addObject("statistics", stat);
*/

		/*return new ModelAndView("redirect:/login");*/
/*		ModelAndView mav = new ModelAndView("home/homeNotSignedIn");
		List<Integer> statisticList = generateStatistic();
		mav.addObject("statisticList", statisticList);
		return mav;*/
/*		Statistics statistics = new Statistics();
		statistics.setStatistics(generateStatistic());
		modelAndView.addObject("statistics", statistics);*/
	}



	@RequestMapping(value = "/updatestatistics1", method = RequestMethod.GET)
	@ResponseBody
	public void updatestatistics1(HttpServletResponse resp) {
	//public void updatestatistics() {
		try {
			PrintWriter writer = resp.getWriter();
			/// ....
			writer.print("...");

		} catch (IOException e) {
			e.printStackTrace();
		}

		//ModelAndView modelAndView = new ModelAndView("home/homeNotSignedIn");
/*		Statistics statistics = new Statistics();
		statistics.setStatistics(generateStatistic());
		modelAndView.addObject("statistics", statistics);*/
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


	public List<Integer> generateStatistic(){
		Random random = new Random();
		List<Integer> statisticList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			statisticList.add(random.nextInt(6));
		}
		return statisticList;
	}
}
