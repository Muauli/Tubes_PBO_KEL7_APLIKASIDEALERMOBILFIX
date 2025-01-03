package Tubes.AplikasiDealerMobil.mapper;

import Tubes.AplikasiDealerMobil.dto.MobilDto;
import Tubes.AplikasiDealerMobil.model.Mobil;

public class MobilMapper {
    public static MobilDto mapToMobilDto(Mobil mobil) {
        return new MobilDto(
                mobil.getId(),
                mobil.getNamaMobil(),
                mobil.getJenisMobil(),
                mobil.getTahun(),
                mobil.getStatus(),
                mobil.getNomorRangka(),
                mobil.getNomorMesin(),
                mobil.getNomorPolisi(),
                mobil.getKapasitasMesin(),
                mobil.getWarna(),
                mobil.getPabrikan()
        );
    }

    public static Mobil mapToMobil(MobilDto dto) {
        Mobil mobil = new Mobil();
        mobil.setNamaMobil(dto.getNamaMobil());
        mobil.setJenisMobil(dto.getJenisMobil());
        mobil.setTahun(dto.getTahun());
        mobil.setStatus(dto.getStatus());
        mobil.setNomorRangka(dto.getNomorRangka());
        mobil.setNomorMesin(dto.getNomorMesin());
        mobil.setNomorPolisi(dto.getNomorPolisi());
        mobil.setKapasitasMesin(dto.getKapasitasMesin());
        mobil.setWarna(dto.getWarna());
        mobil.setPabrikan(dto.getPabrikan());
        return mobil;
    }
}
