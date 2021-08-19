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
   private String partido;
   private CandidatoBean candidato;
   private String cannome;
   private EleitorBean eleitor;
   private int totalVoto;

    public UrnaBean(int voto, CandidatoBean candidato, EleitorBean eleitor) {
        this.voto = voto;
        this.candidato = candidato;
        this.eleitor = eleitor;
    }

    public UrnaBean(String partido, String cannome, int totalVoto) {
        this.partido = partido;
        this.cannome = cannome;
        this.totalVoto = totalVoto;
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

    public int getTotalVoto() {
        return totalVoto;
    }

    public void setTotalVoto(int totalVoto) {
        this.totalVoto = totalVoto;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getCannome() {
        return cannome;
    }

    public void setCannome(String cannome) {
        this.cannome = cannome;
    }

    
   
    
    
}
