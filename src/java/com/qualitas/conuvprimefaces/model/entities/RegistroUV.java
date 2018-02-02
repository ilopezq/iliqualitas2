package com.qualitas.conuvprimefaces.model.entities;

import asjava.uniclientlibs.UniDynArray;

public class RegistroUV {
  private final String id;
  private final UniDynArray registro;

  public RegistroUV(String id, UniDynArray registro) {
    this.id = id;
    this.registro = registro;
  }

  public String getId() {
    return id;
  }

  public UniDynArray getRegistro() {
    return registro;
  }
}
