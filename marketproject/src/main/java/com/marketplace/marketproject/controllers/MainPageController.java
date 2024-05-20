package com.marketplace.marketproject.controllers;
//import jakarta.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;
import com.marketplace.marketproject.models.SupportService;
import com.marketplace.marketproject.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainPageController {
    @Autowired
    private SupportService supportService;
    @GetMapping("/mainpage")
    public String mainpage(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            String user = (String) session.getAttribute("username");
            model.addAttribute("username", user);
            return "mainpage";
        } else {
            return "redirect:/greeting";
        }
    }
    @GetMapping("/mainpage/basket")
    public String basket(HttpSession session, Model model) {
        if (session.getAttribute("username") == null) {
            return "redirect:/greeting";
        }
        else
        {
            return "basket";
        }
    }
    @GetMapping("/mainpage/addresses")
    public String addresses(HttpSession session, Model model) {
        if (session.getAttribute("username") == null) {
            return "redirect:/greeting";
        }
        else return "addresses";
    }
    @GetMapping("/mainpage/techSupport")
    public String techSupport(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            String receiver = (String) session.getAttribute("username");
            String writer = (String) session.getAttribute("username");
            List<Question> questions = supportService.getAllMessages(receiver, writer);
            model.addAttribute("questions", questions);
            return "techSupport";
        }
        else return "redirect:/greeting";
    }
    @RequestMapping(value = "/mainpage/techSupport/addmsg", method = RequestMethod.POST)
    public String submitQuestion(HttpSession session, @RequestParam("question") String question) {
        String writer = (String) session.getAttribute("username");
        String receiver = "Administrator";
        supportService.addMessage(question, writer, receiver);
        return "redirect:/mainpage/techSupport";
    }
}
