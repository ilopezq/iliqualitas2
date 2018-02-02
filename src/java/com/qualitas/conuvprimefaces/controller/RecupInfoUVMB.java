package com.qualitas.conuvprimefaces.controller;

import asjava.uniclientlibs.UniConnectionException;
import asjava.uniobjects.UniCommandException;
import asjava.uniobjects.UniFileException;
import asjava.uniobjects.UniSelectListException;
import asjava.uniobjects.UniSessionException;
import com.qualitas.conuvprimefaces.controller.services.RecuperaInfoUV;
import com.qualitas.conuvprimefaces.model.entities.TipoEndoso;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RecupInfoUVMB {
  private List<TipoEndoso> tiposEndoso;
  private String msgExcepcion;
      
  public RecupInfoUVMB() {
    RecuperaInfoUV traeTiposEndoso = new RecuperaInfoUV();
    
    try {
      tiposEndoso = traeTiposEndoso.traeInfoTipoEndoso();
    } catch (UniSessionException | UniConnectionException | UniCommandException  | UniSelectListException | UniFileException e) {
      msgExcepcion = e.getMessage();
    } catch (Exception e) {
      msgExcepcion = e.getMessage();
    }
  }
  
  public List<TipoEndoso> getTiposEndoso() {
    return tiposEndoso;
  }
  
  public String getMsgExcepcion() {
    return msgExcepcion;
  }
  
}
