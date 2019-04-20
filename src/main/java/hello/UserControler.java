package hello;

import hello.domain.Role;
import hello.domain.Usr;
import hello.repos.UsrRepo;
import org.hibernate.engine.internal.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserControler {

    @Autowired
    private UsrRepo usrRepo;

    @GetMapping
    public String userlist(Model model) {

        model.addAttribute("users", usrRepo.findAll());
        return "userlist";
    }

    @GetMapping("/{userid}")
    public String userEditForm(
            @PathVariable Usr userid,
            Model model
    ) {
        model.addAttribute("usr", userid);
        model.addAttribute("roles", Role.values());

        return "useredit";
    }

    @PostMapping
    public String savechanges(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") Usr usr
    ) {
        usr.setUsername(username);
        usr.getRoles().clear();

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                usr.getRoles().add(Role.valueOf(key));
            }
        }

        usrRepo.save(usr);

        return "redirect:/user";
    }
}
