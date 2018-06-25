package cadastrofuncionario.model.dao;

import cadastrofuncionario.connection.ConnectionFactory;
import cadastrofuncionario.model.bean.Funcionario;
import cadastrofuncionario.model.bean.Projeto;
import cadastrofuncionario.model.bean.Trabalha;
import cadastrofuncionario.view.teste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

 class TrabalhaDAO {
    public TrabalhaDAO trab;
    private  Connection connection;
    
    TrabalhaDAO(){
          this.connection=ConnectionFactory.criarconexao();
    }
   
     
        public  boolean inserirTRA(Trabalha t){
        try {
            String sql ="INSERT INTO trabalha(Fmatricula,Prnumero,Horas)VALUES (?, ?,?)";
            PreparedStatement stm =connection.prepareStatement(sql);
            stm.setInt(1,t.getFmatricula().getMatricula());
            stm.setInt(2,t.getPrnumero().getProjnumero());
            stm.setInt(3,t.getHoras());
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

   
    
    
    
    
    
}
