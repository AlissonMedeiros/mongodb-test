package org.medeiros.controller;

import org.medeiros.model.Order;
import org.medeiros.repository.OrderRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/orders")
public class OrderController {

	private final OrderRepository repository;

	public OrderController(OrderRepository repository) {
		this.repository = repository;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") Long id) {
		final var order = repository.find(id);
		if (order.isPresent()) {
			return Response.ok(order).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response post(Order order) {
		repository.persist(order);
		return Response.status(Response.Status.CREATED).entity(order).build();
	}

}
