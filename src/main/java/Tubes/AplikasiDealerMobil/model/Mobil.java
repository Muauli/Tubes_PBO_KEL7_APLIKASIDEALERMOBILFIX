package Tubes.AplikasiDealerMobil.model;

import jakarta.persistence.*;

@Entity

@Table(name = "cars")
public class Mobil extends BaseEntity{

    @Column(name = "nama_mobil")
    private String namaMobil;

    @Column(name = "jenis_mobil")
    private String jenisMobil;

    @Column(name = "tahun")
    private String tahun;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusMobil status = StatusMobil.AVAILABLE;

    @Column(name = "nomor_rangka")
    private String nomorRangka;

    @Column(name = "nomor_mesin")
    private String nomorMesin;

    @Column(name = "nomor_polisi")
    private String nomorPolisi;

    @Column(name = "kapasitas_mesin")
    private String kapasitasMesin;

    @Column(name = "warna")
    private String warna;

    @Column(name = "pabrikan")
    private String pabrikan;

    public Mobil() {

    }


    public Mobil(String namaMobil, String jenisMobil, String tahun, StatusMobil status, String nomorRangka, String nomorMesin, String nomorPolisi, String kapasitasMesin, String warna,String pabrikan) {
        this.namaMobil = namaMobil;
        this.jenisMobil = jenisMobil;
        this.tahun = tahun;
        this.status = status;
        this.nomorRangka = nomorRangka;
        this.nomorMesin = nomorMesin;
        this.nomorPolisi = nomorPolisi;
        this.kapasitasMesin = kapasitasMesin;
        this.warna = warna;
        this.pabrikan = pabrikan;
    }


    public String getNamaMobil() {
        return namaMobil;
    }

    public void setNamaMobil(String namaMobil) {
        this.namaMobil = namaMobil;
    }

    public String getJenisMobil() {
        return jenisMobil;
    }

    public void setJenisMobil(String jenisMobil) {
        this.jenisMobil = jenisMobil;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public StatusMobil getStatus() {
        return status;
    }

    public void setStatus(StatusMobil status) {
        this.status = status;
    }

    public String getNomorRangka() {
        return nomorRangka;
    }

    public void setNomorRangka(String nomorRangka) {
        this.nomorRangka = nomorRangka;
    }

    public String getNomorMesin() {
        return nomorMesin;
    }

    public void setNomorMesin(String nomorMesin) {
        this.nomorMesin = nomorMesin;
    }

    public String getNomorPolisi() {
        return nomorPolisi;
    }

    public void setNomorPolisi(String nomorPolisi) {
        this.nomorPolisi = nomorPolisi;
    }

    public String getKapasitasMesin() {
        return kapasitasMesin;
    }

    public void setKapasitasMesin(String kapasitasMesin) {
        this.kapasitasMesin = kapasitasMesin;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }
    public String getPabrikan() {
        return pabrikan;
    }
    public void setPabrikan(String pabrikan) {
        this.pabrikan = pabrikan;
    }
}
