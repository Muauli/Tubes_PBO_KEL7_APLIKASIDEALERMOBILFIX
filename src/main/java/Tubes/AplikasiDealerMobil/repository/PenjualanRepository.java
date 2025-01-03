package Tubes.AplikasiDealerMobil.repository;

import Tubes.AplikasiDealerMobil.model.Penjualan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PenjualanRepository extends JpaRepository<Penjualan, Long> {
    Optional<List<Penjualan>> findByTanggalPenjualanBetweenOrderByTanggalPenjualan(LocalDate startDate, LocalDate endDate);
}