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
public class Trabalha {
  
    private Funcionario Fmatricula;
    private Projeto Prnumero;
     private int Horas;
    
    public Trabalha(Funcionario fmatricula,Projeto projeto, int horas) {
        this.Fmatricula = fmatricula;
        this.Prnumero = projeto;
        this.Horas = horas;
    }

    public Trabalha() {
        
    }

    public Funcionario getFmatricula() {
        return Fmatricula;
    }

    public void setFmatricula(Funcionario Fmatricula) {
        this.Fmatricula = Fmatricula;
    }

    public Projeto getPrnumero() {
        return Prnumero;
    }

    public void setPrnumero(Projeto Prnumero) {
        this.Prnumero = Prnumero;
    }
   
    public int getHoras() {
        return Horas;
    }

    public void setHoras(int Horas) {
        this.Horas = Horas;
    }

    @Override
    public String toString() {
        return "Trabalha{" + "Matricula = "+Fmatricula+ ", Número do Projeto="+ Prnumero+ ", Horas=" + Horas + '}';
    }

    
    
}
