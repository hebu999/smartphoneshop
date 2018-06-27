package controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.*;
import util.JDBCData;
import model.Produkt;

/**
 * 
 * 
 * @author Heiner, Steffen
 * @version 1.0
 * 
 * @category Diese Klasse holt sich die Produkt ArrayList aus der JDBC-Klasse und übergibt diese an
 *           die entsprechende xhtml-Datei.
 * 
 * 
 */

@Named(value = "productBean")
@RequestScoped
public class ProductBean implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private final Logger logger = Logger.getLogger(this.getClass().getName());

  @Inject
  JDBCData jdBC;

  public ProductBean() throws SQLException {}

  private List<Produkt> productList;

  public String getProducts() {

    try {
      productList = jdBC.getSQLDataProduct();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
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