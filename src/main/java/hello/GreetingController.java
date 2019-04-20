package hello;

import hello.domain.Message;
import hello.domain.User;
import hello.domain.Usr;
import hello.repos.MessageRepo;
import hello.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private MessageRepo mRepo;

    @GetMapping("/")
    public String greeting(
//            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main (
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model
    ){
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()){
            messages = mRepo.findByTitle(filter);
        }else {
            messages = mRepo.findAll();
        }

        model.addAttribute("msg", messages);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String addmsg(
            @AuthenticationPrincipal Usr usr,
            @RequestParam String title,
            @RequestParam String body,
            Model model
    ){
        Message message = new Message(title, body, usr);
        mRepo.save(message);

        Iterable<Message> messages = mRepo.findAll();
        model.addAttribute("msg", messages);
        model.addAttribute("title", "kartlos");
        model.addAttribute("filter", "");

        return "main";
    }

}