package luca.campion.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import luca.campion.entities.Eventi;

public class EventiDAO {
    private final EntityManager entityManager;

    public EventiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // parte dell'esercizio
    public void save(Eventi newEventi){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newEventi);
        transaction.commit();
        System.out.println("L'evento " + newEventi.getTitolo() + " è stato inviato al db");
    }


    public Eventi findBy(long id){
        Eventi found = entityManager.find(Eventi.class, id);
        if(found == null) throw new IllegalArgumentException(); // exception sbagliata, si dovrebbe creare custom
        return found;
    }



    public void finByIdAndDelete(long id){
        Eventi found = this.findBy(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println("L'evento " + found.getTitolo() + " è stato eliminato");
    }


}
