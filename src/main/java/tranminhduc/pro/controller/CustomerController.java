package tranminhduc.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tranminhduc.pro.model.Customer;
import tranminhduc.pro.model.Province;
import tranminhduc.pro.service.CustomerService;
import tranminhduc.pro.service.ProvinceService;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ProvinceService provinceService;
    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }
    @Autowired
    public CustomerService customerService;
    @GetMapping("/haha")
    public String testDisplay(){
        return "customer/test";
    }
    @GetMapping("/hahaha")
    public ModelAndView displayCreateForm(){
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }
    @PostMapping("/guivecreate")
    public ModelAndView save(@ModelAttribute Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/create");

        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message","ok, customer has been created");
        return modelAndView;
    }
    @GetMapping("/customers")
    public ModelAndView listCustomer(){
        Iterable<Customer> customers = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        if(customer != null){
            ModelAndView modelAndView = new ModelAndView("customer/edit");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("customer/error.404");
            return modelAndView;
        }
    }
    @PostMapping("edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "updated");
        return modelAndView;

    }
    @GetMapping("/tranminhduccz/{id}")
    public ModelAndView showdeleteCustommer(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        if(customer !=null){
            ModelAndView modelAndView = new ModelAndView("customer/delete");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        }
        else {
            ModelAndView modelAndView = new ModelAndView("customer/error.404");
            return modelAndView;
        }

    }
    @PostMapping("dropcz")
    public String deleteCustomer(@ModelAttribute Customer customer){
        customerService.remove(customer.getId());
        return "redirect:customers";
    }


}
