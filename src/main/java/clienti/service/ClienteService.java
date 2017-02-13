/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.service;

import clienti.entity.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */

//enterpriva javabean
@Stateless
@Named("clienteSrv")
public class ClienteService {
    
    // mi dà connessione al db quando ne ho bisogno
    //tutto in automatico, quindi non devo fare le solite 2 righe
    @PersistenceContext
    EntityManager em;
    
    public List<Cliente> findAll(){
        return em.createNamedQuery("Cliente.all")
                .getResultList();
    }
    
    public  Cliente save(Cliente tosave){
        //non devo fare .getTransaction().begin() && .commit()
        return em.merge(tosave); // per modificare/aggiornare il cli
    }
    
    public void delete(Long id){
        Cliente finded = em.find(Cliente.class, id);
        delete(finded);
    }
    
    public void delete(Cliente toremove){
         em.remove(toremove);
    }
}
