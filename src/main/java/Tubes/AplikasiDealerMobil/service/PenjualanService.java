package Tubes.AplikasiDealerMobil.service;

import Tubes.AplikasiDealerMobil.dto.PenjualanDto;

import java.time.LocalDate;
import java.util.List;

public interface PenjualanService {
    PenjualanDto savePenjualan(PenjualanDto penjualanDto);
    List<PenjualanDto> getLaporanPenjualan(LocalDate startDate, LocalDate endDate);
    List<PenjualanDto> getAllPenjualan();
}
