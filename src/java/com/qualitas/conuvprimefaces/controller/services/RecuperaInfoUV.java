package com.qualitas.conuvprimefaces.controller.services;

import asjava.uniclientlibs.UniConnectionException;
import asjava.uniclientlibs.UniDynArray;
import asjava.uniobjects.UniCommandException;
import asjava.uniobjects.UniFileException;
import asjava.uniobjects.UniSelectListException;
import asjava.uniobjects.UniSessionException;

import com.qualitas.conuvprimefaces.model.ConexionUV;
import com.qualitas.conuvprimefaces.model.entities.RegistroUV;
import com.qualitas.conuvprimefaces.model.entities.TipoEndoso;

import java.util.ArrayList;
import java.util.List;

public class RecuperaInfoUV {
  public List<TipoEndoso> traeInfoTipoEndoso() throws UniSessionException, UniConnectionException, 
          UniCommandException, UniSelectListException, UniFileException {
    ConexionUV cnn;
    
    List<RegistroUV> regs;
    List<TipoEndoso> lista;
    
    TipoEndoso tEnd;
    
    lista = new ArrayList();
    cnn = new ConexionUV();
    regs = cnn.leeRegistros("TENDOSO");
    
    for (RegistroUV reg : regs) {
      tEnd = new TipoEndoso(reg.getId(),reg.getRegistro().extract(1).toString(),reg.getRegistro().extract(2).toString());
      
      lista.add(tEnd);
    }
    
    return lista;
  }
}
