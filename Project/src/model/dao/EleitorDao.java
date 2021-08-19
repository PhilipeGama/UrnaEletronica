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
import model.bean.EleitorBean;

/**
 *
 * @author Aluno
 */
public class EleitorDao {
    private Connection connection;

    public EleitorDao() throws Exception {
        connection = UrnaConexao.getConnection();
    }
    
    public boolean cadastrar(EleitorBean bean){
        String sql = 
                "insert into eleitor values(0,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1,bean.getNome());
            ps.setString(2,bean.getCpf());
            ps.setString(3,bean.getCep());
            ps.setString(4,bean.getBairro());
            ps.setString(5,bean.getRua());
            ps.setString(6,bean.getNumero());
            
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro"+e);
            return false;
        }
    }
    
    
    public Vector<EleitorBean> consultar(String valorBuscado){
        String sql = "select *from eleitor where elenome like ? ";
      
        try {
           PreparedStatement ps = connection.prepareStatement(sql);
           ps.setString(1,'%'+valorBuscado+'%');
           ResultSet rs = ps.executeQuery();
           Vector lista = new Vector();
           
           while(rs.next()){
                int codigo = rs.getInt("eleid");
                String nome = rs.getString("elenome");
                String cpf = rs.getString("elecpf");
                String cep = rs.getString("elecep");
                String bairro = rs.getString("elebairro");
                String rua = rs.getString("elerua");
              
                String numero = rs.getString("elenumero");
                
                EleitorBean bean = 
                        new EleitorBean(codigo,nome,cpf,cep,rua,bairro,numero); 
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
    
     public EleitorBean consultarCpf(String valorBuscado){
        String sql = "select *from eleitor where elecpf = ? ";
      
        try {
           PreparedStatement ps = connection.prepareStatement(sql);
           ps.setString(1,valorBuscado);
           ResultSet rs = ps.executeQuery();
           
           
           if(rs.first()){
                int codigo = rs.getInt("eleid");
                String nome = rs.getString("elenome");
                String cpf = rs.getString("elecpf");
                String cep = rs.getString("elecep");
                String bairro = rs.getString("elebairro");
                String rua = rs.getString("elerua");
              
                String numero = rs.getString("elenumero");
                
               
                EleitorBean bean = 
                        new EleitorBean(codigo,nome,cpf,cep,rua,bairro,numero); 
                     
           
           ps.close();
           connection.close();
           return bean; 
        }   
           ps.close();
           connection.close();
           return null;
        } catch (SQLException e){
            System.err.println("Erro: "+e);
            return null;
        }
       
    }
    
    
    
    public boolean alterar(EleitorBean bean){
        String sql = 
                "update eleitor set elenome=? ,elecpf=? ,elecep =?,"
                + "elebairro = ?,elerua =?,elenumero = ? "
                + "where eleid = ?";
         
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,bean.getNome());
            ps.setString(2,bean.getCpf());
            ps.setString(3,bean.getCep());
            ps.setString(4, bean.getBairro());
            ps.setString(5,bean.getRua());
            ps.setString(6,bean.getNumero());
            ps.setInt(7,bean.getId());
            
            ps.execute();
            ps.close();
            connection.close();
            
            return true;
        } catch (SQLException e) {
            System.err.println("Erro: "+e);
            return false;
        }
 
    } 
    
    public boolean excluir(int codigo){
        String sql = "delete from eleitor where eleid = ?";
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
    
    
     
   
}
