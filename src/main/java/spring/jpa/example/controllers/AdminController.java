package spring.jpa.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.jpa.example.model.Admin;
import spring.jpa.example.model.Customer;
import spring.jpa.example.repository.AdminRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private AdminRepository adminRepository;

    @Autowired
    public void setAdminRepository(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @GetMapping("singIn")
    public String hello(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("sellerUser") == null) {
            model.addAttribute("action", "/admin/singIn");
            return "login";
        } else {
            model.addAttribute("sellerUser", httpSession.getAttribute("sellerUser"));
            return "redirect:/admin/dashBoardSeller";
        }
    }

    @PostMapping("/singIn")
    public String loginCustomer(Model model, @RequestParam(name = "username") String username,
                                @RequestParam(name = "password") String password, HttpServletRequest httpServletRequest) {
        Admin admin = adminRepository.findByEmailAndPassword(username, password);

        if (admin != null) {
            httpServletRequest.getSession().setAttribute("sellerUser", admin);
            return "redirect:/admin/dashBoardSeller";
        } else {
            model.addAttribute("sellerUser", admin);
            return "login";
        }
    }

    @GetMapping("/dashBoardSeller")
    public String main(Model model, HttpSession httpSession) {
        return checkSession(httpSession.getAttribute("sellerUser"),"mainPageSeller","redirect:/admin/singIn",model);
    }

    @GetMapping("/client/list")
    public String getAllClients(Model model, HttpSession httpSession) {
        return checkSession(httpSession.getAttribute("sellerUser"),"listProducts","redirect:/admin/singIn",model);
    }
    @GetMapping("/inbox")
    public String getInbox(Model model, HttpSession httpSession){
        return checkSession(httpSession.getAttribute("sellerUser"),"inbox","redirect:/admin/singIn",model);
    }

    @GetMapping("/closeSession")
    public String destrySession(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().invalidate();
        return "redirect:/admin/singIn";
    }
    public String checkSession(Object sessionObject,String goesTo,String redirectsTo,Model model){
        if (sessionObject == null) {
            return redirectsTo;
        } else {
            model.addAttribute("sellerUser", sessionObject);
            return goesTo;
        }

    }

}
