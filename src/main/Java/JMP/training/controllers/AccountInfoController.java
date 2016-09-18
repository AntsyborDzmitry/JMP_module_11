package JMP.training.controllers;

import JMP.training.beans.Person;
import JMP.training.factories.AbstractManagerFactory;
import JMP.training.factories.PersonManagerFromDBFactory;
import JMP.training.managers.PersonManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RequestMapping("/accountInfo")
@Controller
public class AccountInfoController {

        private AbstractManagerFactory dbManager = new PersonManagerFromDBFactory();
        private PersonManager pmDB = dbManager.createPersonManager();

        @RequestMapping("/info")
    	public ModelAndView getInfo() {

	        List<Person> persons = pmDB.readAllPerson();
    		return new ModelAndView("accountInfo", "persons", persons);
    	}

        @RequestMapping("/addPage")
       	public String showAddPage(Model model) {
            model.addAttribute("person", new Person());
       		return "addMoney";
       	}

        @RequestMapping("/add")
        public String addMoney(@ModelAttribute("person")  Person newPerson, BindingResult result) {

            Person p = pmDB.readPerson(newPerson.getName());
            int balance = p.getAge();
            newPerson.setAge(balance + newPerson.getAge());
            pmDB.updatePerson(newPerson);
            return "redirect:/accountInfo/info";
        }

        @RequestMapping("/withdrawPage")
        public String showWithdrawPage(Model model) {
            model.addAttribute("person", new Person());
            return "withdrawMoney";
        }

        @RequestMapping("/withdraw")
        public ModelAndView withdrawMoney() {

            return new ModelAndView("withdrawMoney", "person", new Person());
        }
}
