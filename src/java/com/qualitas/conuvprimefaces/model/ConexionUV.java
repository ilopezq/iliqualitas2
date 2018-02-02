package com.qualitas.conuvprimefaces.model;

import asjava.uniclientlibs.UniConnectionException;
import asjava.uniclientlibs.UniDynArray;
import asjava.uniobjects.UniCommand;
import asjava.uniobjects.UniCommandException;
import asjava.uniobjects.UniFile;
import asjava.uniobjects.UniFileException;
import asjava.uniobjects.UniSelectList;
import asjava.uniobjects.UniSelectListException;
import asjava.uniobjects.UniSession;
import asjava.uniobjects.UniSessionException;
import com.qualitas.conuvprimefaces.model.entities.RegistroUV;
import java.util.ArrayList;
import java.util.List;

public class ConexionUV {

  private static UniSession uvsSesion;

  {
    uvsSesion = new UniSession();
  }

  public ConexionUV() throws UniConnectionException, UniSessionException {
    estableceConexion();
  }

  public List<RegistroUV> leeRegistros(String nomBDSise) throws UniConnectionException,
          UniSessionException, UniCommandException, UniSelectListException, UniFileException {
    UniCommand uvcComando;
    UniSelectList uvslLista;
    UniFile uvfBDSise;
    UniDynArray uvdRegBDSise;

    RegistroUV registroUV;
    String strCmd, idBDSise;

    List<RegistroUV> listaRegistros = new ArrayList();

    if (!validaConexion()) {
      estableceConexion();
    }

    strCmd = "SELECT " + nomBDSise;
    uvcComando = uvsSesion.command();
    uvcComando.setCommand(strCmd);
    uvcComando.exec();
    uvslLista = uvsSesion.selectList(0);
    uvfBDSise = uvsSesion.openFile(nomBDSise);
    System.out.println("Entro a la base de datos " + nomBDSise);

    while (!uvslLista.isLastRecordRead()) {
      idBDSise = uvslLista.next().toString();

      if (!idBDSise.equals("")) {
        System.out.println("Encontro registro " + idBDSise);
        uvfBDSise.setRecordID(idBDSise);
        uvdRegBDSise = new UniDynArray(uvfBDSise.read().toString());
        registroUV = new RegistroUV(idBDSise, uvdRegBDSise);
        listaRegistros.add(registroUV);
     }
    }

    return listaRegistros;
  }

  public static boolean validaConexion() {
    return uvsSesion.isActive();
  }

  private static void estableceConexion() throws UniConnectionException, UniSessionException {
    uvsSesion = new UniSession();
    uvsSesion.setHostName("110.10.0.11");
    uvsSesion.setUserName("hchavez");
    uvsSesion.setPassword("Jackal80-");
    uvsSesion.setAccountPath("SISE");
    uvsSesion.setDataSourceType("UNIVERSE");
    uvsSesion.connect();
  }
}
