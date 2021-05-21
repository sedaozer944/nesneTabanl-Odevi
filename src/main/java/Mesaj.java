/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author casper
 */
public class Mesaj {
    int ogrenci_id;
    int akademisyen_id;
    String mesaj_icerigi;
    
  public Mesaj(int ogrenci_id, int akademisyen_id, String mesaj_icerigi) {
        this.ogrenci_id = ogrenci_id;
        this.akademisyen_id = akademisyen_id;
        this.mesaj_icerigi = mesaj_icerigi;
  }
    public int getOgrenci_id() {
        return ogrenci_id;
    }

    public void setOgrenci_id(int ogrenci_id) {
        this.ogrenci_id = ogrenci_id;
    }

    public int getAkademisyen_id() {
        return akademisyen_id;
    }

    public void setAkademisyen_id(int akademisyen_id) {
        this.akademisyen_id = akademisyen_id;
    }

    public String getMesaj_icerigi() {
        return mesaj_icerigi;
    }

    public void setMesaj_icerigi(String mesaj_icerigi) {
        this.mesaj_icerigi = mesaj_icerigi;
    }

  
    }

