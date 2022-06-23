package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @GetMapping("/createpage")
    public String greetingForm(Model model){
        model.addAttribute("createpage", new Page());
        return"createpage";
    }

    @PostMapping("/createpage")
    public String greetingSubmit(@ModelAttribute Page page, Model model){
        model.addAttribute("createpage", page);

        //HERE, we will use the code to save the user info on DB.
        //You can access the user info by for example, page.getUsername() page.getEducation() page.experience()...

        System.out.println(page.getName());
        System.out.println(page.getIntroduction());
        System.out.println(page.getSkill());
        System.out.println(page.getGithub());
        System.out.println(page.getLinkedin());
        System.out.println(page.getResume());
        System.out.println(page.getBio());

        return "result";
    }

    @GetMapping("/page")
    public String page(@RequestParam(name="name", required=false, defaultValue="celina") String name, Model model) {

        /* The variable, name, comes from url. For example, if someone accesses localhost:8080/page?name=celina.
        the name variable here would be "celina". You use this name to query the database.
        to retrieve other information for the page such as education, experiences and etc.
         */

        String education = "PJATK"; // sample data. This data should come from the DB.
        name = "Celina Cywinska";
        String intro = "Welcome to my portfolio page. You can see what I worked on here. \uD83D\uDC4B";
        String skills = "Main Language: Java, Javascript\n" +
                "Library/Framework: React (and react based libs), React Native, Express\n" +
                "Misc: Various Popular DBs, AWS services.";
        String github = "https://github.com/cellinacywinska";
        String linkedin = "https://github.com/cellinacywinska";
        String resume = "https://www.allthingsgrammar.com/uploads/2/3/2/9/23290220/atg-worksheet-so-because20.pdf";
        String bio = "I am currently studying Computer Science at the Polish-Japanese Academy of Information Technology.\n" +
                "My greatest interest is Web Development, but I am currently exploring ML. ";
        String picture = "./images/picture.svg";

        /* You inject values to the page.html through model.addAttribute(<placeholder>, <value>) */
        model.addAttribute("name", name);
        model.addAttribute("introduction", intro);
        model.addAttribute("education", education);
        model.addAttribute("picture", picture);
        model.addAttribute("bio", bio);
        model.addAttribute("skill", skills);
        model.addAttribute("resume", resume);
        model.addAttribute("linkedin", linkedin);
        model.addAttribute("github", github);

        return "page";
    }
}
