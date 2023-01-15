package com.mobilele.web;

import com.mobilele.models.dtos.AddOfferModel;
import com.mobilele.services.BrandService;
import com.mobilele.services.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;
    private final BrandService brandService;

    public OfferController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }


    @GetMapping("/offers/all")
    public String allOffers(){
        return "offers";
    }

    @GetMapping("/offers/add")
    public String addOffer(Model model){
        if (!model.containsAttribute("addOfferModel")){
            model.addAttribute("addOfferModel", new AddOfferModel());
        }
        model.addAttribute("brands", brandService.getAllBrands());
        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String addOfferConfirm(@Valid
                                      @ModelAttribute("addOfferModel")
                                              AddOfferModel addOfferModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addOfferModel", addOfferModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferModel", bindingResult);

            return "redirect:/offers/add";
        }
        offerService.addOffer(addOfferModel);
        return "redirect:/offers/all";
    }
}
