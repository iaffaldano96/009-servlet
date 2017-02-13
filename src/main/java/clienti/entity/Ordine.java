/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author tss
 */

@Entity
@Table(name="ordine")
public class Ordine implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_ordine;
    
    @Column(nullable=false) //lo mette not null
    private String numero;
    
    private String descrizione;
    private boolean evaso;
    
    @Temporal(TemporalType.DATE) 
    private Date datail;
    
    @ManyToOne(optional = false,cascade = {CascadeType.PERSIST, CascadeType.MERGE}) //creo cliente se non esiste, se no lo aggiorna
    @JoinColumn(nullable=false)//join perché in relazione
    private Cliente cliente;

    @OneToMany(mappedBy = "ordine",cascade = {CascadeType.PERSIST, CascadeType.MERGE},
                                              orphanRemoval = true) //ordine sta in dettaglioOrdine,a cui si riferisce
                                              //se rimuovo l'ordine, rimuove i dettagli
    private List<DettaglioOrdine> dettagli=new ArrayList<>();                                          
    
    public Ordine() {
        this.datail=new Date();
    }
    
    

    public Long getId_ordine() {
        return id_ordine;
    }

    public void setId_ordine(Long id_ordine) {
        this.id_ordine = id_ordine;
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public boolean isEvaso() {
        return evaso;
    }

    public void setEvaso(boolean evaso) {
        this.evaso = evaso;
    }

    public Date getDatail() {
        return datail;
    }

    public void setDatail(Date datail) {
        this.datail = datail;
    }
    
    public void addDettaglio(DettaglioOrdine dett){
        dett.setOrdine(this);
        dettagli.add(dett);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Ordine{" + "id_ordine=" + id_ordine + ", numero=" + numero + ", descrizione=" + descrizione + ", evaso=" + evaso + ", data=" + datail + ", cliente=" + cliente.getRagioneSociale() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id_ordine);
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
        final Ordine other = (Ordine) obj;
        if (!Objects.equals(this.id_ordine, other.id_ordine)) {
            return false;
        }
        return true;
    }
   
}
