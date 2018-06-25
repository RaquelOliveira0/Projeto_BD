/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrofuncionario.model.dao;

import cadastrofuncionario.connection.ConnectionFactory;
import cadastrofuncionario.model.bean.Departamento;
import cadastrofuncionario.model.bean.Funcionario;
import java.sql.Connection;
import java.sql.Date;
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
public class FuncionarioDAO {
     private Connection connection;
     private Departamento dep;
     
    public FuncionarioDAO( ) {
        this.connection =ConnectionFactory.criarconexao();
    }

  
    
      public boolean inserirFUNC(Funcionario f){
        try {
            
   String sql ="INSERT INTO funcionario(matricula,funome,fcpf,fendereco,fsexo,fcargo,fsalario,dep)VALUES (?,?,?,?,?,?,?,?)";
  
            PreparedStatement stm =connection.prepareStatement(sql);
            stm.setInt(1,f.getMatricula());
            stm.setString(2,f.getFunome());
            stm.setString(3,f.getFcpf());
            stm.setString(4,f.getFendereco());
            stm.setString(5,f.getFsexo());
            stm.setString(6,f.getFcargo());
            stm.setFloat(7,f.getFsalario());
            stm.setInt(8,f.getDep().getDcodigo());
            
            int executeUpdate = stm.executeUpdate();
            
            stm.close();
            if(executeUpdate > 0){
                return true;
            }
            return false;
            //SSystem.out.println("Inserido com sucesso");
            //connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
             throw new RuntimeException("Falha ao inserir Pessoas", ex);
        }
    }
      
      public List<Funcionario>showFUNC(){
      List<Funcionario>funcs=new ArrayList();
        try { 
            String sql= "select * from funcionario inner join departamento on dep=Dcodigo";
;
            PreparedStatement stm =connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Funcionario f =new Funcionario();
                f.setMatricula(rs.getInt("matricula"));
                f.setFunome(rs.getString("funome"));
                f.setCpf(rs.getString("fcpf"));
                f.setFendereco(rs.getString("fendereco"));
                f.setFsexo(rs.getString("fsexo"));
                f.setFcargo(rs.getString("fcargo"));
                f.setSalario(rs.getFloat("fsalario"));
                Departamento d =new Departamento();
                d.setDcodigo(rs.getInt("Dcodigo"));
                f.setDep(d);
               funcs.add(f);
            }
            stm.close();
            rs.close();
            return funcs;
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao lista Pessoas", ex);
        }
       
} 
      
    public boolean updatefunc(Funcionario f){
        try {
            
   String sql ="UPDATE funcionario SET funome = ?,fcpf = ?,fendereco = ?,fsexo = ?,fcargo = ?,fsalario = ?,dep = ? WHERE matricula = ?";
  
            PreparedStatement stm =connection.prepareStatement(sql);
          
            stm.setString(1,f.getFunome());
            stm.setString(2,f.getFcpf());
            stm.setString(3,f.getFendereco());
            stm.setString(4,f.getFsexo());
            stm.setString(5,f.getFcargo());
            stm.setFloat(6,f.getFsalario());
            stm.setInt(7,f.getDep().getDcodigo());
              stm.setInt(8,f.getMatricula());
            int executeUpdate = stm.executeUpdate();
            
            stm.close();
            if(executeUpdate > 0){
                return true;
            }
            return false;
            //SSystem.out.println("Inserido com sucesso");
            //connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
             throw new RuntimeException("Falha ao inserir Pessoas", ex);
        }
    }   
      
        public boolean removerFUN(int matricula){
       try {
            String sql ="delete from funcionario where matricula = ?";
            PreparedStatement stm =connection.prepareStatement(sql);
            stm.setInt(1,matricula);
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
      
      
      
      
}
