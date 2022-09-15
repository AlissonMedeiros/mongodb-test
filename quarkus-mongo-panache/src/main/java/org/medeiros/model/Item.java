package org.medeiros.model;

import java.math.BigDecimal;

public class Item {

  private long code;
  private Product product;
  private int quantity;
  private BigDecimal price;

  public long getCode() {
    return code;
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

  public void setCode(long code) {
    this.code = code;
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
        "code=" + code +
        ", product=" + product +
        ", quantity=" + quantity +
        ", price=" + price +
        '}';
  }
}
