package util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.*;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import com.mysql.jdbc.Driver;
import java.io.OutputStream;
import model.Produkt;
import model.Account;

/**
 * 
 * @author Heiner, Steffen
 * @version 1.0
 * 
 * @category Diese Klasse stellt eine JDBC Verbindung zur Datenbank her und speichert die
 *           Datensätzen in zwei ArrayLists.
 * 
 */

@Named(value = "JDBCData")
@ApplicationScoped
public class JDBCData implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private final Logger logger = Logger.getLogger(this.getClass().getName());

  List<Produkt> productList = new ArrayList<Produkt>();
  List<Account> accountList = new ArrayList<Account>();
  Connection conn = null;

  public JDBCData() {

  }

  @PersistenceUnit
  private EntityManagerFactory emf = Persistence.createEntityManagerFactory("shop");

  // JDBC Verbindung wird hergestellt und in die Variable "conn" geschrieben und returned
  public Connection connectDatabase() throws SQLException {

    try {
      
      Class.forName("com.mysql.cj.jdbc.Driver");
      String dbURL =
          "jdbc:mysql://localhost:3306/smartphoneshop2?useLegacyDatetimeCode=false&useJDBCCompliantTimezoneShift=true&serverTimezone=UTC";
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

  // Daten aus der Tabelle "produkt" werden abgerufen und in die productList geschrieben
  public List<Produkt> getSQLDataProduct() throws SQLException {
    logger.setLevel(Level.ALL);

    Connection conn = connectDatabase();
    ResultSet product = conn.createStatement().executeQuery("SELECT * FROM produkt");

    while (product.next()) {

      //productList.add(new Produkt(product.getString("PName"), product.getBigDecimal("PPreisNetto"),
        //  product.getString("PTyp"), product.getString("PKomment")));
    }
    product.close();

    return productList;
  }

  // Daten aus der Tabelle "accounts" werden abgerufen und in die accountList geschrieben
  public List<Account> getSQLDataAccount() throws SQLException {
    logger.setLevel(Level.ALL);

    Connection conn = connectDatabase();
    ResultSet account = conn.createStatement().executeQuery("SELECT * FROM accounts");

    while (account.next()) {
      //accountList.add(new Account(account.getString("ACCNAME"), account.getString("ACCPWD")));
    }
    account.close();
    return accountList;
  }
  
  public Account findAccountByLoginName(String accname) {
    Account acc = null;
    logger.setLevel(Level.ALL);
    try {
      EntityManager em = emf.createEntityManager();
      Query query = em.createQuery("SELECT u from accounts u WHERE u.accname=:accname");
      query.setParameter("accname", accname);
      logger.info("Account query: " + query);
      acc = (Account) query.getSingleResult();
      em.close();
    }
      catch(NoResultException nre)
      {
          return acc;
      }
      catch (Exception ex)
      {
          throw ex;
      }  
    return acc;
  }
  
  public List<Produkt> getProductList() {
    return productList;
  }

  public void setProductList(List<Produkt> productList) {
    this.productList = productList;
  }

  public List<Account> getAccountList() {
    return accountList;
  }

  public void setAccountList(List<Account> accountList) {
    this.accountList = accountList;
  }
}