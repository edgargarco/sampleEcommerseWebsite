package spring.jpa.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.jpa.example.model.Admin;
import spring.jpa.example.model.Customer;
import spring.jpa.example.service.CustomerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("customer")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/singUp")
    public String registerForm(Model model) {
        model.addAttribute("sellerUser", new Customer());
        return "register";
    }

    @PostMapping("/singUp")
    public String registerCustomer(@Valid @ModelAttribute("sellerUser") Customer customer,
                                   BindingResult bindingResult, Model model, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("sellerUser", customer);
            return "register";
        } else {
            customerService.create(customer);
            httpServletRequest.getSession().setAttribute("sellerUser", customer);
            return "helloworld";
        }
    }

    @GetMapping("/singIn")
    public String hello(Model model, HttpSession httpSession){
        if (httpSession.getAttribute("sellerUser") == null){
            model.addAttribute("action","/customer/singIn");
            return "login";
        }else {
            model.addAttribute("sellerUser",  httpSession.getAttribute("sellerUser"));
            return "helloworld";
        }
    }
    @PostMapping("/singIn")
    public String loginCustomer(Model model,@RequestParam(name = "username") String username,
                                @RequestParam(name = "password") String password,HttpServletRequest httpServletRequest){
        Customer customerAux = customerService.findByEmailAndPassword(username,password);
        if (customerAux != null){
            httpServletRequest.getSession().setAttribute("sellerUser", customerAux);
            return "helloworld";
        }else {
            model.addAttribute("sellerUser", customerAux);
            return "login";
        }
    }








}
