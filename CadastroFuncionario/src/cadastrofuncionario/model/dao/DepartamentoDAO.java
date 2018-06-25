/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrofuncionario.model.dao;


import cadastrofuncionario.connection.ConnectionFactory;
import cadastrofuncionario.model.bean.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.util.ArrayList;
/**
 *
 * @author raquel
 */
public class DepartamentoDAO {
    private Connection connection;
    
    public DepartamentoDAO(){
        this.connection=ConnectionFactory.criarconexao();
    }
    public boolean inserir(Departamento d){
        try {
            String sql ="INSERT INTO departamento(Dcodigo,Dnome,Dlocal)VALUES (?, ?,?)";
            PreparedStatement stm =connection.prepareStatement(sql);
            stm.setInt(1,d.getDcodigo());
            stm.setString(2,d.getDnome());
            stm.setString(3,d.getDlocal());
            int executeUpdate = stm.executeUpdate();
            stm.close();
            if(executeUpdate > 0){
                 return true;
            }else{
                return false;
            }         
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
             throw new RuntimeException("Falha ao inserir Pessoas", ex);
        }
    }
    
    public List<Departamento>showdep(){
      List<Departamento>deps=new ArrayList();
        try { 
            String sql= "SELECT * FROM DEPARTAMENTO";
            PreparedStatement stm =connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Departamento d =new Departamento();
                d.setDcodigo(rs.getInt("Dcodigo"));
                d.setDnome(rs.getString("Dnome"));
                d.setDlocal(rs.getString("Dlocal"));
               deps.add(d);
            }
            stm.close();
            rs.close();
            return deps;
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao lista Pessoas", ex);
        }
       
}
    
   public boolean remover(int cod){
       try {
            String sql ="delete from departamento where Dcodigo = ?";
            PreparedStatement stm =connection.prepareStatement(sql);
            stm.setInt(1,cod);
            int executeUpdate = stm.executeUpdate();
            stm.close();
            //connection.close(); 
            if(executeUpdate > 0){
            return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
             throw new RuntimeException("Erro ao remover departamento", ex);
            
        }
       
  
   } 
    public Departamento buscar(Departamento dep){
    String sql ="select * from departamento where Dcodigo = ?";    
        try {
            Departamento d=new Departamento();
            PreparedStatement stm =connection.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            rs.next();
            d.setDcodigo(rs.getInt("Dcodigo"));
            d.setDnome(rs.getString("Dnome"));
            d.setDlocal(rs.getString("Dlocal"));
            return dep;
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao buscar registro", ex);
        }      
    }
public boolean editar(Departamento d){
    
try{
    String sql= "UPDATE departamento SET Dnome= ?,Dlocal= ? where Dcodigo= ?" ;
    PreparedStatement stm =connection.prepareStatement(sql);
           
           stm.setString(1,d.getDnome());
           stm.setString(2,d.getDlocal());
            stm.setInt(3,d.getDcodigo());
           
    int execute = stm.executeUpdate();
         stm.close();
         
           if(execute > 0){
            return true;
            }
            return false;
         //System.out.println("");
}catch(SQLException ex){
     Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao buscar registro", ex);
}
    
}
}
