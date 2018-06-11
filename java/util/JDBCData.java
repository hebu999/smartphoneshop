package util;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import com.mysql.jdbc.Driver;
import model.Produkt;
import model.Account;

/**
 * 
 * 
 * 
 * @author Heiner, Steffen
 *
 */
@Named(value = "JDBC")
@ApplicationScoped
public class JDBCData implements Serializable {
  List<Produkt> productList = new ArrayList<Produkt>();
  List<Account> accountList = new ArrayList<Account>();
  
  @PersistenceUnit private EntityManagerFactory emf;
  
  public void getSQLData() throws SQLException {    
    
    Connection conn = null;
    try {
      TimeZone timezone = TimeZone.getTimeZone("Europe/Berlin");
      TimeZone.setDefault(timezone);
      Class.forName("com.mysql.cj.jdbc.Driver");
      String dbURL = "jdbc:mysql://localhost:3306/smartphoneshop2?useLegacyDatetimeCode=false&useJDBCCompliantTimezoneShift=true";
      conn = DriverManager.getConnection(dbURL, "root", "");

      ResultSet product = conn.createStatement().executeQuery("SELECT * FROM produkt");
      ResultSet account = conn.createStatement().executeQuery("SELECT * FROM accounts");

      while (product.next()) {

        productList.add((Produkt) product.getObject("PName"));
      }
      product.close();

      while (account.next()) {

        accountList.add((Account) account.getObject("ACCNAME"));
      }
      account.close();
      
      System.out.println(productList);
      System.out.println(accountList);
      
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      if (conn != null)
        conn.rollback();;
      System.out.println("SQLException: " + e.getMessage());
      System.out.println("SQLState: " + e.getSQLState());
      System.out.println("VendorError: " + e.getErrorCode());
    }
  }

  public List<Produkt> getproductList() {
    
    return productList;
  }
  
  public List<Account> getaccountList() {
    
    return accountList;
  }
  
}