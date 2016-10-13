/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Ator;

/**
 *
 * @author Multbrax
 */
@Named
@RequestScoped
public class TelaMB implements Serializable{
    
    private String nome;
    private int idade;
    private double salario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public void salvar(){
        Ator ator = new Ator();
        ator.setNome(nome);
        ator.setIdade(idade);
        ator.setSalario(salario);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ator-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(ator);
        em.getTransaction().commit();
        em.close();
        emf.close();
        System.out.println("salvou");
    }
}
