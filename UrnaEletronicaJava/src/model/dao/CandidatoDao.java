/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.CandidatoBean;
import model.bean.EleitorBean;
import model.bean.PartidoBean;

/**
 *
 * @author Aluno
 */
public class CandidatoDao {
    private Connection connection;

    public CandidatoDao() throws Exception {
        connection = UrnaConexao.getConnection();
    }
    
    public boolean cadastrar(CandidatoBean bean){
        String sql = 
                "insert into candidato values(0,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1,bean.getNome());
            ps.setInt(2,bean.getNumero());
            ps.setInt(3,bean.getPartido().getId());
           
            
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro"+e);
            return false;
        }
    }
    
    
    public Vector<CandidatoBean> consultar(String valorBuscado){
        String sql = "select *from candidato "
                + "inner join partido on parid = canparid where cannome like ?" ;
      
        try {
           
           PreparedStatement ps = connection.prepareStatement(sql);
         
           ps.setString(1,'%'+valorBuscado+'%');
           ResultSet rs = ps.executeQuery();
           Vector lista = new Vector();
           
           while(rs.next()){
                int codigo = rs.getInt("canid");
                String nome = rs.getString("cannome");
                int numero = rs.getInt("cannumero");
                int parid = rs.getInt("parid");
                String parnome = rs.getString("parnome");
                
                                   
                PartidoBean beanPartido = new PartidoBean(parid,parnome);
                  
               
                CandidatoBean bean = 
                        new CandidatoBean(codigo,nome,numero,beanPartido); 
                lista.add(bean);
               
           }
          
           ps.close();
           connection.close();
           return lista;       
        } catch (SQLException e){
            System.err.println("Erro: "+e);
            return null;
        }
    }
    
    
    public boolean alterar(CandidatoBean bean){
        String sql = 
                "update candidato set cannome=? ,cannumero=? ,canparid =? where canid = ?";
         
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,bean.getNome());
            
            ps.setString(2,""+bean.getNumero());
            ps.setInt(3, bean.getPartido().getId());
            ps.setInt(4,bean.getId());
            
            ps.execute();
            
            connection.close();
            
            return true;
        } catch (SQLException e) {
            System.err.println("Erro: "+e);
            return false;
        }
 
    } 
    
    public boolean excluir(int codigo){
        String sql = "delete from candidato where canid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,codigo);
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro: "+e);
            return false;
        }
        
    }
    
    
     public CandidatoBean consultarNumero(String valorBuscado){
        String sql = "select *from candidato "
                + "inner join partido on parid = canparid where cannumero = ?" ;
      
        try {
     
           PreparedStatement ps = connection.prepareStatement(sql);
         
           ps.setString(1,valorBuscado);
           
            
           ResultSet rs = ps.executeQuery();
            if(rs.first()){
                int codigo = rs.getInt("canid");
                String nome = rs.getString("cannome");
                int numero = rs.getInt("cannumero");
                int parid = rs.getInt("parid");
                String parnome = rs.getString("parnome");
                
                                   
                PartidoBean beanPartido = new PartidoBean(parid,parnome);
                  
               
                CandidatoBean bean = 
                        new CandidatoBean(codigo,nome,numero,beanPartido); 
                ps.close();
           
                connection.close();           
           
                return bean;  
           
               
           }
          
           ps.close();
           
           connection.close();  
                      
        } catch (SQLException e){
            System.err.println("Erro: "+e);
            return null;
        }
         return null;
    }
    
    
    
     
   
}
