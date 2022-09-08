package org.medeiros.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import java.util.List;
import java.util.UUID;
import org.bson.types.ObjectId;

@MongoEntity(collection = "orders")
public class Order {

  private long id;
  private List<Item> items;

  public long getId() {
    return id;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  @Override
  public String toString() {
    return "Order{" +
        "id=" + id +
        ", items=" + items +
        '}';
  }
}
