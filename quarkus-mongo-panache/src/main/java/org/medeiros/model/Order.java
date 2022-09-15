package org.medeiros.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import java.util.List;

@MongoEntity(collection = "orders")
public class Order {

  private long code;
  private List<Item> items;

  public long getCode() {
    return code;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setCode(long code) {
    this.code = code;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  @Override
  public String toString() {
    return "Order{" +
        "code=" + code +
        ", items=" + items +
        '}';
  }
}
