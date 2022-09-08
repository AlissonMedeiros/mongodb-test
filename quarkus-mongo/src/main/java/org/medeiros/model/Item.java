package org.medeiros.model;

import java.math.BigDecimal;

public class Item {

  private long id;
  private Product product;
  private int quantity;
  private BigDecimal price;

  public long getId() {
    return id;
  }

  public Product getProduct() {
    return product;
  }

  public int getQuantity() {
    return quantity;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Item{" +
        "id=" + id +
        ", product=" + product +
        ", quantity=" + quantity +
        ", price=" + price +
        '}';
  }
}
