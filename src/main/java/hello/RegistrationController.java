package hello;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import hello.domain.Role;
import hello.domain.Usr;
import hello.repos.UsrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {


    @Autowired
    private UsrRepo usrRepo;

    @GetMapping("/registration")
    public String registration(Map<String, Object> model){
        model.put("message", "registration");

        return "registration";
    }

    @PostMapping("/registration")
    public String addUsr(Usr usr, Map<String, Object> model){
        Usr usrFromDB = usrRepo.findByUsername(usr.getUsername());

        if(usrFromDB != null){
            model.put("message", "user Exists!");
            return "registration";
        }

        usr.setActive(true);
        usr.setRoles(Collections.singleton(Role.USER));

        usrRepo.save(usr);

        model.put("message", "registration");
        return "redirect:/login";
    }
}
