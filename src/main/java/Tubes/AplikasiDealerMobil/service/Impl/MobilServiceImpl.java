package Tubes.AplikasiDealerMobil.service.Impl;

import Tubes.AplikasiDealerMobil.dto.MobilDto;
import Tubes.AplikasiDealerMobil.mapper.MobilMapper;
import Tubes.AplikasiDealerMobil.model.Mobil;
import Tubes.AplikasiDealerMobil.model.StatusMobil;
import Tubes.AplikasiDealerMobil.repository.MobilRepository;
import Tubes.AplikasiDealerMobil.service.MobilService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
@AllArgsConstructor
public class MobilServiceImpl implements MobilService {

    private MobilRepository mobilRepository;



    @Override
    public MobilDto saveMobil(MobilDto mobilDto) {
        try {
            System.out.println("Mencoba menyimpan mobil: " + mobilDto.getNamaMobil());

            Mobil mobil = MobilMapper.mapToMobil(mobilDto);

            if(mobil.getStatus() == null) {
                mobil.setStatus(StatusMobil.AVAILABLE);
            }

            Mobil savedMobil = mobilRepository.save(mobil);
            System.out.println("Mobil berhasil disimpan dengan ID: " + savedMobil.getId());

            return MobilMapper.mapToMobilDto(savedMobil);
        } catch (Exception e) {
            System.out.println("Error saat menyimpan mobil: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<MobilDto> getAllMobils() {
        List<Mobil> mobils = mobilRepository.findAll();
        return mobils.stream().map(MobilMapper::mapToMobilDto).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public MobilDto getMobilById(Long MobilId) {
        Mobil mobil = mobilRepository.findById(MobilId).orElseThrow(() -> new RuntimeException("Mobil not found for this id :" + MobilId));
        return MobilMapper.mapToMobilDto(mobil);
    }

    @Override
    public void deleteMobilById(Long MobilId) {
        mobilRepository.deleteById(MobilId);

    }

    @Override
    public MobilDto updateMobil(MobilDto mobilDto) {
        Mobil existingMobil = mobilRepository.findById(mobilDto.getId())
                .orElseThrow(() -> new RuntimeException("Mobil not found for this id :" + mobilDto.getId()));

        Mobil mobil = MobilMapper.mapToMobil(mobilDto);
        mobil.setId(mobilDto.getId());

        Mobil updatedMobil = mobilRepository.save(mobil);
        return MobilMapper.mapToMobilDto(updatedMobil);
    }

    @Override
    public List<MobilDto> searchMobil(String search) {
        if (search == null || search.trim().isEmpty()) {
            return Collections.emptyList();
        }
        List<Mobil> mobils = mobilRepository.findByNamaMobilContainingIgnoreCaseOrJenisMobilContainingIgnoreCaseOrTahunContainingIgnoreCaseOrNomorRangkaContainingIgnoreCaseOrNomorMesinContainingIgnoreCaseOrNomorPolisiContainingIgnoreCaseOrKapasitasMesinContainingIgnoreCaseOrWarnaContainingIgnoreCaseOrPabrikanContainingIgnoreCase(search,search,search,search,search,search,search,search,search);
        return mobils.stream()
                .map(MobilMapper::mapToMobilDto)
                .collect(java.util.stream.Collectors.toList());
    }

}



