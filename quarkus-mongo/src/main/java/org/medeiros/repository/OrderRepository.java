package org.medeiros.repository;

import com.mongodb.client.MongoClient;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.medeiros.model.Item;
import org.medeiros.model.Order;
import org.medeiros.model.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.eq;

@ApplicationScoped
public class OrderRepository {

	private final MongoClient mongoClient;

	@Inject
	public OrderRepository(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}

	public Optional<Order> find(Long id) {
		Bson filter = eq("code", id);

		return Optional.ofNullable(mongoClient.getDatabase("order")
			.getCollection("orders")
			.find(filter)
			.map(doc -> {
				Order order = new Order();
				order.setCode(doc.getLong("code"));
				List<Document> items = doc.get("items", ArrayList.class);
				order.setItems(items.stream()
					.map(d -> {
						Item item = new Item();
						item.setCode(d.getLong("code"));
						item.setPrice(BigDecimal.valueOf(Double.valueOf(d.get("price").toString())));
						item.setQuantity(d.getInteger("quantity"));
						var p = d.get("product", Document.class);
						var product = new Product();
						product.setCode(p.getLong("code"));
						product.setName(p.getString("name"));
						item.setProduct(product);
						return item;
					}).collect(Collectors.toList()));
				return order;
			}).first());
	}

	public void persist(Order order) {
		Document document = new Document()
			.append("code", order.getCode())
			.append("items", order.getItems());
		mongoClient.getDatabase("order")
			.getCollection("orders")
			.insertOne(document);
	}
}
