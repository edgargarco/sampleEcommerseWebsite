package spring.jpa.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.jpa.example.model.Product;
import spring.jpa.example.service.ProductService;
import spring.jpa.example.service.impl.ProductServiceImpl;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public void addProduct(@Valid @ModelAttribute("product") Product product) {
        productService.create(product);
    }
    @GetMapping("/create")
    public String initCreateProduct(Model model, HttpSession httpSession){
        Object sellerUser = httpSession.getAttribute("sellerUser");
        if (sellerUser == null){
            return "redirect:/admin/singIn";
        }else {
            model.addAttribute("sellerUser",sellerUser);
            model.addAttribute("product",new Product());
            return "registerProduct";
        }
    }
    @GetMapping("/list")
    public String getAllProducts(Model model, HttpSession httpSession) {
        Object sellerUser = httpSession.getAttribute("sellerUser");
        if (sellerUser == null){
            return "redirect:/admin/singIn";
        }else {
            model.addAttribute("sellerUser",sellerUser);
            return "listProducts";
        }
    }


}
