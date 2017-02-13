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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name="dettaglioOrdine")
public class DettaglioOrdine implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detOrd;
    
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Ordine ordine;
    
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Prodotto prodotto;
    
    private int quantita;

    public DettaglioOrdine() {
    }    

    public DettaglioOrdine(Ordine ordine, Prodotto prodotto, int quantita) {
        this.ordine = ordine;
        this.prodotto = prodotto;
        this.quantita = quantita;
    }   

    public Long getId_detOrd() {
        return id_detOrd;
    }

    public void setId_detOrd(Long id_detOrd) {
        this.id_detOrd = id_detOrd;
    }
    
    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id_detOrd);
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
        final DettaglioOrdine other = (DettaglioOrdine) obj;
        if (!Objects.equals(this.id_detOrd, other.id_detOrd)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DettaglioOrdine{" + "id_detOrd=" + id_detOrd + ", ordine=" + ordine.getNumero() + ", prodotto=" + prodotto.getNomeProdotto() + ", quantita=" + quantita + '}';
    }

    
    
    
}
