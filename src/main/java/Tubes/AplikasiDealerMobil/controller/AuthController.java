package Tubes.AplikasiDealerMobil.controller;

import Tubes.AplikasiDealerMobil.dto.LoginDto;
import Tubes.AplikasiDealerMobil.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginForm", new LoginDto());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("loginForm") LoginDto loginDto, Model model, HttpSession session) {
        System.out.println("Login attempt - Username: " + loginDto.getUsername());

        if (userService.authenticateUser(loginDto.getUsername(), loginDto.getPassword())) {
            String role = userService.getCurrentUserRole(loginDto.getUsername());
            System.out.println("Authentication successful - Role: " + role);

            session.setAttribute("username", loginDto.getUsername());
            session.setAttribute("userRole", role);

            System.out.println("Session attributes set - Redirecting to dashboard");
            return "redirect:/dashboard";
        }

        System.out.println("Authentication failed");
        model.addAttribute("error", "Username atau password salah");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login?logout";
    }
}
