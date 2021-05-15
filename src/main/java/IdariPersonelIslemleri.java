
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//idari personele ait öğrenci ve akademisyen güncelleme,silme,ekleme işlemleri yapılacak

public class IdariPersonelIslemleri {
    private Connection con=null;
  
    private Statement statement=null;
    
    private PreparedStatement preparedStatement=null;

    
    
    public ArrayList<Akademisyenn> akademisyenleriGetir()
    {
        ArrayList<Akademisyenn> cikti=new ArrayList<Akademisyenn>();
        try {
            statement=con.createStatement();
            String sorgu="Select * From akademisyen";
            
            ResultSet rs=statement.executeQuery(sorgu);
            
            while(rs.next())
            {
                int id=rs.getInt("id");
                int ders_id=rs.getInt("ders_id");
                String kisi_adi=rs.getString("kisi_adi");
                String soyadi=rs.getString("soyadi");
                String bolum_adi=rs.getString("bolum_adi");
                String fakulte_adi=rs.getString("fakulte_adi");
                String e_posta=rs.getString("e_posta");
                String kullanici_adi=rs.getString("kullanici_adi");
                String parola=rs.getString("parola");
                
                cikti.add(new Akademisyenn(id,ders_id,kisi_adi,soyadi,bolum_adi,e_posta,fakulte_adi,kullanici_adi,parola));
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(IdariPersonelIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;//hata varsa hiçbir ArrayList i dönme
        }
    }
    
    
    public boolean girisYap(String kullanici_adi,String parola)
    {
        String sorgu="Select * From idari_personel where kullanici_adi = ? and parola = ?";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setString(1, kullanici_adi);
            preparedStatement.setString(2, parola);
            
            ResultSet rs=preparedStatement.executeQuery();
            
            return rs.next();//kontrol
            
        } catch (SQLException ex) {
            Logger.getLogger(IdariPersonelIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    public void akademisyenGuncelle(int id,String yeni_akademisyendersid,String yeni_akademisyenadi,String yeni_akademisyensoyadi,String yeni_akademisyensoybolumadi,String yeni_akademisyensoyfakulteadi,String yeni_akademisyeneposta,String yeni_akademisyenkullaniciadi,String yeni_akademisyenparola)
    {
        String sorgu="Update akademisyen set ders_id=?,kisi_adi=?,soyadi=?,bolum_adi=?,fakulte_adi=?,e_posta=?,kullanici_adi=?,parola=? where id=?";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setString(1,yeni_akademisyendersid);
            preparedStatement.setString(2,yeni_akademisyenadi);
            preparedStatement.setString(3,yeni_akademisyensoyadi);
            preparedStatement.setString(4,yeni_akademisyensoybolumadi);
            preparedStatement.setString(5,yeni_akademisyensoyfakulteadi);
            preparedStatement.setString(6,yeni_akademisyeneposta);
            preparedStatement.setString(7,yeni_akademisyenkullaniciadi);
            preparedStatement.setString(8,yeni_akademisyenparola);
            
            preparedStatement.setInt(9,id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(IdariPersonelIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
    //burdan akademisyeni veritabanımıza eklemiş oluyoruz 
    public void akademisyenEkle(String kisi_adi,String soyadi,String bolum_adi,String fakulte_adi,String e_posta,String kullanici_adi,String parola,String ders_id)
    {
        //Burdaki isimlendirmeler veritabanındakilerle aynı olmalı
        String sorgu="Insert Into akademisyen (ders_id,kisi_adi,soyadi,bolum_adi,fakulte_adi,e_posta,kullanici_adi,parola) VALUES(?,?,?,?,?,?,?,?)";
        
        try {
            preparedStatement=con.prepareStatement(sorgu);

            preparedStatement.setString(1,ders_id);
            preparedStatement.setString(2,kisi_adi);
            preparedStatement.setString(3,soyadi);
            preparedStatement.setString(4,bolum_adi);
            preparedStatement.setString(5,fakulte_adi);
            preparedStatement.setString(6,e_posta);
            preparedStatement.setString(7,kullanici_adi);
            preparedStatement.setString(8,parola);
            
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(IdariPersonelIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void akademisyenSil(int id)
    {
        String sorgu="Delete from akademisyen where id=?";
        
        try {
            preparedStatement=con.prepareStatement(sorgu);
            
            preparedStatement.setInt(1,id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(IdariPersonelIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public ArrayList<Ogrenci> ogrencileriGetir()
    {
        ArrayList<Ogrenci> cikti=new ArrayList<Ogrenci>();
        try {
            statement=con.createStatement();
            String sorgu="Select * From ogrenci";
            
            ResultSet rs=statement.executeQuery(sorgu);
            
            while(rs.next())
            {
                int id=rs.getInt("id");
                String kisi_adi=rs.getString("kisi_adi");
                String soyadi=rs.getString("soyadi");
                String bolum_adi=rs.getString("bolum_adi");
                String fakulte_adi=rs.getString("fakulte_adi");
                String cep_no=rs.getString("cep_no");
                String e_posta=rs.getString("e_posta");
                String fotograf=rs.getString("fotograf");
                String kullanici_adi=rs.getString("kullanici_adi");
                String parola=rs.getString("parola");
                int okul_no=rs.getInt("okul_no");
                int tercih_sirasi=rs.getInt("tercih_sirasi");
                float Yks_puani=rs.getFloat("Yks_puani");
                Date kayit_tarihi=rs.getDate("kayit_tarihi");
                
                cikti.add(new Ogrenci(id,kisi_adi,soyadi,bolum_adi,fakulte_adi,cep_no,e_posta,fotograf,kullanici_adi,parola,okul_no,tercih_sirasi,Yks_puani,kayit_tarihi));
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(IdariPersonelIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;//hata varsa hiçbir ArrayList i dönme
        }
    }
    
    
    //burdan ogrenciyi veritabanımıza eklemiş oluyoruz 
    public void ogrenciEkle(String kisi_adi,String soyadi,String bolum_adi,String fakulte_adi,String cep_no,String e_posta,String fotograf,String kullanici_adi,String parola,String okul_no,String tercih_sirasi,String Yks_puani,String kayit_tarihi)
    {
        //Burdaki isimlendirmeler veritabanındakilerle aynı olmalı
        String sorgu="Insert Into ogrenci (kisi_adi,soyadi,bolum_adi,fakulte_adi,cep_no,e_posta,fotograf,kullanici_adi,parola,okul_no,tercih_sirasi,Yks_puani,kayit_tarihi) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            preparedStatement=con.prepareStatement(sorgu);

            preparedStatement.setString(1,kisi_adi);
            preparedStatement.setString(2,soyadi);
            preparedStatement.setString(3,bolum_adi);
            preparedStatement.setString(4,fakulte_adi);
            preparedStatement.setString(5,cep_no);
            preparedStatement.setString(6,e_posta);
            preparedStatement.setString(7,fotograf);
            preparedStatement.setString(8,kullanici_adi);
            preparedStatement.setString(9,parola);
            preparedStatement.setString(10,okul_no);
            preparedStatement.setString(11,tercih_sirasi);
            preparedStatement.setString(12,Yks_puani);
            preparedStatement.setString(13,kayit_tarihi);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(IdariPersonelIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void ogrenciGuncelle(int id,String yeni_ogrenciadi,String yeni_ogrencisoyadi,String yeni_ogrencibolumadi,String yeni_ogrencifakulteadi,String yeni_ogrencicepno,String yeni_ogrencieposta,String yeni_ogrencifotograf,String yeni_ogrencikullaniciadi,String yeni_ogrenciparola,String yeni_ogrenciokulno,String yeni_ogrencitercihsirasi,String yeni_ogrenciYkspuani,String yeni_ogrencikayittarihi)
    {
        String sorgu="Update ogrenci set kisi_adi=?,soyadi=?,bolum_adi=?,fakulte_adi=?,cep_no=?,e_posta=?,fotograf=?,kullanici_adi=?,parola=?,okul_no=?,tercih_sirasi=?,Yks_puani=?,kayit_tarihi=? where id=?";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setString(1,yeni_ogrenciadi);
            preparedStatement.setString(2,yeni_ogrencisoyadi);
            preparedStatement.setString(3,yeni_ogrencibolumadi);
            preparedStatement.setString(4,yeni_ogrencifakulteadi);
            preparedStatement.setString(5,yeni_ogrencicepno);
            preparedStatement.setString(6,yeni_ogrencieposta);
            preparedStatement.setString(7,yeni_ogrencifotograf);
            preparedStatement.setString(8,yeni_ogrencikullaniciadi);
            preparedStatement.setString(9,yeni_ogrenciparola);
            preparedStatement.setString(10,yeni_ogrenciokulno);
            preparedStatement.setString(11,yeni_ogrencitercihsirasi);
            preparedStatement.setString(12,yeni_ogrenciYkspuani);
            preparedStatement.setString(13,yeni_ogrencikayittarihi);
            
            preparedStatement.setInt(14,id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(IdariPersonelIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
    public void ogrenciSil(int id)
    {
        String sorgu="Delete from ogrenci where id=?";
        
        try {
            preparedStatement=con.prepareStatement(sorgu);
            
            preparedStatement.setInt(1,id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(IdariPersonelIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    public IdariPersonelIslemleri()
    {
        String url="jdbc:mysql://"+ObsDatabase.host+":"+ObsDatabase.port+"/"+ObsDatabase.db_ismi+"?useUnicode=true&characterEncoding=utf8";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");//çalışmazsa cj yi sil
        }
        catch(ClassNotFoundException ex){
            System.out.println("Driver Bulunamadi...");
        }
        
        try {
            con=DriverManager.getConnection(url,ObsDatabase.kullanici_adi,ObsDatabase.parola);
            System.out.println("Baglanti Basarili.");
            
        } catch (SQLException ex) {
            System.out.println("Baglanti Basarisiz.");
            //ex.printStackTrace();-->hata nerde bulur bize
        }
    }
    
    public static void main(String[] args){
        IdariPersonelIslemleri idariPersonelIslemleri=new IdariPersonelIslemleri();
    }
}
