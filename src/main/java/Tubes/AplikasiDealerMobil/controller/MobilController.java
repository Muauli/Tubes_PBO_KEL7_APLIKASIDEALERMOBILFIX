package Tubes.AplikasiDealerMobil.controller;

import Tubes.AplikasiDealerMobil.dto.MobilDto;
import Tubes.AplikasiDealerMobil.service.MobilService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MobilController {

    private final MobilService mobilService;

    @Autowired
    public MobilController(MobilService mobilService) {
        this.mobilService = mobilService;
    }


    @GetMapping("/mobil/list")
    public String listMobil(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        String userRole = (String) session.getAttribute("userRole");

        if (username == null) {
            return "redirect:/auth/login";
        }

        
        if (!"DEALER_ADMIN".equals(userRole)) {
            return "redirect:/dashboard";
        }

        List<MobilDto> mobils = mobilService.getAllMobils();
        model.addAttribute("mobils", mobils);
        return "mobil/list-mobil";
    }

  
    @GetMapping("/mobil/tambah")
    public String showTambahForm(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        String userRole = (String) session.getAttribute("userRole");

        if (username == null) {
            return "redirect:/auth/login";
        }

        if (!"DEALER_ADMIN".equals(userRole)) {
            return "redirect:/dashboard";
        }

        model.addAttribute("mobil", new MobilDto());
        return "mobil/tambah-mobil";
    }

   
    @PostMapping("/mobil/tambah")
    public String tambahMobil(@ModelAttribute("mobil") MobilDto mobilDto,
                              RedirectAttributes redirectAttributes,
                              HttpSession session) {
        String username = (String) session.getAttribute("username");
        String userRole = (String) session.getAttribute("userRole");

        System.out.println("Username: " + username);
        System.out.println("Role: " + userRole);

        if (username == null) {
            System.out.println("Username null, redirect ke login");
            return "redirect:/auth/login";
        }

        if (!"DEALER_ADMIN".equals(userRole)) {
            System.out.println("Bukan admin, redirect ke dashboard");
            return "redirect:/dashboard";
        }

        try {
            System.out.println("Data mobil yang akan ditambah: " + mobilDto.getNamaMobil());
            MobilDto savedMobil = mobilService.saveMobil(mobilDto);
            System.out.println("Mobil berhasil ditambah dengan ID: " + savedMobil.getId());
            redirectAttributes.addFlashAttribute("sukses", "Mobil berhasil ditambahkan");
            return "redirect:/dashboard";
        } catch (Exception e) {
            System.out.println("Error saat menyimpan: " + e.getMessage());
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Gagal menyimpan mobil: " + e.getMessage());
            return "redirect:/mobil/tambah";
        }
    }

    
    @GetMapping("/mobil/edit/{id}")
    public String showEditForm(@PathVariable Long id,
                               Model model,
                               HttpSession session) {
        String username = (String) session.getAttribute("username");
        String userRole = (String) session.getAttribute("userRole");

        if (username == null) {
            return "redirect:/auth/login";
        }

        if (!"DEALER_ADMIN".equals(userRole)) {
            return "redirect:/dashboard";
        }

        MobilDto mobil = mobilService.getMobilById(id);
        model.addAttribute("mobil", mobil);
        return "mobil/edit-mobil";
    }

    @PostMapping("/mobil/edit/{id}")
    public String updateMobil(@PathVariable Long id,
                              @ModelAttribute("mobil") MobilDto mobilDto,
                              RedirectAttributes redirectAttributes,
                              HttpSession session) {
        String username = (String) session.getAttribute("username");
        String userRole = (String) session.getAttribute("userRole");

        if (username == null) {
            return "redirect:/auth/login";
        }

        if (!"DEALER_ADMIN".equals(userRole)) {
            return "redirect:/dashboard";
        }

        mobilDto.setId(id);
        mobilService.updateMobil(mobilDto);
        redirectAttributes.addFlashAttribute("sukses", "Mobil berhasil diupdate");
        return "redirect:/dashboard";
    }

    @GetMapping("/mobil/hapus/{id}")
    public String hapusMobil(@PathVariable Long id,
                             RedirectAttributes redirectAttributes,
                             HttpSession session) {
        String username = (String) session.getAttribute("username");
        String userRole = (String) session.getAttribute("userRole");

        if (username == null) {
            return "redirect:/auth/login";
        }

        if (!"DEALER_ADMIN".equals(userRole)) {
            return "redirect:/dashboard";
        }

        mobilService.deleteMobilById(id);
        redirectAttributes.addFlashAttribute("sukses", "Mobil berhasil dihapus");
        return "redirect:/dashboard";
    }
}
