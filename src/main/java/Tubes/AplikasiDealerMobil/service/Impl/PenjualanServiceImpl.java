package Tubes.AplikasiDealerMobil.service.Impl;

import Tubes.AplikasiDealerMobil.dto.PenjualanDto;
import Tubes.AplikasiDealerMobil.mapper.PenjualanMapper;
import Tubes.AplikasiDealerMobil.model.Mobil;
import Tubes.AplikasiDealerMobil.model.Penjualan;
import Tubes.AplikasiDealerMobil.model.StatusMobil;
import Tubes.AplikasiDealerMobil.repository.MobilRepository;
import Tubes.AplikasiDealerMobil.repository.PenjualanRepository;
import Tubes.AplikasiDealerMobil.service.PenjualanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;



@Service
@AllArgsConstructor
public class PenjualanServiceImpl implements PenjualanService {


    private MobilRepository mobilRepository;
    private PenjualanRepository penjualanRepository;

    @Override
    public PenjualanDto savePenjualan(PenjualanDto penjualanDto) {
        Mobil mobil = mobilRepository.findById(penjualanDto.getIdMobil())
                .orElseThrow(() -> new RuntimeException("Mobil not found for this id :" + penjualanDto.getIdMobil()));

        if (mobil.getStatus() != StatusMobil.AVAILABLE) {
            throw new RuntimeException("Mobil tidak tersedia");
        }

        Penjualan penjualan = PenjualanMapper.mapToPenjualan(penjualanDto, mobilRepository);
        mobil.setStatus(StatusMobil.SOLD);
        mobilRepository.save(mobil);

        return PenjualanMapper.mapToPenjualanDto(penjualanRepository.save(penjualan));
    }

    @Override
    public List<PenjualanDto> getLaporanPenjualan(LocalDate startDate, LocalDate endDate) {
        System.out.println("Service - startDate: " + startDate);
        System.out.println("Service - endDate: " + endDate);

        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Tanggal awal tidak boleh lebih besar dari tanggal akhir");
        }

        List<Penjualan> penjualans = penjualanRepository
                .findByTanggalPenjualanBetweenOrderByTanggalPenjualan(startDate, endDate)
                .orElse(Collections.emptyList());

        System.out.println("Service - Jumlah data ditemukan: " + penjualans.size());

        penjualans.forEach(p -> {
            System.out.println("ID: " + p.getId() +
                    ", Tanggal: " + p.getTanggalPenjualan() +
                    ", Mobil: " + p.getMobil().getNamaMobil());
        });

        return penjualans.stream()
                .map(PenjualanMapper::mapToPenjualanDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PenjualanDto> getAllPenjualan() {
        return penjualanRepository.findAll()
                .stream()
                .map(PenjualanMapper::mapToPenjualanDto)
                .collect(Collectors.toList());
    }
}


