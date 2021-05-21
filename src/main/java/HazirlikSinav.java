
public class HazirlikSinav {
    String sb;
    String ders_kodu;
    String ders_adi;
    String tarih;
    String e_oran;
    String derslik;

    public HazirlikSinav(String sb, String ders_kodu, String ders_adi, String tarih, String e_oran, String derslik) {
        this.sb = sb;
        this.ders_kodu = ders_kodu;
        this.ders_adi = ders_adi;
        this.tarih = tarih;
        this.e_oran = e_oran;
        this.derslik = derslik;
    }

    public String getSb() {
        return sb;
    }

    public void setSb(String sb) {
        this.sb = sb;
    }

    public String getDers_kodu() {
        return ders_kodu;
    }

    public void setDers_kodu(String ders_kodu) {
        this.ders_kodu = ders_kodu;
    }

    public String getDers_adi() {
        return ders_adi;
    }

    public void setDers_adi(String ders_adi) {
        this.ders_adi = ders_adi;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getE_oran() {
        return e_oran;
    }

    public void setE_oran(String e_oran) {
        this.e_oran = e_oran;
    }

    public String getDerslik() {
        return derslik;
    }

    public void setDerslik(String derslik) {
        this.derslik = derslik;
    }
}
