
public class HazirlikDevamsizlik {
    String sb;
    String ders_kodu;
    String ders_adi;
    int krd;
    String toplamDevamsizlik;
    String dersKurallari;

    public HazirlikDevamsizlik(String sb, String ders_kodu, String ders_adi, int krd, String toplamDevamsizlik, String dersKurallari) {
        this.sb = sb;
        this.ders_kodu = ders_kodu;
        this.ders_adi = ders_adi;
        this.krd = krd;
        this.toplamDevamsizlik = toplamDevamsizlik;
        this.dersKurallari = dersKurallari;
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

    public int getKrd() {
        return krd;
    }

    public void setKrd(int krd) {
        this.krd = krd;
    }

    public String getToplamDevamsizlik() {
        return toplamDevamsizlik;
    }

    public void setToplamDevamsizlik(String toplamDevamsizlik) {
        this.toplamDevamsizlik = toplamDevamsizlik;
    }

    public String getDersKurallari() {
        return dersKurallari;
    }

    public void setDersKurallari(String dersKurallari) {
        this.dersKurallari = dersKurallari;
    }
}
