package controller;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.*;
import model.Bestelldetail;
import model.Bestellung;
import model.Kunde;
import model.Produkt;
import model.WarenkorbItems;
import util.Data;

/**
 * 
 * @author Heiner, Steffen
 * @version 1.0
 * 
 *          Diese Klasse implementiert alle funktionen des Warenkorbes mit Hilfe einer Warenkorb
 *          Arraylist
 * 
 *
 */

/**
 * @author hebu999
 *
 */
@ManagedBean
@SessionScoped
public class WarenKorbBean implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private final Logger logger = Logger.getLogger(this.getClass().getName());

  @Inject
  Bestellung order;

  @Inject
  Kunde customer;

  @Inject
  Data data;

  private int itemCount;

  double totalPriceNetto;

  private String deliveryDate = "yyyy:MM:dd";

  private String deliveryTime;

  List<WarenkorbItems> warenkorbList;
  List<Bestelldetail> bestelldetailList = new ArrayList<Bestelldetail>();


  public WarenKorbBean() {
    super();
  }

  @PostConstruct
  public void init() {
    warenkorbList = new ArrayList<>();
  }

  /**
   * Wenn das übergeben Produkt Objekt ungleich null ist, wird die Warenkorbliste durch iteriert und
   * ein existant-flag gesetzt, sollte dieses flag auf true sein wird das vorhandene Produkt um 1
   * erhöht, ansonsten wird ein neues hinzugefügt
   * 
   * @param pro
   */
  public void addToBasket(Produkt pro) {

    if (pro != null) {

      logger.info("produktname: " + pro.getPName());
      boolean existant = false;

      for (int i = 0; i < warenkorbList.size(); i++) {

        if (warenkorbList.get(i).getProduct().getPName().equals(pro.getPName())) {

          logger.info("Schon vorhanden!");
          existant = true;

          warenkorbList.get(i).changeAmount(warenkorbList.get(i).getAmount() + 1);

          // warenkorbList.get(i).setAmount(warenkorbList.get(i).getAmount() + 1);

          FacesMessage m = new FacesMessage("Produkt nochmal hinzugefügt!");
          FacesContext.getCurrentInstance().addMessage("produkt", m);

          setItemCount(warenkorbList.size());

          logger.info("Warenkorbliste" + warenkorbList);
        }

      }

      if (!existant) {

        WarenkorbItems newItem = new WarenkorbItems(pro, 1);
        warenkorbList.add(newItem);

        setItemCount(warenkorbList.size());

        FacesMessage m = new FacesMessage("Produkt hinzugefügt!");
        FacesContext.getCurrentInstance().addMessage("produkt", m);
        logger.info("Nicht vorhanden!" + warenkorbList);

      }
      setTotalPriceNetto(calculatePrice());

    } else {

      logger.info("Produkt ist null!!");

    }
  }

  /**
   * erstellt eine neue Instanz von Produkt und iteriert durch die Warenkorbliste um die enthaltenen
   * Produkte und ihre Mengen an die orderToDatabase Methode zu übergeben
   * 
   * @param customer
   */
  public void order(Kunde customer) {

    if (warenkorbList.size() > 0 && customer != null) {

      try {
        logger.info(deliveryDate + " " + deliveryTime);
        Bestellung order = new Bestellung(customer);
        List<Bestelldetail> details = new ArrayList<>();

        order.setBLieferDat(deliveryDate + " " + deliveryTime);

        for (int i = 0; i < warenkorbList.size(); i++) {

          WarenkorbItems index = warenkorbList.get(i);
          Bestelldetail temp = new Bestelldetail(index.getAmount(), order, index.getProduct());

          details.add(temp);

        }
        data.orderToDatabase(details, order);

      } catch (Exception ex) {
        logger.info("Ex: " + ex);


      }

    }

  }

  /**
   * iteriert durch die Warenkorbliste und addiert alle enthaltenen Mengenpreise um den Gesamtpreis
   * zu erhalten
   * 
   * @return totalPrice
   */
  public double calculatePrice() {
    double totalPrice = 0;

    if (warenkorbList != null && warenkorbList.size() > 0) {

      for (int i = 0; i < warenkorbList.size(); i++) {

        totalPrice += warenkorbList.get(i).getQuantityPrice();

      }

    }
    return totalPrice;

  }



  /**
   * Setter and Getter
   */
  public int getItemCount() {
    return itemCount;
  }

  public void setItemCount(int itemCount) {
    this.itemCount = itemCount;
  }

  public String getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(String deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public String getDeliveryTime() {
    return deliveryTime;
  }

  public void setDeliveryTime(String deliveryTime) {
    this.deliveryTime = deliveryTime;
  }

  public double getTotalPriceNetto() {
    return totalPriceNetto;
  }

  public void setTotalPriceNetto(double totalPriceNetto) {
    this.totalPriceNetto = totalPriceNetto;
  }

  public Kunde getCustomer() {
    return customer;
  }

  public void setCustomer(Kunde customer) {
    this.customer = customer;
  }

  public List<WarenkorbItems> getwarenkorbList() {
    return warenkorbList;
  }

  public void setwarenkorbList(List<WarenkorbItems> warenkorbList) {
    this.warenkorbList = warenkorbList;
  }

  public List<Bestelldetail> getBestelldetailList() {
    return bestelldetailList;
  }

  public void setBestelldetailList(List<Bestelldetail> bestelldetailList) {
    this.bestelldetailList = bestelldetailList;
  }
}
