/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrofuncionario.model.bean;

/**
 *
 * @author raquel
 */
public class Projeto {
  private String Projnome;
  private  int Projnumero;
  private String Projlocal;
  private Departamento Dep; 

  
    public Projeto(String nome, int codigoProjeto,String local, Departamento dep) {
        this.Projnome = nome;  
        this.Projnumero = codigoProjeto;
        this.Projlocal=local;
        this.Dep = dep;
    }

    public Projeto() {
        
    }
  
  

    public String getProjnome() {
        return Projnome;
    }

    public void setProjnome(String Projnome) {
        this.Projnome = Projnome;
    }
    

    public int getProjnumero() {
        return Projnumero;
    }

    public void setProjnumero(int Projnumero) {
        this.Projnumero = Projnumero;
    }

    public String getProjlocal() {
        return Projlocal;
    }

    public void setProjlocal(String Projlocal) {
        this.Projlocal = Projlocal;
    }

   
    public Departamento getDep() {
        return Dep;
    }

    public void setDep(Departamento dep) {
        this.Dep = dep;
    }

    @Override
    public String toString() {
   return "Projnome=" + Projnome + ", Projnumero=" + Projnumero + ", Projlocal=" + Projlocal + ", Dep=" + Dep.getDcodigo();
    }

   
  
  
  
  
  
  
  
  
  
  
  
    
    
}
