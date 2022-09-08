package org.medeiros.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.medeiros.model.Order;
import org.medeiros.repository.OrderRepository;

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
    final var order = repository.find("_id", id)
        .firstResultOptional();
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
