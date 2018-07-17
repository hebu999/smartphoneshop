package util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.*;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import com.mysql.jdbc.Driver;
import java.io.OutputStream;
import model.Produkt;
import model.Account;
import model.Adresse;
import model.Bestelldetail;
import model.Bestellung;
import model.Kunde;

/**
 * 
 * @author Heiner, Steffen
 * @version 1.0
 * 
 * @category Diese Klasse implementiert alle benötigten Datenbankzugriffe der verschiedenen Klasssen
 * 
 */

@Named(value = "Data")
@ApplicationScoped
public class Data implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private final Logger logger = Logger.getLogger(this.getClass().getName());

  private List<Produkt> productList = new ArrayList<Produkt>();
  private List<Account> accountList = new ArrayList<Account>();

  @PersistenceUnit
  private EntityManagerFactory emf;

  @Resource
  private UserTransaction utx;

  public Data() {

  }


  /**
   * 
   * Daten aus der Tabelle "produkt" werden abgerufen und in eine Produkt arrayList geschrieben
   * 
   * @return productList
   * @throws SQLException
   */
  public List<Produkt> getSQLDataProduct() throws SQLException {
    List<Produkt> productList = null;
    EntityManager em = emf.createEntityManager();
    logger.setLevel(Level.ALL);

    try {
      TypedQuery<Produkt> query = em.createNamedQuery("Produkt.findAll", Produkt.class);

      productList = (List<Produkt>) query.getResultList();

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
    logger.info("Produktlist: " + productList);

    return productList;
  }

  /**
   * 
   * Das übergebene Bestellungsobjekt wird persistiert und die Bestelldetail Liste durch iteriert um
   * die enthaltenen details zu persistieren
   * 
   * @param detailList
   * @param order
   * @throws Exception
   */
  public void orderToDatabase(List<Bestelldetail> detailList, Bestellung order) throws Exception {
    EntityManager em = emf.createEntityManager();
    logger.setLevel(Level.INFO);

    logger.info("Bestellung: " + order);

    try {
      utx.begin();
      em.joinTransaction();
      em.persist(order);
      for (int i = 0; i < detailList.size(); i++) {

        em.persist(detailList.get(i));

      }

      utx.commit();
      em.close();
    } catch (Exception ex) {
      try {
        utx.rollback();
      } catch (Exception ex2) {
        ex2.printStackTrace();
      }
      throw ex;
    }
  }

  /**
   * Versucht über eine NamedQuery einen Accountnamen zu finden, wenn dies nicht der Fall ist wird
   * eine NoResultException geworfen und null zurückgegeben
   * 
   * @param accname
   * @return acc
   */
  public Account findAccountByLoginName(String accname) {

    Account acc = null;
    EntityManager em = emf.createEntityManager();
    logger.setLevel(Level.ALL);

    try {
      logger.info("accname: " + accname);
      TypedQuery<Account> query = em.createNamedQuery("Account.findByName", Account.class);
      acc = query.setParameter("accname", accname).getSingleResult();

      logger.info("Account query: " + acc);

    } catch (NoResultException nre) {
      nre.printStackTrace();
      return acc;
    } catch (Exception ex) {
      ex.printStackTrace();
      throw ex;
    }
    return acc;
  }

  /**
   * 
   * Diese Methode holt sich über eine NamedQuery alle Lieferdaten der Bestellungstabelle und
   * speichert sie in einer ArrayList
   * 
   * @return deliveryDateList
   */
  public List<Date> getdeliveryDate() {

    List<Date> deliveryDateList = null;
    EntityManager em = emf.createEntityManager();
    logger.setLevel(Level.ALL);

    try {
      TypedQuery<Date> query = em.createNamedQuery("Bestellung.findDates", Date.class);

      deliveryDateList = (List<Date>) query.getResultList();

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
    logger.info("Datelist: " + deliveryDateList);
    return deliveryDateList;
  }

  /**
   * Das übergebene Kundenobjekt wird persistiert, optional kann hier auch das Adressobjekt
   * persisiert werden
   * 
   * @param customer
   * @throws Exception
   */
  public void registerCustomer(Kunde customer) throws Exception {
    EntityManager em = emf.createEntityManager();

    try {
      utx.begin();
      em.joinTransaction();

      em.persist(customer.getFkAccid());
      // em.persist(customer.getFkAid());
      em.persist(customer);

      utx.commit();

    } catch (Exception ex) {

      utx.rollback();
      em.close();
      throw ex;
    }
    em.close();
  }


  /**
   * 
   * Es wird versucht über den Account Fremdschlüssel des Kunden eine AccountId zu finden, wenn
   * nicht wird null zurückgegeben
   * 
   * @param aName
   * @return kunde
   */
  public Kunde findCustomer(String aName) {
    Kunde kunde = null;
    EntityManager em = emf.createEntityManager();
    try {
      TypedQuery<Kunde> query = em.createNamedQuery("Kunde.findByAccId", Kunde.class);
      query.setParameter("name", aName);
      kunde = (Kunde) query.getSingleResult();
      em.close();
    } catch (Exception ex) {
      em.close();
      throw ex;
    }
    return kunde;
  }


  /**
   * Setter and Getter
   */
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
