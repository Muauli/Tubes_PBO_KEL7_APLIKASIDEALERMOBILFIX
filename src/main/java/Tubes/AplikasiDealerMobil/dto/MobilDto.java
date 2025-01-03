package Tubes.AplikasiDealerMobil.dto;

public class MobilDto {
    private Long id;
    private String namaMobil;
    private String jenisMobil;
    private String tahun;
    private StatusMobil status;
    private String nomorRangka;
    private String nomorMesin;
    private String nomorPolisi;
    private String kapasitasMesin;
    private String warna;
    private String pabrikan;

    public MobilDto() {}

    public MobilDto(Long id, String namaMobil, String jenisMobil, String tahun,
                    StatusMobil status, String nomorRangka, String nomorMesin,
                    String nomorPolisi, String kapasitasMesin, String warna, String pabrikan) {
        this.id = id;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
