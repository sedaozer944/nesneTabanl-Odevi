
public class Akademisyen {
    private int id;
    private int ders_id;
    private String kisi_adi;
    private String soyadi;
    private String bolum_adi;
    private String fakulte_adi;
    private String e_posta;
    private String kullanici_adi;
    private String parola;

    public Akademisyen(int id, int ders_id, String kisi_adi, String soyadi, String bolum_adi, String fakulte_adi, String e_posta, String kullanici_adi, String parola) {
        this.id = id;
        this.ders_id=ders_id;
        this.kisi_adi = kisi_adi;
        this.soyadi = soyadi;
        this.bolum_adi = bolum_adi;
        this.fakulte_adi = fakulte_adi;
        this.e_posta = e_posta;
        this.kullanici_adi = kullanici_adi;
        this.parola = parola;
    }

    public int getDers_id() {
        return ders_id;
    }

    public void setDers_id(int ders_id) {
        this.ders_id = ders_id;
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

    public String getE_posta() {
        return e_posta;
    }

    public void setE_posta(String e_posta) {
        this.e_posta = e_posta;
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
    
}
