/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Date;

/**
 *
 * @author Philipe
 */
public class UrnaBean {
   private int id;
   private Date datahora;
   private int voto;
   private CandidatoBean candidato;
   private EleitorBean eleitor;

    public UrnaBean(int voto, CandidatoBean candidato, EleitorBean eleitor) {
        this.voto = voto;
        this.candidato = candidato;
        this.eleitor = eleitor;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public CandidatoBean getCandidato() {
        return candidato;
    }

    public void setCandidato(CandidatoBean candidato) {
        this.candidato = candidato;
    }

    public EleitorBean getEleitor() {
        return eleitor;
    }

    public void setEleitor(EleitorBean eleitor) {
        this.eleitor = eleitor;
    }
   
}
