package com.blog.marcosaraujo.dev.controller;

import com.blog.marcosaraujo.dev.service.NewsletterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class NewsletterController {

    private final NewsletterService newsletterService;

    @GetMapping("/newsletter")
    public String newsletterPage() {
        return "newsletter";
    }

    @PostMapping("/newsletter")
    public String subscribe(@RequestParam("email") String email, RedirectAttributes redirectAttributes) {
        try {
            newsletterService.subscribe(email);
            redirectAttributes.addFlashAttribute("sucesso", "Inscrição realizada com sucesso! 🎉");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("erro", e.getMessage());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Ocorreu um erro ao cadastrar. Tente novamente.");
        }

        return "redirect:/newsletter";
    }
}