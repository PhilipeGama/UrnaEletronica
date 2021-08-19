/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.Vector;
import model.bean.CandidatoBean;

/**
 *
 * @author Aluno
 */
public class TesteConnexao {
    public static void main(String[] args) {
        try {
            
            Connection connection = 
                    UrnaConexao.getConnection();
            CandidatoDao dao = new CandidatoDao();
            ArrayList<CandidatoBean> Cadindatos = dao.consultar("");
            for (CandidatoBean candidato : Cadindatos) {
                System.out.println(candidato.toString());
            }
            System.out.println("Conectou ao banco de dados");
            
            
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco de dados"+e);
        }
    }
    
    
}
