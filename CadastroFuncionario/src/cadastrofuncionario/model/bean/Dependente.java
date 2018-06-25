/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrofuncionario.model.bean;

import java.util.Date;

/**
 *
 * @author raquel
 */
public class Dependente {
   String cpf;
   String nome_dependente;
   String sexo;
   Date data_nascimento;
   String parentesco;

    public Dependente(String cpf, String nome, String sexo, Date data_nascimento, String parentesco) {
        this.cpf = cpf;
        this.nome_dependente = nome;
        this.sexo = sexo;
        this.data_nascimento = data_nascimento;
        this.parentesco = parentesco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
    
    
    
    
    
}
