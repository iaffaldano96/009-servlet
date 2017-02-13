/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name="prodotto")
public class Prodotto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id_prod;
    
    private String nomeProdotto;
    private double prezzoUni;

    public Prodotto() {
    }

    public void setId_prod(Long id_prod) {
        this.id_prod = id_prod;
    }

    public Long getId_prod() {
        return id_prod;
    }

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    public double getPrezzoUni() {
        return prezzoUni;
    }

    public void setPrezzoUni(double prezzoUni) {
        this.prezzoUni = prezzoUni;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id_prod);
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
        final Prodotto other = (Prodotto) obj;
        if (!Objects.equals(this.id_prod, other.id_prod)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prodotto{" + "id_prod=" + id_prod + ", nomeProdotto=" + nomeProdotto + ", prezzoUni=" + prezzoUni + '}';
    }
    
    
    
}
