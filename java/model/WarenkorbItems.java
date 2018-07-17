package model;

import javax.faces.event.ValueChangeEvent;

/**
 * @author Heiner, Steffen
 * @version 1.0
 * 
 * Diese Klasse stellt den Objekttyp für die Warenkorbliste zur Verfügung
 */

public class WarenkorbItems {

  private Produkt product;
  private int Amount;
  private double quantityPrice;

  public WarenkorbItems(Produkt pro, int amount) {
    setProduct(pro);
    setAmount(amount);
    setQuantityPrice(pro.getPPreisNetto() * amount);
  }
  
  /**
   * Verändert über die setter den Mengenpreis abhängig von der übergebenen Menge
   * 
   * @param newAmount
   */
  public void changeAmount(int newAmount)
  {
          setAmount(newAmount);
          setQuantityPrice(product.getPPreisNetto()*Amount);
  }

  /**
   * Setter and Getter
   */
  public Produkt getProduct() {
    return product;
  }

  public void setProduct(Produkt product) {
    this.product = product;
  }

  public int getAmount() {
    return Amount;
  }

  public void setAmount(int amount) {
    Amount = amount;
  }

  public double getQuantityPrice() {
    return quantityPrice;
  }

  public void setQuantityPrice(double quantityPrice) {
    this.quantityPrice = quantityPrice;
  }
}
