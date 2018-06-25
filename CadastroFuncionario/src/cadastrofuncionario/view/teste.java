/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrofuncionario.view;

import cadastrofuncionario.connection.ConnectionFactory;
import cadastrofuncionario.model.bean.Departamento;
import cadastrofuncionario.model.bean.Funcionario;
import cadastrofuncionario.model.bean.Projeto;
import cadastrofuncionario.model.bean.Trabalha;
import cadastrofuncionario.model.dao.DepartamentoDAO;
import cadastrofuncionario.model.dao.FuncionarioDAO;
import cadastrofuncionario.model.dao.ProjetoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class teste {

    public static void main(String args[]) {
        Departamento departamento = new Departamento();
        DepartamentoDAO dao = new DepartamentoDAO();
        TrabalhaDAO trab = new TrabalhaDAO();
        teste t = new teste();

        ConnectionFactory con = new ConnectionFactory();
        System.out.println("Conectado");
        int numero = 0;
        String nome = null, local = null;
        boolean terminar = false;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("1 -CADASTRAR DEPARTAMENTO");
            System.out.println("2 -LISTAR DEPARTAMENTO");
            System.out.println("3 -EXCLUIR DEPARTAMENTO");
            System.out.println("4 -EDITAR DEPARTAMENTO");
            System.out.println("5 -CADASTRAR FUNCIONARIO");
            System.out.println("6 -LISTAR FUNCIONARIO");
            System.out.println("7 -EDITAR FUNCIONARIO");
            System.out.println("8 -DELETE FUNCIONARIO");
            System.out.println("9 -CADASTRAR PROJETO");
            System.out.println("10 - LISTAR PROJETO");
            System.out.println("11 - REMOVER PROJETO");
            System.out.println("12 -EDITAR PROJETO");
            System.out.println("13 - CADASTRAR TRABALHADOR");
            int opcao = in.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o codigo");
                    numero = in.nextInt();
                    System.out.println("Digite o nome");
                    nome = in.next();
                    System.out.println("Digite o local");
                    local = in.next();
                    Departamento d = new Departamento(numero, nome, local);
                    DepartamentoDAO dep = new DepartamentoDAO();
                   // dep.inserir(d);
                     if (dao.inserir(d)) {
                        System.out.println("Departamento cadastrado com sucesso");
                    } else {
                        System.out.println("Erro ao cadastrar");
                    }
                    break;
                case 2:
                    List<Departamento> deps = dao.showdep();
                    for (Departamento deplis : deps) {
                        System.out.println(deplis.toString());
                    }
                    break;
                case 3:
                    System.out.println("Digite o codigo do departamento a ser excluído");
                    int cod = in.nextInt();
                    //dao.remover(cod);
                    if (dao.remover(cod)) {
                        System.out.println("Departamento excluido com sucesso");
                    } else {
                        System.out.println("Departamento inexistente");
                    }
                    break;
                case 4:
                    int idCodigo;
                    String enome,
                     elocal;
                    System.out.println("Digite o nome do departamento: ");
                    enome = in.next();
                    System.out.println("Digite o local que deseja atualizar: ");
                    elocal = in.next();
                    System.out.println("Digite o codigo do departamento a ser editado: ");
                    idCodigo = in.nextInt();
                    Departamento ed = new Departamento(idCodigo, enome, elocal);
                    //dao.editar(ed);
                    if (dao.editar(ed)) {
                        System.out.println("Departamento editado com sucesso");
                    } else {
                        System.out.println("Departamento inexistente");
                    }
                    break;
                case 5:
                    FuncionarioDAO fdao = new FuncionarioDAO();
                    Departamento dfk = new Departamento();
                    int matricula;
                    int codigo;
                    String funome,
                     fcpf,
                     fendereco,
                     fsexo,
                     fcargo;
                    float fsalario;
                    System.out.println("Digite a matricula: ");
                    matricula = in.nextInt();
                    System.out.println("Digite o nome: ");
                    funome = in.next();
                    System.out.println("Digite o cpf: ");
                    fcpf = in.next();
                    System.out.println("Digite o endereço: ");
                    fendereco = in.next();
                    System.out.println("Digite o sexo: ");
                    fsexo = in.next();
                    System.out.println("Digite o cargo: ");
                    fcargo = in.next();
                    System.out.println("Digite o salario: ");
                    fsalario = in.nextFloat();
                    System.out.println("Digite o codigo do departamento: ");
                    codigo = in.nextInt();
                    dfk.setDcodigo(codigo);
                    Funcionario fun = new Funcionario(matricula, funome, fcpf, fendereco, fsexo, fcargo, fsalario, dfk);
                    // fdao.inserirFUNC(f,defun);
                    if (fdao.inserirFUNC(fun)) {
                        System.out.println("Sucesso");
                    } else {
                        System.out.println("ERRO");
                    }
                    break;
                case 6:
                    listarfun();
                    break;
                case 7:
                    atualizarfun();
                    break;
                case 8:
                    removerFUN();
                    break;

                case 9:
                    int numdep;
                    ProjetoDAO projeto = new ProjetoDAO();
                    System.out.println("Digite o nome do projeto");
                    nome = in.next();
                    System.out.println("Digite o numero do projeto");
                    numero = in.nextInt();
                    System.out.println("Digite o local do projeto");
                    local = in.next();
                    System.out.println("Digite o numero do departamento do projeto");
                    numdep = in.nextInt();
                    Departamento num = new Departamento();
                    num.setDcodigo(numdep);
                    Projeto jproj = new Projeto(nome, numero, local, num);
                    if (projeto.inserirPROJ(jproj)) {
                        System.out.println("Sucesso");
                    } else {
                        System.out.println("Erro");
                    }
                    break;
                case 10:
                    listarProj();                 
                    break;
                case 11:
                    removerPROJ();
                    break;
                case 12:
                    editarPROJ();
                    break;
                case 13:
                    cadastrarTra();
                    break;
                case 14:
                    listarTRA();
                    break;
            }

        } while (!terminar);

    }

    public static void listarfun() {
        FuncionarioDAO dao = new FuncionarioDAO();

        for (Funcionario f : dao.showFUNC()) {
            System.out.println(f.toString());
        }

    }

    public static void atualizarfun() {
        Scanner in = new Scanner(System.in);
        Departamento dfk = new Departamento();
        FuncionarioDAO dao = new FuncionarioDAO();
        int matricula;
        int codigo;
        String funome, fcpf, fendereco, fsexo, fcargo;
        float fsalario;
        System.out.println("Digite o nome: ");
        funome = in.next();
        System.out.println("Digite o cpf: ");
        fcpf = in.next();
        System.out.println("Digite o endereço: ");
        fendereco = in.next();
        System.out.println("Digite o sexo: ");
        fsexo = in.next();
        System.out.println("Digite o cargo: ");
        fcargo = in.next();
        System.out.println("Digite o salario: ");
        fsalario = in.nextFloat();
        System.out.println("Digite o codigo: ");
        codigo = in.nextInt();
        System.out.println("Digite a matricula do funcionario a ser editado: ");
        matricula = in.nextInt();
        dfk.setDcodigo(codigo);
        Funcionario fun = new Funcionario(matricula, funome, fcpf, fendereco, fsexo, fcargo, fsalario, dfk);
        if ((dao.updatefunc(fun))) {
            System.out.println("Sucesso");
        } else {
            System.out.println("ERRO");
        }
    }

    public static void removerFUN() {
        Scanner in = new Scanner(System.in);
        Departamento dfk = new Departamento();
        FuncionarioDAO dao = new FuncionarioDAO();

        System.out.println("Digite a matricula do funcionario a ser excluído");
        int cod = in.nextInt();
        //dao.removerFUN(cod);
        if (dao.removerFUN(cod)) {
            System.out.println("Funcionario excluido com sucesso");
        } else {
            System.out.println("Funcionario inexistente");
        }
    }

    public static void cadastrarTra() {
        Scanner in = new Scanner(System.in);

        int fmatricula, projnumero, horas;
        System.out.println("Digite a matricula do funcionario ");
        fmatricula = in.nextInt();
        System.out.println("Digite o  numero  do projeto ");
        projnumero = in.nextInt();
        System.out.println("Digite as horas  que o funcionario trabalho");
        horas = in.nextInt();

        Funcionario f = new Funcionario();
        f.setMatricula(fmatricula);
        Projeto j = new Projeto();
        j.setProjnumero(projnumero);
        TrabalhaDAO tra = new TrabalhaDAO();
        Trabalha t = new Trabalha(f, j, horas);
        if (tra.inserirTRA(t)) {
            System.out.println("Trabalhdor Cadastrado com Sucesso");
        } else {
            System.out.println("Erro");
        }
    }
 public static void listarProj() {
        ProjetoDAO dao = new ProjetoDAO();

        for (Projeto j : dao.showPROJ()) {
            System.out.println(j.toString());
        }

    }
  public static void removerPROJ() {
        Scanner in = new Scanner(System.in);
       // Departamento dfk = new Departamento();
        ProjetoDAO dao = new ProjetoDAO();
        System.out.println("Digite o numero do projeto  a ser excluido");
        int cod = in.nextInt();
        //dao.removerPROJ(cod);
        if (dao.removerPROJ(cod)) {
            System.out.println("Projeto excluido com sucesso");
        } else {
            System.out.println("Projeto inexistente ou já excluido");
        }
    }
  public static void editarPROJ(){
        int idCodigo,depcodigo;
                    String enome,
                     elocal;
                     Scanner in = new Scanner(System.in);
                   
                    System.out.println("Digite o nome do projeto: ");
                    enome = in.nextLine();
                    System.out.println("Digite o local : ");
                    elocal=in.nextLine();
                    System.out.println("Digite o codigo do departamento : ");
                    depcodigo=in.nextInt();
                    System.out.println("Digite o código do projeto a ser editado: ");
                    idCodigo = in.nextInt();
                     ProjetoDAO dao = new ProjetoDAO();
                    //dao.editar(ed);
                     Departamento dfk = new Departamento();
                     dfk.setDcodigo(depcodigo);
                     Projeto j =new Projeto(enome, idCodigo, elocal, dfk);
                    if (dao.editarPROJ(j)) {
                        System.out.println(" Editado com sucesso");
                    } else {
                        System.out.println("Erro ao Editar");
                    }   
      
  }
  public static void listarTRA() {
        TrabalhaDAO dao = new TrabalhaDAO();

        for (Trabalha j : dao.showTRAB()) {
      System.out.println(j.toString());

        }

    }
    private static class TrabalhaDAO {

        private Connection connection;

        TrabalhaDAO() {
            this.connection = ConnectionFactory.criarconexao();
        }

        public boolean inserirTRA(Trabalha t) {
            try {
                String sql = "INSERT INTO trabalha(Fmatricula,Prnumero,Horas)VALUES (?, ?,?)";
                PreparedStatement stm = connection.prepareStatement(sql);
                stm.setInt(1, t.getFmatricula().getMatricula());
                stm.setInt(2, t.getPrnumero().getProjnumero());
                stm.setInt(3, t.getHoras());
                int executeUpdate = stm.executeUpdate();
                stm.close();
                if (executeUpdate > 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Falha ao inserir Pessoas", ex);
            }
        }
        
        
         public List<Trabalha>showTRAB(){
      List<Trabalha>trab=new ArrayList();
        try { 
         String sql= "SELECT * FROM  trabalha ";
            PreparedStatement stm =connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Trabalha t =new Trabalha();
                Funcionario f=new Funcionario();
                f.setMatricula(rs.getInt("Fmatricula"));
                Projeto p=new Projeto();
                p.setProjnumero(rs.getInt("Prnumero"));
                t.setHoras(rs.getInt("Horas"));
               trab.add(t);
            }
            stm.close();
            rs.close();
            return trab;
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Pessoas", ex);
        }
       
    }

}
}