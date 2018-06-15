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
import java.io.OutputStream;
import model.Produkt;
import model.Account;

/**
 * * *
 * 
 * @author Heiner, Steffen
 *
 */

@Named(value = "JDBC")
@ApplicationScoped
public class JDBCData implements Serializable {
  List<Produkt> productList = new ArrayList<Produkt>();
  List<Account> accountList = new ArrayList<Account>();
  Connection conn = null;

  public JDBCData() {

  }

  @PersistenceUnit
  private EntityManagerFactory emf;

  public Connection connectDatabase() throws SQLException {


    try {
      TimeZone timezone = TimeZone.getTimeZone("Europe/Berlin");
      TimeZone.setDefault(timezone);
      Class.forName("com.mysql.cj.jdbc.Driver");
      String dbURL =
          "jdbc:mysql://localhost:3306/smartphoneshop2?useLegacyDatetimeCode=false&useJDBCCompliantTimezoneShift=true";
      conn = DriverManager.getConnection(dbURL, "root", "");

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getMessage());
      System.out.println("SQLState: " + e.getSQLState());
      System.out.println("VendorError: " + e.getErrorCode());
    }
    return conn;
  }

  public List<Produkt> getSQLDataProduct() throws SQLException {

    try {

      Connection conn = connectDatabase();

      ResultSet product = conn.createStatement().executeQuery("SELECT * FROM 'produkt'");

      while (product.next()) {

        productList.add(new Produkt(product.getString("PName"), product.getBigDecimal("preis"),
            product.getString("Typ"), product.getString("Kommentar")));
      }
      product.close();

      System.out.println(productList);


    }

    catch (SQLException e) {
      if (conn != null)
        conn.rollback();
      System.out.println("SQLException: " + e.getMessage());
      System.out.println("SQLState: " + e.getSQLState());
      System.out.println("VendorError: " + e.getErrorCode());

    }
    return productList;
  }

  public List<Account> getSQLDataAccount() throws SQLException {

    try {
      Connection conn = connectDatabase();

      ResultSet account = conn.createStatement().executeQuery("SELECT * FROM accounts");

      while (account.next()) {

        accountList.add(new Account(account.getString("ACCName"), account.getString("ACCPW")));
      }
      account.close();
      
    } catch (SQLException e) {
      if (conn != null)
        conn.rollback();
      System.out.println("SQLException: " + e.getMessage());
      System.out.println("SQLState: " + e.getSQLState());
      System.out.println("VendorError: " + e.getErrorCode());
    }

    return accountList;

  }

  public List<Produkt> getproductList() {

    return productList;
  }

  public List<Account> getaccountList() {

    return accountList;
  }

}
