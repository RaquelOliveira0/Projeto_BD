/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrofuncionario.model.dao;

import cadastrofuncionario.connection.ConnectionFactory;
import cadastrofuncionario.model.bean.Departamento;
import cadastrofuncionario.model.bean.Projeto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raquel
 */
public class ProjetoDAO {
    private Connection connection;

    public ProjetoDAO() {
          this.connection=ConnectionFactory.criarconexao();

    }
        public boolean inserirPROJ(Projeto j){
        try {
            String sql ="INSERT INTO projeto(Projnome,Projnumero,Projlocal,Dep)VALUES (?,?,?,?)";
            PreparedStatement stm =connection.prepareStatement(sql);
            stm.setString(1,j.getProjnome());
            stm.setInt(2,j.getProjnumero());
            stm.setString(3,j.getProjlocal());
            stm.setInt(4,j.getDep().getDcodigo());
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
    
 public boolean removerPROJ(int cod){
       try {
            String sql ="delete from projeto where Projnumero = ?";
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
 
 public boolean editarPROJ(Projeto p){
    
try{
    String sql= "UPDATE projeto SET Projnome = ?,Projlocal= ?,Dep =? where Projnumero= ?" ;
    PreparedStatement stm =connection.prepareStatement(sql);
           stm.setString(1,p.getProjnome());
            stm.setString(2,p.getProjlocal());
            stm.setInt(3,p.getDep().getDcodigo());
            stm.setInt(4,p.getProjnumero());

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
 
   public List<Projeto>showPROJ(){
      List<Projeto>projs=new ArrayList();
        try { 
            String sql= "SELECT * FROM  projeto";
            PreparedStatement stm =connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Projeto p =new Projeto();
                p.setProjnome(rs.getString("Projnome"));
                p.setProjnumero(rs.getInt("Projnumero"));
                p.setProjlocal(rs.getString("Projlocal"));
               Departamento d =new Departamento();
                d.setDcodigo(rs.getInt("Dep"));
                p.setDep(d);

               projs.add(p);
            }
            stm.close();
            rs.close();
            return projs;
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao lista Pessoas", ex);
        }
       
}
 
  
 
 
 
 
 
}
