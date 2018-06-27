package controller;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;
import javax.inject.*;
import model.Bestelldetail;
import model.Bestellung;
import model.Kunde;
import util.JDBCData;

/**
 * 
 * @author Heiner, Steffen
 *
 */
public class WarenKorbBean implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private final Logger logger = Logger.getLogger(this.getClass().getName());

  @Inject
  LoginBean logBean;

  @Inject
  Kunde customer;

  @Inject
  Bestellung order;

  @Inject
  Bestelldetail orderDetail;

  private int itemCount;

  double totalPriceNetto;
  double totalPriceBrutto;
  
  private Date deliveryDate;

  private String deliveryTime;

  public int getItemCount() {
    return itemCount;
  }

  public void setItemCount(int itemCount) {
    this.itemCount = itemCount;
  }

  public Date getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(Date deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public String getDeliveryTime() {
    return deliveryTime;
  }

  public void setDeliveryTime(String deliveryTime) {
    this.deliveryTime = deliveryTime;
  }
}