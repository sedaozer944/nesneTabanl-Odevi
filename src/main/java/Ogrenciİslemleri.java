import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Ogrenciİslemleri {
     private Connection con=null;
    private Statement statement =null;
    private PreparedStatement preparedStatement=null;
    
    public boolean OgrenciGirisYap( String kullanici_adi , String parola){
        String sorgu="Select * from ogrenci where kullanici_adi = ? and parola = ?";
       
         try {
             preparedStatement =con.prepareStatement(sorgu);
             preparedStatement.setString(1, kullanici_adi);
             preparedStatement.setString(2,parola);
             ResultSet rs=preparedStatement.executeQuery();
             return rs.next();
         } catch (SQLException ex) {
             Logger.getLogger(Ogrenciİslemleri.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
         
    }
   
    
    
   
    
    public Ogrenciİslemleri(){
        String url="jdbc:mysql://"+ObsDatabase.host+":"+ObsDatabase.port+"/"+ObsDatabase.db_ismi+ "?useUnicode=true&characterEncoding=utf8";
         try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı....");
        }
        
        
        try {
            con = DriverManager.getConnection(url, ObsDatabase.kullanici_adi, ObsDatabase.parola);
            System.out.println("Bağlantı Başarılı...");
            
            
        } catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız...");
            
        }
        
    }
    
    
}
