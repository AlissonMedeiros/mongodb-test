package org.medeiros.model;

import java.util.List;
import java.util.Objects;

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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Order order = (Order) o;
		return code == order.code && Objects.equals(items, order.items);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, items);
	}

	@Override
  public String toString() {
    return "Order{" +
        "code=" + code +
        ", items=" + items +
        '}';
  }
}
