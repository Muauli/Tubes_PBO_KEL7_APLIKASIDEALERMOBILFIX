package Tubes.AplikasiDealerMobil.repository;

import Tubes.AplikasiDealerMobil.model.Mobil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MobilRepository extends JpaRepository<Mobil, Long> {
      List<Mobil> findByNamaMobilContainingIgnoreCaseOrJenisMobilContainingIgnoreCaseOrTahunContainingIgnoreCaseOrNomorRangkaContainingIgnoreCaseOrNomorMesinContainingIgnoreCaseOrNomorPolisiContainingIgnoreCaseOrKapasitasMesinContainingIgnoreCaseOrWarnaContainingIgnoreCaseOrPabrikanContainingIgnoreCase(
              String namaMobil, String jenisMobil, String tahun, String nomorRangka,
              String nomorMesin, String nomorPolisi, String kapasitasMesin, String warna, String pabrikan);

}
