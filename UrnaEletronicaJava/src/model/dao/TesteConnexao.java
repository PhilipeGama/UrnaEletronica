/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;


import java.sql.Connection;
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
            Vector<CandidatoBean> beanVector = dao.consultar("");
            for (CandidatoBean bean : beanVector) {
                System.out.println("Id:"+bean.getId()+" Nome:"+bean.getNome()+
                        " numero:"+bean.getNumero()+" partido:"+bean.getPartido().getNome());
            }
            System.out.println("Conectou ao banco de dados");
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco de dados"+e);
        }
    }
    
    
}
