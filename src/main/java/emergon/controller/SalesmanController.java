package emergon.controller;

import emergon.entity.Family;
import emergon.entity.Salesman;
import emergon.service.FamilyService;
import emergon.service.SalesmanService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/salesman")
public class SalesmanController {

    @Autowired
    private SalesmanService service;
    
    @Autowired
    private FamilyService familyService;

    //---------------------------------------------------------------------------------------    
    @RequestMapping
    public ModelAndView showSalesmen(ModelAndView modelAndView) {
        List<Salesman> salesmen = service.getSalesmen();
        modelAndView.addObject("listOfSalesmen", salesmen);
        // return the path where the jsp page exists. 
        // WEB-INF/views/salesman/salesmanList.jsp
        // Το όνομα του φακέλου. 
        modelAndView.setViewName("salesman/salesmanList"); //<----------
        return modelAndView;
    }
    //---------------------------------------------------------------------------------------    
    
    
    //---------------------------------------------------------------------------------------    
    /**
     * URLs /salesman/create : GET (salesmanList.jsp - link) /salesman/create :
     * POST (salesmanForm.jsp - form)
     */
    
    // Δηλαδή όταν έρχεται σε αυτόν τον controller και εμφανίζουμε την φόρμα μας, τότε μέσα στην
    // φόρμα θέλουμε να βάλουμε από πίσω και ένα άδειο αντικείμενο Salesman.
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(@ModelAttribute("poliths") Salesman salesman) {
        return "salesman/salesmanForm";
    }
    //---------------------------------------------------------------------------------------    

    
    //---------------------------------------------------------------------------------------    
    // Εδώ διαβάζουμε το  @ModelAttribute   
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("poliths") Salesman salesman, 
            BindingResult result, 
            RedirectAttributes attributes) {
        
        
        if(result.hasErrors()){
            return "salesman/salesmanForm";
        }
        
        service.saveSalesman(salesman);
        String minima = "Salesman " + salesman.getSname() + " successfully created!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/salesman";//Redirect instructs client to sent a new GET request to /salesman
    }
    //---------------------------------------------------------------------------------------    
    
    
    //---------------------------------------------------------------------------------------    
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes attributes) {
        
        String minima;
        service.deleteSalesman(id);
        minima = "Salesman deleted successfully!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/salesman";
    }
    //---------------------------------------------------------------------------------------        
    
    
    //---------------------------------------------------------------------------------------    
    //localhost:8080/MySpringMVCApp/salesman/update/30
    @GetMapping("/update/{scode}")
    public String showFormUpdate(@PathVariable("scode") int scode, Model model) {
        Salesman salesman = service.getSalesmanById(scode);
        model.addAttribute("poliths", salesman); //<----------ΠΟΛΙΤΗΣ - poliths
        return "salesman/salesmanForm";
    }
    //---------------------------------------------------------------------------------------    
    
    
    //---------------------------------------------------------------------------------------    
    // Εδώ διαβάζουμε το  @ModelAttribute.    
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("poliths")Salesman salesman,
            BindingResult result,
            RedirectAttributes attributes) {
        
        if(result.hasErrors()){
            return "salesman/salesmanForm";
        }
        service.saveSalesman(salesman);
        String minima = "Salesman updated successfully!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/salesman";
    }
    //---------------------------------------------------------------------------------------    
       
    
    //---------------------------------------------------------------------------------------    
    // @ModelAttribute σε επίπεδο μεθόδου.
    // Για να φορτώσω το drop down menu στο Cities στο SalesmanFrom.jsp
    @ModelAttribute(name = "listOfCities")
    public List<String> getCities() {
        return service.getCities();
    }
    //---------------------------------------------------------------------------------------    

    
    
    
    //---------------------------------------------------------------------------------------    
    // @ExceptionHandler     
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleDataIntegrityViolationException(RedirectAttributes attributes) {
        String minima = "Could not commit transaction!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/salesman";
    }
    //---------------------------------------------------------------------------------------    
    
    
    
    
    //---------------------------------------------------------------------------------------   
    // Πατήθηκε το κουμπί View Family
    // Εχει γίνει 
    // @Autowired
    // private FamilyService familyService;

    //---------------------------------------------------------------------------------------   
    @GetMapping("/{id}/family")
    public String showFamily(@PathVariable(name = "id") int scode, Model model){
        
        List<Family> family = familyService.getFamilyBySalesman(scode);
        
        String message;
        if(family.isEmpty()){
            message = scode + " does not have any registered family members!";
        }else{
            message = "Salesman family members are:";
        }
        
        model.addAttribute("family", family);
        model.addAttribute("message", message);
        return "salesman/familyList";
        
    }
    //---------------------------------------------------------------------------------------    
}
