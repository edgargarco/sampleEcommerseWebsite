package spring.jpa.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.jpa.example.model.Admin;
import spring.jpa.example.model.Product;
import spring.jpa.example.model.generics.Color;
import spring.jpa.example.model.generics.Tag;
import spring.jpa.example.repository.ColorRepository;
import spring.jpa.example.repository.TagRepository;
import spring.jpa.example.service.ProductService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;
    private TagRepository tagRepository;
    private ColorRepository colorRepository;


    @Autowired
    public void setProductServiceImpl(ProductService productService) {
        this.productService = productService;
    }
    @Autowired
    public void setTagRepository(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }
    @Autowired
    public void setColorRepository(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @PostMapping("/create")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
                             Model model, HttpSession httpSession, @RequestParam(value = "hidden-color") String[] colors
            , @RequestParam(value = "input-tags") String[] inputTags) {

        Admin sellerUser = (Admin) httpSession.getAttribute("sellerUser");
        if (sellerUser != null) {
            iterateTags(product,inputTags);
            iterateColor(product, colors); // i did this here because of auto binding
            if (bindingResult.hasErrors()) {
                model.addAttribute("sellerUser", sellerUser);
                model.addAttribute("product", product);
                return "registerProduct";
            } else {
                productService.create(product);
                model.addAttribute("sellerUser", sellerUser);
                return "listProducts";
            }
        } else {
            return "redirect:/admin/singIn";
        }

    }

    @GetMapping("/create")
    public String initCreateProduct(Model model, HttpSession httpSession) {
        Object sellerUser = httpSession.getAttribute("sellerUser");
        if (sellerUser == null) {
            return "redirect:/admin/singIn";
        } else {
            model.addAttribute("sellerUser", sellerUser);
            model.addAttribute("product", new Product());
            return "registerProduct";
        }
    }

    @GetMapping("/list")
    public String getAllProducts(Model model, HttpSession httpSession) {
        Object sellerUser = httpSession.getAttribute("sellerUser");
        if (sellerUser == null) {
            return "redirect:/admin/singIn";
        } else {
            model.addAttribute("sellerUser", sellerUser);
            return "listProducts";
        }
    }

    public void iterateTags(Product product,String[] tags){
        if (tags != null){
            for (int i =0; i < tags.length ;i++){
                Tag tag = tagRepository.getTagByNameAnd(tags[i]);
                if (tag == null){
                    Tag tagAux = new Tag(tags[i]);
                    product.addTag(tagAux);
                    tagRepository.save(tagAux);
                }else {
                    product.addTag(tag);
                }

            }
        }
    }
    public void iterateColor(Product product, String[] colors){
        if (colors != null){
            for (int i = 0; i < colors.length ; i++){
                Color color = colorRepository.getColorByName(colors[i]);
                if (color != null){
                    product.addColor(color);
                }
            }
        }
    }







}
