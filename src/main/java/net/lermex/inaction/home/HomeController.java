package net.lermex.inaction.home;

import net.lermex.inaction.helper.Impl.UserServiceImpl;
import net.lermex.inaction.helper.UserContainer;
import net.lermex.inaction.model.entity.Statistics;
import net.lermex.inaction.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class HomeController {

/*    @Autowired
    private TestBean testBean;*/

    private static org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private Statistics stat;

    // @Inject(RS-3.. (JEE)) similar @Autowired (Spring)
    @Inject
    private UserContainer userContainer;

    @RequestMapping(value = {"/", "/homenotsign"}, method = RequestMethod.GET)
    public ModelAndView index(HttpSession session) {
        ModelAndView mav = new ModelAndView("home/homeNotSignedIn");
        stat.generateStatistic();
        mav.addObject("statistics", stat);
        session.setAttribute("username", "guest");
        return mav;
    }

    @RequestMapping(value = "/updatestatistics", method = RequestMethod.GET)
    @ResponseBody
    public void updatestatistics(HttpServletResponse resp) throws IOException {
        stat.generateStatistic();
        List<Integer> statisticsList = stat.getStatisticsList();
        PrintWriter writer = resp.getWriter();
        writer.print(statisticsList.toString());
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ModelAndView doLogin(@RequestParam String username,
                                @RequestParam String password,
                                HttpSession session) {
        List <User> users = userService.getAll();
        if (userContainer.areCredentialsValid(username, password, users) ) {
            LOG.info("User: [" + username + "] successful signin");
            session.setAttribute("username", username);
            return new ModelAndView("redirect:/homesignin");
        } else {
            ModelAndView mav = new ModelAndView("signin/signin");
            mav.addObject("isvalid", false);
            return mav;
        }
    }

    @RequestMapping(value = "/homesignin", method = RequestMethod.GET)
    public ModelAndView doSignIn() {
        ModelAndView mav = new ModelAndView("home/homeSignedIn");
        stat.generateStatistic();
        mav.addObject("statistics", stat);
        return mav;
    }

}



