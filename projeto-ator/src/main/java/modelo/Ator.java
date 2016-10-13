/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * 
 * @author Multbrax
 */
//modelo de classe
@Entity
@Table (name = "tb_ator")
@NamedQueries({
    @NamedQuery(name = "Ator.buscaTodos", query = "select a from Ator a"),
    @NamedQuery(name = "Ator.buscaPorId", query = "select a from Ator a where id = :id")
})
public class Ator {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "ATOR_NOME", length = 100, nullable = false)
    private String nome;
    @Column(name = "ATOR_IDADE", nullable = false)
    private int idade;
    @Column(name = "ATOR_SALARIO", nullable = false, precision = 4)
    private double salario;

    public Ator() {
    }

    public Ator(String nome, int idade, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Ator{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + ", salario=" + salario + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ator other = (Ator) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
}
