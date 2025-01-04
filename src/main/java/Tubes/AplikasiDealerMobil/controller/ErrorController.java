package Tubes.AplikasiDealerMobil.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String errorMessage = "";

        System.out.println("Error Status: " + status);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            switch (statusCode) {
                case 404:
                    errorMessage = "Halaman tidak ditemukan";
                    break;
                case 405:
                    return "redirect:/auth/login";
                case 500:
                    errorMessage = "Terjadi kesalahan pada server";
                    break;
                default:
                    errorMessage = "Terjadi kesalahan yang tidak diketahui";
            }
        }

        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }

    @PostMapping("/error")
    public String handlePostError(HttpServletRequest request) {
        return "redirect:/auth/login";
    }
}