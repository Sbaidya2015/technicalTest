package coding.assignment.web.controller.home;

import coding.assignment.domain.person.Person;
import coding.assignment.domain.person.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.Validator;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    PersonRepo personRepo;
    @Autowired
    @Qualifier("PersonValidator")
    private Validator validator;

    @RequestMapping("/")
    public String home(ModelMap model) {

        model.addAttribute("command", new Person());
        // model.addAttribute("commandName", "person");
        return "welcome";
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "/welcome";
        } else {
            personRepo.save(person);
            return "redirect:/viewperson";//will redirect to viewemp request mapping
        }

    }


    @RequestMapping("/viewperson")
    public String viewPersons(Model m) {
        m.addAttribute("list", personRepo.findAll());
        return "viewperson";
    }


}
