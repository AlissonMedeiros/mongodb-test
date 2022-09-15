package org.medeiros.model;

public class Product {

  private Long code;
  private String name;

  public void setCode(Long code) {
    this.code = code;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Long getCode() {
    return code;
  }

  @Override
  public String toString() {
    return "Product{" +
        "code=" + code +
        ", name='" + name + '\'' +
        '}';
  }
}
