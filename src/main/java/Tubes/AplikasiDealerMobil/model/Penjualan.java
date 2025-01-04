package Tubes.AplikasiDealerMobil.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name = "penjualan")
public class Penjualan extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "mobil_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Mobil mobil;

    @Column(name = "tanggal_penjualan")
    private LocalDate tanggalPenjualan;

    @Column(name = "harga_jual")
    private Long hargajual;

    public Penjualan() {
    }

    public Penjualan(Mobil mobil, LocalDate tanggalPenjualan, Long hargajual) {
        this.mobil = mobil;
        this.tanggalPenjualan = tanggalPenjualan;
        this.hargajual = hargajual;
    }

    public Mobil getMobil() {
        return mobil;
    }

    public void setMobil(Mobil mobil) {
        this.mobil = mobil;
    }

    public LocalDate getTanggalPenjualan() {
        return tanggalPenjualan;
    }

    public void setTanggalPenjualan(LocalDate tanggalPenjualan) {
        this.tanggalPenjualan = tanggalPenjualan;
    }

    public Long getHargajual() {
        return hargajual;
    }

    public void setHargajual(Long hargajual) {
        this.hargajual = hargajual;
    }
}

