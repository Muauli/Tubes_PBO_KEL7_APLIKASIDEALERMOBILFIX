package Tubes.AplikasiDealerMobil.controller;

import Tubes.AplikasiDealerMobil.dto.MobilDto;
import Tubes.AplikasiDealerMobil.service.MobilService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private MobilService mobilService;

    @GetMapping({"/dashboard"})
    public String dashboard(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        System.out.println("Dashboard Controller - Username from session: " + username);

        if (username == null) {
            System.out.println("Username is null, redirecting to login");
            return "redirect:/auth/login";
        }

        String userRole = (String) session.getAttribute("userRole");
        System.out.println("User Role from session: " + userRole);

        model.addAttribute("username", username);
        model.addAttribute("userRole", userRole);

        System.out.println("Attempting to return dashboard view");
        return "dashboard";
    }
    @GetMapping("/mobil/cari")
    public String cariMobil(@RequestParam String keyword, Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/auth/login";
        }

        if (keyword == null || keyword.trim().isEmpty()) {
            model.addAttribute("error", "Silakan masukkan kata kunci pencarian");
            return "redirect:/dashboard";
        }

        List<MobilDto> hasilPencarian = mobilService.searchMobil(keyword);
        model.addAttribute("mobils", hasilPencarian);
        model.addAttribute("userRole", session.getAttribute("userRole"));
        return "mobil/hasil-pencarian";
    }
}
