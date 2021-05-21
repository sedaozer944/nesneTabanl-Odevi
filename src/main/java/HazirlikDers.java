
public class HazirlikDers {
    Object sb;
    String ders_kodu;
    String ders_adi;
    String s_durumu;
    double vize; 
    double finall;
    double ort;
    String not;
    String durumu;
    int ders_id;
    int ogrenci_id;

    public HazirlikDers(Object sb, String ders_kodu, String ders_adi, String s_durumu, double vize, double finall, double ort, String not, String durumu, int ders_id, int ogrenci_id) {
        this.sb = sb;
        this.ders_kodu = ders_kodu;
        this.ders_adi = ders_adi;
        this.s_durumu = s_durumu;
        this.vize = vize;
        this.finall = finall;
        this.ort = ort;
        this.not = not;
        this.durumu = durumu;
        this.ders_id = ders_id;
        this.ogrenci_id = ogrenci_id;
    }
    public int getDers_id() {
        return ders_id;
    }

    public void setDers_id(int ders_id) {
        this.ders_id = ders_id;
    }

    public int getOgrenci_id() {
        return ogrenci_id;
    }

    public void setOgrenci_id(int ogrenci_id) {
        this.ogrenci_id = ogrenci_id;
    }


    public Object getSb() {
        return sb;
    }

    public void setSb(Object sb) {
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

    public String getS_durumu() {
        return s_durumu;
    }

    public void setS_durumu(String s_durumu) {
        this.s_durumu = s_durumu;
    }

    public double getVize() {
        return vize;
    }

    public void setVize(double vize) {
        this.vize = vize;
    }

    public double getFinall() {
        return finall;
    }

    public void setFinall(double finall) {
        this.finall = finall;
    }

    public double getOrt() {
        return ort;
    }

    public void setOrt(double ort) {
        this.ort = ort;
    }

    public String getNot() {
        return not;
    }

    public void setNot(String not) {
        this.not = not;
    }

    public String getDurumu() {
        return durumu;
    }

    public void setDurumu(String durumu) {
        this.durumu = durumu;
    }

    
    
}
