
import java.sql.Date;

public class Ogrenci {
    private int id;
    private String kisi_adi;
    private String soyadi;
    private String bolum_adi;
    private String fakulte_adi;
    private String cep_no;
    private String e_posta;
    private String fotograf;
    private String kullanici_adi;
    private String parola;
    private int okul_no;
    private int tercih_sirasi;
    private float Yks_puani;
    private Date kayit_tarihi;

    public Ogrenci(int id, String kisi_adi, String soyadi, String bolum_adi, String fakulte_adi, String cep_no, String e_posta, String fotograf, String kullanici_adi, String parola, int okul_no, int tercih_sirasi, float Yks_puani, Date kayit_tarihi) {
        this.id=id;
        this.kisi_adi = kisi_adi;
        this.soyadi = soyadi;
        this.bolum_adi = bolum_adi;
        this.fakulte_adi = fakulte_adi;
        this.cep_no = cep_no;
        this.e_posta = e_posta;
        this.fotograf = fotograf;
        this.kullanici_adi = kullanici_adi;
        this.parola = parola;
        this.okul_no = okul_no;
        this.tercih_sirasi = tercih_sirasi;
        this.Yks_puani = Yks_puani;
        this.kayit_tarihi = kayit_tarihi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKisi_adi() {
        return kisi_adi;
    }

    public void setKisi_adi(String kisi_adi) {
        this.kisi_adi = kisi_adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getBolum_adi() {
        return bolum_adi;
    }

    public void setBolum_adi(String bolum_adi) {
        this.bolum_adi = bolum_adi;
    }

    public String getFakulte_adi() {
        return fakulte_adi;
    }

    public void setFakulte_adi(String fakulte_adi) {
        this.fakulte_adi = fakulte_adi;
    }

    public String getCep_no() {
        return cep_no;
    }

    public void setCep_no(String cep_no) {
        this.cep_no = cep_no;
    }

    public String getE_posta() {
        return e_posta;
    }

    public void setE_posta(String e_posta) {
        this.e_posta = e_posta;
    }

    public String getFotograf() {
        return fotograf;
    }

    public void setFotograf(String fotograf) {
        this.fotograf = fotograf;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public int getOkul_no() {
        return okul_no;
    }

    public void setOkul_no(int okul_no) {
        this.okul_no = okul_no;
    }

    public int getTercih_sirasi() {
        return tercih_sirasi;
    }

    public void setTercih_sirasi(int tercih_sirasi) {
        this.tercih_sirasi = tercih_sirasi;
    }

    public float getYks_puani() {
        return Yks_puani;
    }

    public void setYks_puani(float Yks_puani) {
        this.Yks_puani = Yks_puani;
    }

    public Date getKayit_tarihi() {
        return kayit_tarihi;
    }

    public void setKayit_tarihi(Date kayit_tarihi) {
        this.kayit_tarihi = kayit_tarihi;
    }
    
    
    
}
