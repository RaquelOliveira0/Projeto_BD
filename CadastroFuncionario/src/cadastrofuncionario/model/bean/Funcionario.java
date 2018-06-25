/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrofuncionario.model.bean;

import java.util.Date;


/**
 *
 * @author raque
 */
public class Funcionario {

   
    private int matricula;
    private String funome;
    private String fcpf;
    private String fendereco;
    private String fsexo;
    private String fcargo;
    private float fsalario;
    private Departamento dep;

    public Funcionario(int matricula, String funome, String fcpf, String fendereco, String fsexo, String fcargo, float fsalario,Departamento dep) {

        this.matricula = matricula;  this.matricula = matricula;
        this.funome = funome;
        this.fcpf = fcpf;
        this.fendereco = fendereco;
        this.fsexo = fsexo;
        this.fcargo = fcargo;
        this.fsalario = fsalario;
        this.dep=dep;
       




    }

    public Departamento getDep() {
        return dep;
    }

    public void setDep(Departamento dep) {
        this.dep = dep;
    }
  
    public String getSexo() {
        return fsexo;
    }

    public String getFcpf() {
        return fcpf;
    }

    
     

    public void setFcpf(String fcpf) {
        this.fcpf = fcpf;
    }

    public String getFendereco() {
        return fendereco;
    }

    public void setFendereco(String fendereco) {
        this.fendereco = fendereco;
    }

    public String getFsexo() {
        return fsexo;
    }

    public void setFsexo(String fsexo) {
        this.fsexo = fsexo;
    }

    public String getFcargo() {
        return fcargo;
    }

    public void setFcargo(String fcargo) {
        this.fcargo = fcargo;
    }

    public float getFsalario() {
        return fsalario;
    }

    public void setFsalario(float fsalario) {
        this.fsalario = fsalario;
    }

   

    public void setSexo(String sexo) {
        this.fsexo = sexo;
    }
   
    
    public Funcionario(){
        
    }
   
   
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getFunome() {
        return funome;
    }

    public void setFunome(String funome) {
        this.funome = funome;
    }

   

    public String getCpf() {
        return fcpf;
    }

    public void setCpf(String cpf) {
        this.fcpf = cpf;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "matricula=" + matricula + ", funome=" + funome + ", fcpf=" + fcpf + ", fendereco=" + fendereco + ", fsexo=" + fsexo + ", fcargo=" + fcargo + ", fsalario=" + fsalario + ", dep=" + dep.getDcodigo()+"}";
    }

   

    public float getSalario() {
        return fsalario;
    }

    public void setSalario(float salario) {
        this.fsalario = salario;
    }

  
    
    
}
