/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrofuncionario.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author raquel
 */
public class ConnectionFactory {
    
  static Connection conexao=null;
 static Statement st;
  static  ResultSet rs;
 static String url="jdbc:mysql://localhost:3306/cadastrofuncionario";
static  String usuario="root";
 static String senha ="";
 
 public static Connection criarconexao(){
     try{
       conexao=DriverManager.getConnection(url, usuario, senha);
       return conexao;
     }catch(Exception e){
         System.out.println("Não foi possivel conectar"+e);
     }
     return null;
 }
  
    public void executesql(String sql){
        try{
            st=conexao.createStatement();
            rs=st.executeQuery(sql);
            
        }catch(SQLException e){
            System.out.println("Não foi possivel conectar"+e);
        }
        
    }
    
    
    
}
