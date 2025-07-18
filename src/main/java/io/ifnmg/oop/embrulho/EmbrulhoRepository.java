/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.ifnmg.oop.embrulho;
import io.ifnmg.oop.repository.Repository;
        
/**
 *
 * @author Matheus Antunes <maf6@aluno.ifnmg.edu.br>
 */
public class EmbrulhoRepository 
        extends Repository<Embrulho>{

    @Override
    public String getJpqlFindAll() {
        return "SELECT a FROM Embrulho a";
    }

    @Override
    public String getJpqlFindById() {
        return "SELECT a FROM Embrulho a WHERE a.id = :id";
    }

    @Override
    public String getJpqlDeleteById() {
        return "DELETE FROM Embrulho a WHERE a.id = :id";
    }

}
