package net.lermex.inaction.home;

import net.lermex.inaction.helper.UsersContainer;
import net.lermex.inaction.model.entity.Statistics;
import net.lermex.inaction.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class HomeController {

/*    @Autowired
    private TestBean testBean;*/

    @Autowired
    private UsersContainer container;

    @Autowired
    private Statistics stat;

    // working
    @RequestMapping(value = "/homenotsign", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("home/homeNotSignedIn");
        stat.generateStatistic();
        mav.addObject("statistics", stat);
        return mav;
    }

    // working
    @RequestMapping(value = "/updatestatistics", method = RequestMethod.GET)
    @ResponseBody
    public void updatestatistics(HttpServletResponse resp) throws IOException {
        stat.generateStatistic();
        List<Integer> statisticsList = stat.getStatisticsList();
        PrintWriter writer = resp.getWriter();
        writer.print(statisticsList.toString());
    }

    // working
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ModelAndView doLogin(@RequestParam String username,
                                @RequestParam String password,
                                HttpServletRequest req) {

        List <User> users = container.getUserList();

        if (container.isCredentialsValid(username, password, users)) {
            HttpSession session = req.getSession();
            session.setAttribute("name", username);
            return new ModelAndView("redirect:/homesignin");
        } else {
            ModelAndView mav = new ModelAndView("signin/signin");
            mav.addObject("isvalid", false);
            return mav;
        }
    }

    // working
    @RequestMapping(value = "/homesignin", method = RequestMethod.GET)
    public ModelAndView doSignIn() {

        ModelAndView mav = new ModelAndView("home/homeSignedIn");
        stat.generateStatistic();
        mav.addObject("statistics", stat);
        return mav;
    }

}



