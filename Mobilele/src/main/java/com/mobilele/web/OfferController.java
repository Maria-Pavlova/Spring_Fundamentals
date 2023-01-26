package com.mobilele.web;

import com.mobilele.models.dtos.AddOfferModel;
import com.mobilele.models.dtos.OfferUpdateModel;
import com.mobilele.models.dtos.views.OfferDetailsDto;
import com.mobilele.models.enums.Engine;
import com.mobilele.models.enums.Transmission;
import com.mobilele.services.BrandService;
import com.mobilele.services.OfferService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;
    private final BrandService brandService;
    private final ModelMapper modelMapper;

    public OfferController(OfferService offerService, BrandService brandService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/offers/all")
    public String allOffers(Model model) {
        model.addAttribute("offers", offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/offers{id}/details")
    public String offerDetails(@PathVariable String id, Model model) {
        model.addAttribute("details", offerService.findById(id));
        return "details";

    }

    @ModelAttribute("addOfferModel")
    public AddOfferModel addOfferModel() {
        return new AddOfferModel();
    }

    @GetMapping("/offers/add")
    public String getAddOffer(Model model) {
//        if (!model.containsAttribute("addOfferModel")){
//            model.addAttribute("addOfferModel", new AddOfferModel());
//        }
        model.addAttribute("brands", brandService.getAllBrands());
        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());
        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String addOffer(@Valid AddOfferModel addOfferModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        System.out.println(addOfferModel);
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferModel", addOfferModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferModel", bindingResult);
            return "redirect:/offers/add";
        }
        offerService.addOffer(addOfferModel);
        return "redirect:/offers/all";
    }

    @DeleteMapping("/offers{id}")
    public String deleteOffer(@PathVariable String id) {
        offerService.deleteOffer(id);
        return "redirect:/offers/all";
    }

    @GetMapping("/offers{id}/update")
    public String updateOffer(@PathVariable String id, Model model) {
        OfferDetailsDto detailsDto = offerService.findById(id);
        OfferUpdateModel updateModel = modelMapper.map(detailsDto, OfferUpdateModel.class);
        updateModel.setId(id);
        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());
        model.addAttribute("updateModel", updateModel);
        return "update";
    }

    @GetMapping("/offers{id}/update/errors")
    public String updateOfferErrors(@PathVariable String id, Model model) {
        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());
        return "update";

    }

    @PatchMapping("/offers{id}/update")
    public String updateOffer(@PathVariable String id,
                              @Valid OfferUpdateModel updateModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("updateModel", updateModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.updateModel", bindingResult);
            return "redirect:/offers" + id + "/update/errors";

        }
        offerService.updateOffer(updateModel);
        return "redirect:/offers" + id + "/details";
    }
}
