package org.medeiros.repository;

import com.mongodb.client.MongoClient;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.medeiros.model.Order;

@ApplicationScoped
public class OrderRepository {

  private final MongoClient mongoClient;

  @Inject
  public OrderRepository(MongoClient mongoClient) {
    this.mongoClient = mongoClient;
  }

  public Order find(Long id) {
    return mongoClient.getDatabase("order")
        .getCollection("orders")
        .find()
        .map(doc -> {
          Order order = new Order();
          order.setId(id);
          return order;
        }).first();
  }

  public void persist(Order order) {
  }
}
