package Tubes.AplikasiDealerMobil.dto;

import java.time.LocalDate;

public class PenjualanDto {
    private Long id;
    private Long idMobil;
    private String namaMobil;
    private String namaPabrikan;
    private LocalDate tanggalPenjualan;
    private Long hargaJual;

    public PenjualanDto() {

    }

    public PenjualanDto(Long id, Long idMobil, String namaMobil, String namaPabrikan, LocalDate tanggalPenjualan, Long hargaJual) {
        this.id = id;
        this.idMobil = idMobil;
        this.namaMobil = namaMobil;
        this.namaPabrikan = namaPabrikan;
        this.tanggalPenjualan = tanggalPenjualan;
        this.hargaJual = hargaJual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdMobil() {
        return idMobil;
    }

    public void setIdMobil(Long idMobil) {
        this.idMobil = idMobil;
    }

    public String getNamaMobil() {
        return namaMobil;
    }

    public void setNamaMobil(String namaMobil) {
        this.namaMobil = namaMobil;
    }

    public String getNamaPabrikan() {
        return namaPabrikan;
    }

    public void setNamaPabrikan(String namaPabrikan) {
        this.namaPabrikan = namaPabrikan;
    }

    public LocalDate getTanggalPenjualan() {
        return tanggalPenjualan;
    }

    public void setTanggalPenjualan(LocalDate tanggalPenjualan) {
        this.tanggalPenjualan = tanggalPenjualan;
    }

    public Long getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(Long hargaJual) {
        this.hargaJual = hargaJual;
    }
}
