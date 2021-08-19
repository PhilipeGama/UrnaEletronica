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
import model.bean.UsuarioBean;

/**
 *
 * @author Aluno
 */
public class UsuarioDao {
    private Connection connection; 
    
    public UsuarioDao() throws Exception {
      connection =  UrnaConexao.getConnection();
    }
    
    public boolean cadastrar(UsuarioBean bean){
        String sql = 
             "insert into usuario values(0,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,bean.getLogin());
            ps.setString(1,bean.getSenha());
            ps.close();
            connection.close();
            return true;
        } catch (Exception e) {
            System.err.println("Erro: "+e);
            return false;
        }
       
    }
    
    public Vector<UsuarioBean> consultar(String valorBuscado){
        String sql = "select *from usuario where usulogin like ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,'%'+valorBuscado+'%');
            ResultSet rs = ps.executeQuery();
            Vector lista = new Vector();
            
            while(rs.next()){
                int codigo = rs.getInt("usuid");
                String login = rs.getString("usulogin");
                String senha = rs.getString("ususenha");
                
                UsuarioBean bean = new UsuarioBean(codigo,login,senha);
                lista.add(bean);
            }
            
            rs.close();
            ps.close();
            return lista;         
            
        } catch (Exception e) {
            System.err.println("Erro: "+e);
            return null;
        }
    } 
    
    public boolean alterar(UsuarioBean bean){
        String sql = "update usuario set usulogin = ?,ususenha = ? where usuid = ?"; 
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,bean.getLogin());
            ps.setString(2,bean.getSenha());
            ps.close();
            connection.close();
            return true;
        } catch (Exception e) {
            System.err.println("Erro: +"+e);
            return false;
        }
    }
    
    public boolean excluir(int codigo){
        String sql = "delete from usuario where usuid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sql);
            ps.execute();
            ps.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro :"+e);
            return false;
        }    
    }    
}
