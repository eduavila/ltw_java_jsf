/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.ltw.model;

/**
 *
 * @author aluno
 */
public class Aluno {
    
    private String nomeCompleto;
    private String cursoID;
    private String rga;
    private String telefone;
    private String email;
   
    public Aluno(){}
    
    public Aluno(String nomeCompleto, String cursoID, String rga, String telefone, String email) {
        this.nomeCompleto = nomeCompleto;
        this.cursoID = cursoID;
        this.rga = rga;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCursoID() {
        return cursoID;
    }

    public void setCursoID(String cursoID) {
        this.cursoID = cursoID;
    }

    public String getRga() {
        return rga;
    }

    public void setRga(String rga) {
        this.rga = rga;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
