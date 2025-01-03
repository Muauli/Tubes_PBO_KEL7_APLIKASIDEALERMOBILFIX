package Tubes.AplikasiDealerMobil.mapper;

import Tubes.AplikasiDealerMobil.dto.PenjualanDto;
import Tubes.AplikasiDealerMobil.model.Mobil;
import Tubes.AplikasiDealerMobil.model.Penjualan;
import Tubes.AplikasiDealerMobil.repository.MobilRepository;

public class PenjualanMapper {
    public static PenjualanDto mapToPenjualanDto(Penjualan penjualan) {
        Mobil mobil = penjualan.getMobil();
        return new PenjualanDto(
                penjualan.getId(),
                mobil.getId(),
                mobil.getNamaMobil(),
                mobil.getPabrikan(),
                penjualan.getTanggalPenjualan(),
                penjualan.getHargajual()
        );

    }

    public static Penjualan mapToPenjualan(PenjualanDto penjualanDto, MobilRepository mobilRepository) {
        Penjualan penjualan = new Penjualan();
        penjualan.setId(penjualanDto.getId());


        Mobil mobil = mobilRepository.findById(penjualanDto.getIdMobil())
                .orElseThrow(() -> new IllegalArgumentException("Mobil tidak ditemukan"));
        penjualan.setMobil(mobil);

        penjualan.setTanggalPenjualan(penjualanDto.getTanggalPenjualan());
        penjualan.setHargajual(penjualanDto.getHargaJual());
        return penjualan;
    }
}
