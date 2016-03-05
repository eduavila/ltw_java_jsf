/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.ltw.beans;

import br.ufmt.ic.lrw.utils.ConnDB;
import br.ufmt.ic.ltw.model.Aluno;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;

/**
 *
 * @author aluno
 */
@Named(value = "alunoBean")
@SessionScoped
public class AlunoBean implements Serializable {

    Aluno alunoSelecionado;
    Aluno novoAluno;
    String cursoSelecionado;

    public Aluno getAlunoSelecionado() {
        return alunoSelecionado;
    }

    public void setAlunoSelecionado(Aluno alunoSelecionado) {
        this.alunoSelecionado = alunoSelecionado;
    }

    public String getCursoSelecionado() {
        return cursoSelecionado;
    }

    public void setCursoSelecionado(String cursoSelecionado) {
        this.cursoSelecionado = cursoSelecionado;
    }
    
    /**
     * Creates a new instance of AlunoBean
     */
    public AlunoBean() {
       alunoSelecionado = new Aluno();
       cursoSelecionado="";
       novoAluno = new Aluno();
    }
    
    
    public List<Aluno> getListaAlunos(){
        
        List<Aluno> listaAlunos = new ArrayList<>();
        
        listaAlunos.add(new Aluno("Eduardo Malheiros","1","55555","656565","Lucas do Rio Verde"));
        listaAlunos.add(new Aluno("Netty Whatapp","1","55555","6565545","Lucas do Rio Verde"));
        
        return listaAlunos;
    }
    
    
    public List<SelectItem> getListaCursos(){
        
        try {
            Statement stm;
            
            Connection con = ConnDB.getConnection();
            
            if (con==null) {
                throw new SQLException("Não foi possível conectar!");
            }
            
            stm = con.createStatement();
           
            String sql = "SELECT * FROM curso ORDER BY nome ASC";
            ResultSet rs = stm.executeQuery(sql);
            
            List listaCursos = new ArrayList<SelectItem>();
        
            while (rs.next()) {
                SelectItem st = new SelectItem(
                    rs.getString("curso_id"),
                    rs.getString("nome"));
                listaCursos.add(st);
            }

            
           return listaCursos;
           
           
        } catch (SQLException ex) {
            System.out.println("Erro conectando no banco: "+ex.getMessage());
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    public String editarAluno(Aluno aluno){
        this.alunoSelecionado = aluno;
        
        return "editar-aluno";
    }
  
}
