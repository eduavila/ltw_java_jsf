/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.lrw.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author aluno
 */
public class ConnDB {
    
    public static Connection getConnection(){
               
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/especializacao","root","");     
           
            return con;
        }catch(ClassNotFoundException ex){
            System.out.println("Class não encontrada"+ ex.getMessage());    
        }catch(SQLException ex){
            System.out.println("Class não encontrada"+ ex.getMessage());
        }
        
        return null;
    }
}
