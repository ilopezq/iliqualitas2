package com.qualitas.conuvprimefaces.model.entities;

public class TipoEndoso {
  private final String id;
  private String descr, tipo;

  public TipoEndoso(String id, String descr, String tipo) {
    this.id = id;
    this.descr = descr;
    this.tipo = tipo;
  }

  public String getId() {
    return id;
  }

  public String getDescr() {
    return descr;
  }

  public void setDescr(String descr) {
    this.descr = descr;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
}
