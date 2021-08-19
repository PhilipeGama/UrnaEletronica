/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import model.bean.UrnaBean;

/**
 *
 * @author Philipe
 */
public class UrnaDao {
    private Connection connection;
    
    public UrnaDao() throws Exception{
        connection = UrnaConexao.getConnection();
    }
    
    public boolean cadastrar(UrnaBean bean){
        String sql = 
                "insert into urna(urnid,urnvoto,urncanid,urneleid)"
                + "values(0,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,bean.getVoto());
            ps.setInt(2,bean.getCandidato().getId());
            ps.setInt(3,bean.getEleitor().getId());
            
            ps.execute();
            ps.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro: "+e);
            return false;
        }
       
    }
    
     public boolean votoBranco(int urneleid){
        String sql = 
                "insert into urna(urnid,urnvoto,urncanid,urneleid)"
                + "values(0,?,?,?)";
        int i = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setInt(1, 999);
            ps.setInt(2,0);
            ps.setInt(3,urneleid);
            
            ps.execute();
            ps.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro: "+e);
            return false;
        }
       
    }
     
     public Vector<UrnaBean> contaVoto(){
        String sql = 
                "select count(*),cannome,parnome from urna "
                + "inner join candidato on canid = urncanid "
                + "inner join eleitor on eleid = urneleid "
                + "inner join partido on canparid = parid "
                + "group by canid";
        try {
            
                
            //String valorBuscado ="";
            PreparedStatement ps = connection.prepareStatement(sql);
            //ps.setString(1,'%'+valorBuscado+'%');
            ResultSet rs = ps.executeQuery();
            Vector <UrnaBean> listaVotos = new Vector();
           
            while (rs.next()){
                  Vector linha = new Vector();
                  
                  int totVoto = rs.getInt("count(*)");
                  String canNome = rs.getString("cannome");
                  String parNome = rs.getString("parNome");
                  
                  
                  UrnaBean bean = new UrnaBean(parNome, canNome, totVoto);
                  listaVotos.add(bean);
               
            }
            
            ps.execute();
            ps.close();
            return listaVotos;
        } catch (Exception e) {
            System.out.println("Erro: "+e);
            return null;
        }
       
        
    }
     
     
     
   
    
    
    
}
