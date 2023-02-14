package com.example.andreys.web.controllers;

import com.example.andreys.models.dtos.bindingModels.AddItemModel;
import com.example.andreys.models.dtos.viewModels.DetailsViewModel;
import com.example.andreys.security.CurrentUser;
import com.example.andreys.services.ItemService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;
    private final CurrentUser currentUser;

    public ItemController(ItemService itemService, CurrentUser currentUser) {
        this.itemService = itemService;
        this.currentUser = currentUser;
    }

    @ModelAttribute("itemModel")
    public AddItemModel itemModel() {
        return new AddItemModel();
    }

    @GetMapping("/add")
    public String getAddForm() {
        if (!currentUser.isLoggedIn()) {
            return "redirect:/";
        }
        return "add-product";
    }

    @PostMapping("/add")
    public String addItem(@Valid AddItemModel itemModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        if (!currentUser.isLoggedIn()) {
            return "redirect:/";
        }
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("itemModel", itemModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.itemModel", bindingResult);
            return "redirect:/items/add";
        }
        itemService.addItem(itemModel);
        return "redirect:/home";
    }


    @ModelAttribute("details")
    public DetailsViewModel details() {
        return new DetailsViewModel();
    }

    @GetMapping("/details/{id}")
    public String getDetails(@PathVariable Long id, Model model) {
        if (!currentUser.isLoggedIn()) {
            return "redirect:/";
        }
        model.addAttribute("details",  itemService.getDetails(id));

        return "details-product";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        if (!currentUser.isLoggedIn()) {
            return "redirect:/";
        }
      itemService.deleteItem(id);

        return "redirect:/home";
    }


}
