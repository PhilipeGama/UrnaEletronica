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
import java.util.ArrayList;
import java.util.Vector;
import model.bean.PartidoBean;

/**
 *
 * @author Philipe
 */
public class PartidoDao {
    private Connection connection;
    
    public PartidoDao() throws Exception{
      connection = UrnaConexao.getConnection();
    }
    
    public boolean cadastrar(PartidoBean partido){
       String sql = 
               "insert into partido values (0,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,partido.getNome());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar partido"+e);
            return false;
        }
    }
    
    public ArrayList<PartidoBean> consultar(String valorBuscado){
        String sql = "select *from partido where parnome like ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,'%'+valorBuscado+'%');
            ResultSet rs = ps.executeQuery();
            ArrayList<PartidoBean> listaPartido = new ArrayList();
            
            while(rs.next()){
                int codigo = rs.getInt("parid");
                String nome = rs.getString("parnome");
                PartidoBean partido = new PartidoBean(codigo,nome);
                listaPartido.add(partido);
            }  
            ps.close();
            connection.close();
            return listaPartido;
        } catch (SQLException e) {
            System.err.println("Erro:"+e);
        }
        return null;
        
    }
    
    public boolean alterar(PartidoBean partido){
       String sql = "update partido set parnome = ? where parid = ?"; 
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1,partido.getNome());
            ps.setInt(2,partido.getId());
            ps.execute();
            
            connection.close();
            return true;
            
        } catch (SQLException e) {
            System.err.println("Erro"+e);
            return true;
        }
    }
    
    public boolean excluir(int codigo){
        String sql = "delete from partido where parid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro"+e);
            return false;
        }
        

    }
    
}
