/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrofuncionario.model.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raque
 */
public class Departamento {
        private int Dcodigo;
        private  String Dnome;
        private String Dlocal;
       
     // List<Departamento>deps;
        
        public Departamento(int codigo,String nome,String local){
           this.Dcodigo=codigo;
           this.Dnome=nome;
           this.Dlocal=local;
            //this.deps=new ArrayList<>();
        }

    public Departamento() {
     
    }

           

    public int getDcodigo() {
        return Dcodigo;
    }

    public String getDlocal() {
        return Dlocal;
    }

    public void setDlocal(String Dlocal) {
        this.Dlocal = Dlocal;
    }
    
    

    public void setDcodigo(int codigo) {
        this.Dcodigo = codigo;
    }

    public String getDnome() {
        return Dnome;
    }

    public void setDnome(String nome) {
        this.Dnome = nome;
    }

  

    @Override
    public String toString() {
        return "Departamento{" + "Dcodigo=" + Dcodigo + ", Dnome=" + Dnome + ", Dlocal=" + Dlocal + '}';
    }

   
   

}
