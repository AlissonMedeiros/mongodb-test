package org.medeiros.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import javax.enterprise.context.ApplicationScoped;
import org.medeiros.model.Order;

@ApplicationScoped
public class OrderRepository implements PanacheMongoRepository<Order> {
}
