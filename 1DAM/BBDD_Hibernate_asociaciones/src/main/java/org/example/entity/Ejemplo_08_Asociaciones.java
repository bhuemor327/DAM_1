package org.example.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.entity.Cliente;
import org.example.entity.entity.Factura;
import org.example.entity.entity.Direccion;

//CREAR UNA NUEVA DIRECCIÓN ASOCIADA A UN CLIENTE

public class Ejemplo_08_Asociaciones {

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
            Cliente cliente = new Cliente("Antonio","Prados","Crédito");

            Direccion direccion1 = new Direccion("Fleming", 12);
            Direccion direccion2 = new Direccion("Sagasta", 10);

            cliente.getDirecciones().add(direccion1);
            cliente.getDirecciones().add(direccion2);

            //Persistimos solo cliente, ya que al haber establecido la relación con el valor casacdeType.ALL, al persistir el cliente, también lo harán las direcciones
            em.persist(cliente);

            em.getTransaction().commit();

        }catch(Exception e){
            em.getTransaction().rollback();
        }   em.close();



    }
}
