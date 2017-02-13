/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author tss
 */

@NamedQueries({
    @NamedQuery(name = "Cliente.all", query = "select c from Cliente c order by c.id_cliente"),
    @NamedQuery(name = "Cliente.findByName", query = "select c from Cliente c where c.ragioneSociale= :ragsoc")
})
@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
    
    @Column(unique=true) //per mettere il campo unique
    private String ragioneSociale;
    private String indirizzo;

    public Cliente() {
    }     

    public Cliente(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;     
    }        

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.id_cliente);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id_cliente, other.id_cliente)) {
            return false;
        }
        return true;
    }    

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", ragioneSociale=" + ragioneSociale + ", indirizzo=" + indirizzo + '}';
    }
    
    
    
}
