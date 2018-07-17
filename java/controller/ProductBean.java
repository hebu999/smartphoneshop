package controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.*;
import util.Data;
import model.Produkt;

/**
 * 
 * 
 * @author Heiner, Steffen
 * @version 1.1
 * 
 * @category Diese Klasse holt sich die Produkt ArrayList aus der JDBC-Klasse und übergibt diese an
 *           die entsprechende xhtml-Datei.
 * 
 * 
 */

@ManagedBean
@RequestScoped

public class ProductBean implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private final Logger logger = Logger.getLogger(this.getClass().getName());

  @Inject
  Data data;

  public ProductBean(  ) throws SQLException {}

  @PostConstruct
  public void init() {
    getProducts();
  }
  
  private List<Produkt> productList;

  /**
   * Es wird die getSQLDataProduct Methode der Data Klasse aufgerufen und die Ergebnisse in eine productList geschrieben
   * 
   * @return produkte.xhtml
   */
  public String getProducts() {

    try {
      productList = data.getSQLDataProduct();

      logger.info("ProductList: " + productList);
    } catch (SQLException e) {
      
      e.printStackTrace();
    }
    logger.setLevel(Level.ALL);
    return "/produkte.xhtml";
  }

  public List<Produkt> getProductList() {
    return productList;
  }

  public void setProductList(List<Produkt> productList) {
    this.productList = productList;
  }
}