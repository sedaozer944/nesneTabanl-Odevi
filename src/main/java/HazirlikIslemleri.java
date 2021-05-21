import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HazirlikIslemleri 
{
     private Connection con = null;
 
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public HazirlikIslemleri()
    {
        String url = "jdbc:mysql://" + ObsDatabase.host + ":" + ObsDatabase.port + "/" + ObsDatabase.db_ismi+ "?useUnicode=true&characterEncoding=utf8";
        
        try {
    
                Class.forName("com.mysql.jdbc.Driver");
    
        }catch (ClassNotFoundException ex) {
                System.out.println("Driver Bulunamadı....");
            }
        
        try {
            con = DriverManager.getConnection(url, ObsDatabase.kullanici_adi, ObsDatabase.parola);
            System.out.println("Bağlantı Başarılı...");
    
    
            } catch (SQLException ex) {
                System.out.println("Bağlantı Başarısız...");
                ex.printStackTrace();
            }
  
    }
    
      public ArrayList<HazirlikSinav> sinavGetir(int id)
   {
        ArrayList<HazirlikSinav> liste = new ArrayList<HazirlikSinav>();
        
          try {
            
            
            String sorgu = "SELECT *FROM ders";
            preparedStatement = con.prepareStatement(sorgu);
            ResultSet rs = preparedStatement.executeQuery();
            
            
            while(rs.next())
             {
                String sb = "1";
                String ders_kodu = rs.getString("ders_kodu");
                String ders_adi = rs.getString("ders_adi");
                String tarih = "10.05.2021";
                String e_oran = "40";
                String derslik = "EA-B2-3(ÇEVRE MÜHENDİSLİĞİ)";
                
                liste.add(new HazirlikSinav(sb, ders_kodu, ders_adi, tarih, e_oran, derslik));
             }
          
            return liste;
         }catch (SQLException ex) {
                Logger.getLogger(HazirlikSinav.class.getName()).log(Level.SEVERE, null, ex);
                return null;
         }
   }
    
    public ArrayList<HazirlikDers> alinanDersler(int id)
    {
        ArrayList<HazirlikDers> ders = new ArrayList<HazirlikDers>(); 
         try {
             
             String sorgu1 = "SELECT *FROM ogrenci_ders WHERE ogrenci_id = ? "; 
             preparedStatement = con.prepareStatement(sorgu1);
             preparedStatement.setInt(1, id);
             ResultSet rs = preparedStatement.executeQuery();
              while(rs.next())
             {
                 int ders_id = rs.getInt("ders_id");
                 int ogrenci_id = 0;
                
                 Object sb = null;
                 String ders_kodu = null;
                 String ders_adi = null;
                 String s_durumu = null;
                 double vize = 0;
                 double finall = 0;
                 double ort =0;
                 String not = null;
                 String durumu = null;
                 
                 ders.add(new HazirlikDers(sb, ders_kodu, ders_adi, s_durumu, vize, finall, ort, not, durumu, ders_id, ogrenci_id));
                 
             }
              return ders;
         } catch (SQLException ex) {
             Logger.getLogger(HazirlikIslemleri.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         }    
    }
   
    public ArrayList<HazirlikDers> dersleriGetir(int id)
    {
        ArrayList<HazirlikDers> liste = new ArrayList<HazirlikDers>();
         
        
         try {
            
            
            String sorgu = "SELECT *FROM ders, notlar WHERE ogrenci_id = ? and ders_id = ?";
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, 1);
            ResultSet rs = preparedStatement.executeQuery();
            
            
            while(rs.next())
             {
                int ogrenci_id = rs.getInt("ogrenci_id");
                int ders_id = rs.getInt("ders_id");
                Object sb = null;
                String ders_kodu = rs.getString("ders_kodu");
                String ders_adi = rs.getString("ders_adi");
                String s_durumu = "sonuçlandırıldı";
                double vize = rs.getDouble("vize");
                double finall = rs.getDouble("final");
                
                double ort = (vize * 0.4) + (finall* 0.6);
                String not;
                String durumu;
                
                if(ort > 90) {
                 not = "AA"; 
                 durumu = "Geçti";
            }
            else if(ort > 85){ 
                not = "BA";
                durumu = "Geçti";
            }       
            else if(ort > 80){ 
                not = "BB"; 
                durumu = "Geçti";
            }       
            else if(ort > 75){ 
                not = "CB";
                durumu = "Geçti";
            }
            else if(ort > 50){ 
                not = "CC";
                durumu = "Geçti";
            }
            else {
                not = "FF";
                durumu = "Kaldı";
            }
                
                 
                liste.add(new HazirlikDers(sb, ders_kodu, ders_adi, s_durumu, vize, finall, ort, not, durumu, ders_id, ogrenci_id));
               
             }
            return liste;
         }catch (SQLException ex) {
                Logger.getLogger(HazirlikIslemleri.class.getName()).log(Level.SEVERE, null, ex);
                return null;
         }
             
    }
    
   public ArrayList<HazirlikDevamsizlik> devamsizlikGetir(int id)
   {
        ArrayList<HazirlikDevamsizlik> liste = new ArrayList<HazirlikDevamsizlik>();
        
          try {
            
            
            String sorgu = "SELECT *FROM ders";
            preparedStatement = con.prepareStatement(sorgu);
            ResultSet rs = preparedStatement.executeQuery();
            
            
            while(rs.next())
             {
                String sb = "1";
                String ders_kodu = rs.getString("ders_kodu");
                String ders_adi = rs.getString("ders_adi"); 
                int krd = rs.getInt("ders_kredi");
                String toplamDevamsizlik = "4";
                String dersKurallari = "";
                
                liste.add(new HazirlikDevamsizlik(sb, ders_kodu, ders_adi, krd, toplamDevamsizlik, dersKurallari));
             }
          
            return liste;
         }catch (SQLException ex) {
                Logger.getLogger(HazirlikDevamsizlik.class.getName()).log(Level.SEVERE, null, ex);
                return null;
         }
   }
   
   
}
   
    
    

