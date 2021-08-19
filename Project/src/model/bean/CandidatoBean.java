/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Philipe
 */
public class CandidatoBean {
    private int id;
    private String nome;
    private int numero;
    private PartidoBean partido;

    public CandidatoBean() {
    }

    
    public CandidatoBean(int id, String nome, int numero, PartidoBean partido) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.partido = partido;
    }

    public CandidatoBean(String nome, int numero, PartidoBean partido) {
        this.nome = nome;
        this.numero = numero;
        this.partido = partido;
    }
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public PartidoBean getPartido() {
        return partido;
    }

    public void setPartido(PartidoBean partido) {
        this.partido = partido;
    }

    @Override
    public String toString() {
        return "CandidatoBean{" + "id=" + id + ", nome=" + nome + ", numero=" + numero + ", partido=" + partido.getNome() + '}';
    }
    
    
    
}
