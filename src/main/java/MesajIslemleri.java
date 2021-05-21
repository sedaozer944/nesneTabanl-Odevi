
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MesajIslemleri {
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public MesajIslemleri()
    {
         String url = "jdbc:mysql://" + ObsDatabase.host + ":" + ObsDatabase.port + "/" + ObsDatabase.db_ismi+ "?useUnicode=true&characterEncoding=utf8";
        
        
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
            ex.printStackTrace();
        }
    }
    
    public void mesajGonder(int ogrenci_id, int akademisyen_id,String mesaj)
    {
        String sorgu = "Insert Into mesajlar (ogrenci_id, akademisyen_id, mesaj_içeriği) VALUES(?,?,?)";
           try {
                preparedStatement = con.prepareStatement(sorgu);
                    
                    
                preparedStatement.setInt(1, ogrenci_id);
                preparedStatement.setInt(2, akademisyen_id);
                preparedStatement.setString(3, mesaj);
                
                    
                preparedStatement.executeUpdate();
           }
           catch(SQLException ex){
                Logger.getLogger(MesajIslemleri.class.getName()).log(Level.SEVERE, null, ex);
                   }          
                       }
    
       public ArrayList<Mesaj> mesajlariGetir(int id)
       { 
           ArrayList<Mesaj> liste = new ArrayList<Mesaj>();
        try {
            String sorgu = "Select *from mesajlar where id = ?";
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
     
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
                {
                    int ogrenci_id = rs.getInt("ogrenci_id");
                    int akademisyen_id = rs.getInt("akademisyen_id");
                    String mesaj_icerigi = rs.getString("mesaj_içeriği");
                    
                        liste.add(new Mesaj(ogrenci_id, akademisyen_id, mesaj_icerigi));
                   
                }
            return liste;
        } catch (SQLException ex) {
            Logger.getLogger(HazirlikIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
       
   }
  
            
    }
            
