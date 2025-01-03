package Tubes.AplikasiDealerMobil.repository;

import Tubes.AplikasiDealerMobil.model.Mobil;
import Tubes.AplikasiDealerMobil.model.StatusMobil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface MobilRepository extends JpaRepository<Mobil, Long> {
      List<Mobil> findByNamaMobilContainingIgnoreCaseOrJenisMobilContainingIgnoreCaseOrTahunContainingIgnoreCaseOrNomorRangkaContainingIgnoreCaseOrNomorMesinContainingIgnoreCaseOrNomorPolisiContainingIgnoreCaseOrKapasitasMesinContainingIgnoreCaseOrWarnaContainingIgnoreCaseOrPabrikanContainingIgnoreCase(
              String namaMobil, String jenisMobil, String tahun, String nomorRangka,
              String nomorMesin, String nomorPolisi, String kapasitasMesin, String warna, String pabrikan);
      Optional<Mobil> findByStatus(StatusMobil status);
}
