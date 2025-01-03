package Tubes.AplikasiDealerMobil.controller;

import Tubes.AplikasiDealerMobil.dto.UserDto;
import Tubes.AplikasiDealerMobil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public  String registerUser(@Validated @ModelAttribute("user") UserDto userDto, BindingResult result, Model model, RedirectAttributes redirectAttributes){

        if (result.hasErrors()) {
            return "register";
        }

        try {
            userService.createUser(userDto);
            redirectAttributes.addFlashAttribute("success", "Registrasi berhasil! boleh login dengan akun anda");
            return "redirect:/auth/login";
        }catch (Exception e){
        redirectAttributes.addFlashAttribute("error", "Registrasi gagal! silahkan coba lagi" + e.getMessage());
            return "register";}
    }

}
