package Tubes.AplikasiDealerMobil.service;

import Tubes.AplikasiDealerMobil.dto.MobilDto;

import java.util.List;

public interface MobilService {
    MobilDto saveMobil(MobilDto mobilDto);
    List<MobilDto> getAllMobils();
    MobilDto getMobilById(Long MobilId);
    void deleteMobilById(Long MobilId);
    MobilDto updateMobil(MobilDto mobilDto);
    List<MobilDto> searchMobil(String search);
}
