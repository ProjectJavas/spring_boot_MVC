package com.setect.spring_mvc.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.tomcat.util.http.fileupload.FileUpload;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.setect.spring_mvc.models.FileUploadUtil;
import com.setect.spring_mvc.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
// @RestController
@RequestMapping("/product/")
public class ProductController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("index")
    public String index(Model model) {
        try {
            model.addAttribute("data", "sok");
            model.addAttribute("product", Product.productList1);

        } catch (Exception e) {
            log.error("Error Product:" + e.getMessage(), e);
            model.addAttribute("error", e.getMessage());
        }
        return "pages/product/index";

    }

    @GetMapping("create")
    public String create(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "pages/product/create";
    }

    @PostMapping("post")
    public String post(@ModelAttribute("product") Product product, @RequestParam("file") MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            String uploadDir = "photos/";
            FileUploadUtil.saveFile(uploadDir, fileName, file);
            Product.productList1.add(product);
        } catch (Exception e) {
            log.error("Error Product:" + e.getMessage());
        }

        return "pages/product/create";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        for (var col : Product.productList1) {
            if (col.getId() == id) {
                model.addAttribute("product", col);
            }
        }

        return "pages/product/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable int id, @ModelAttribute("product") Product product) {
        for (var col : Product.productList1) {
            if (col.getId() == id) {
                col.setName(product.getName());
            }
        }

        return "redirect:/product/edit/" + id;
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        try {
            for (var col : Product.productList1) {
                if (col.getId() == id) {
                    Product.productList1.remove(col);
                }
            }
        } catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }
        return "redirect:/product/index";
    }

}
