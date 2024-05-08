package org.example.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.entity.Cliente;
import org.example.entity.entity.Factura;

//CREAR UNA NUEVA FACTURA ASOCIADA A UN CLIENTE EXISTENTE, UTILIZANDO FIND

public class Ejemplo_07_Asociaciones {

    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("ejemploJPA");
        EntityManager em=emf.createEntityManager();

        if (em.isOpen())
        {System.out.println("EntityManager con conexión abierta.");}
        else
        {System.out.println("EntityManager sin conexión.");}

        try{
            //1º Iniciamos la transacción
            em.getTransaction().begin();
            Cliente c = em.find(Cliente.class, 1L);

            Factura f = new Factura("compras varias", 100L, c);
            em.persist(f);
            em.getTransaction().commit();

        }catch(Exception e){
            em.getTransaction().rollback();
        }   em.close();



    }
}
