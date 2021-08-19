/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Philipe
 */
public class UrnaConexao {
  
 public static Connection getConnection()throws Exception{
        try {
           String host = "jdbc:mysql://localhost/urnaeletronica";
           String user = "root";
           String password = "root";
           Connection connection = 
                   DriverManager.getConnection(host, user, password);
           return connection;
        } catch (Exception e) {
            throw new Exception("Erro ao conecta com o banco de dado "+e.getMessage());
        }
    }
}
 

