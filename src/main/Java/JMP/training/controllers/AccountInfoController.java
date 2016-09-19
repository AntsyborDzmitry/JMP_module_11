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
            if (p != null){
                int balance = p.getBalance();
                newPerson.setBalance(balance + newPerson.getBalance());
                pmDB.updatePerson(newPerson);
            }
            return "redirect:/accountInfo/info";
        }

        @RequestMapping("/withdrawPage")
        public String showWithdrawPage(Model model) {
            model.addAttribute("person", new Person());
            return "withdrawMoney";
        }

        @RequestMapping("/withdraw")
        public String withdrawMoney(@ModelAttribute("person")  Person newPerson, BindingResult result) {
            Person p = pmDB.readPerson(newPerson.getName());
            if (p != null){
                int balance = p.getBalance();
                int newBalance = balance - Math.abs(newPerson.getBalance());
                if (newBalance >= 0) {
                    newPerson.setBalance(newBalance);
                    pmDB.updatePerson(newPerson);
                }
            }
            return "redirect:/accountInfo/info";
        }
        @RequestMapping("/createPage")
        public String showCreatePage(Model model) {
            model.addAttribute("person", new Person());
            return "createAccount";
        }

        @RequestMapping("/create")
        public String createAccount(@ModelAttribute("person")  Person newPerson, BindingResult result) {
           Person p = pmDB.readPerson(newPerson.getName());

           if (p == null) {
               pmDB.writePerson(newPerson);
           }
           return "redirect:/accountInfo/info";
        }
}
