package Tubes.AplikasiDealerMobil.controller;


import Tubes.AplikasiDealerMobil.service.MobilService;
import Tubes.AplikasiDealerMobil.service.PenjualanService;
import Tubes.AplikasiDealerMobil.dto.PenjualanDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
public class PenjualanController {

    private final PenjualanService penjualanService;
    private final MobilService mobilService;

    @Autowired
    public PenjualanController(PenjualanService penjualanService, MobilService mobilService) {
        this.penjualanService = penjualanService;
        this.mobilService = mobilService;
    }
    @GetMapping("/penjualan/list")
    public String listPenjualan(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        String userRole = (String) session.getAttribute("userRole");

        if (username == null) {
            return "redirect:/auth/login";
        }

        if (!"SALES_DEALER".equals(userRole)) {
            return "redirect:/dashboard";
        }

        List<PenjualanDto> penjualans = penjualanService.getAllPenjualan();
        model.addAttribute("penjualans", penjualans);
        return "penjualan/list-penjualan";
    }

    @GetMapping("/penjualan/record")
    public String showRecordForm(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        String userRole = (String) session.getAttribute("userRole");

        if (username == null) {
            return "redirect:/auth/login";
        }

        if (!"SALES_DEALER".equals(userRole)) {
            return "redirect:/dashboard";
        }

        model.addAttribute("penjualanDto", new PenjualanDto());
        model.addAttribute("availableCars", mobilService.getAllMobils());
        return "penjualan/tambah-penjualan";
    }

    @PostMapping("/penjualan/record")
    public String recordPenjualan(@ModelAttribute PenjualanDto penjualanDto,
                                  RedirectAttributes redirectAttributes,
                                  HttpSession session) {
        String username = (String) session.getAttribute("username");
        String userRole = (String) session.getAttribute("userRole");

        if (username == null) {
            return "redirect:/auth/login";
        }

        if (!"SALES_DEALER".equals(userRole)) {
            return "redirect:/dashboard";
        }

        try {
            penjualanService.savePenjualan(penjualanDto);
            redirectAttributes.addFlashAttribute("sukses", "Penjualan berhasil dicatat");
            return "redirect:/dashboard";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Gagal mencatat penjualan: " + e.getMessage());
            return "redirect:/sales/record";
        }
    }

    @GetMapping("/penjualan/report")
    public String showReportForm(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            Model model,
            HttpSession session) {

        String username = (String) session.getAttribute("username");
        String userRole = (String) session.getAttribute("userRole");

        if (username == null || !"SALES_DEALER".equals(userRole)) {
            return "redirect:/auth/login";
        }

        if (startDate != null && endDate != null) {
            try {
                System.out.println("Controller - startDate: " + startDate);
                System.out.println("Controller - endDate: " + endDate);

                List<PenjualanDto> penjualans = penjualanService.getLaporanPenjualan(startDate, endDate);
                model.addAttribute("penjualans", penjualans);
                model.addAttribute("startDate", startDate);
                model.addAttribute("endDate", endDate);
            } catch (Exception e) {
                System.out.println("Error in controller: " + e.getMessage());
                e.printStackTrace();
                model.addAttribute("error", "Terjadi kesalahan sistem: " + e.getMessage());
            }
        }

        return "penjualan/laporan-penjualan";
    }
}
