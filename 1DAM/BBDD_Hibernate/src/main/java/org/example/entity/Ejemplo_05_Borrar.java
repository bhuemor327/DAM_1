package org.example.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.entity.Cliente;

import java.util.Scanner;

public class Ejemplo_05_Borrar {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("ejemploJPA");
        EntityManager em=emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Ingrese el ID del cliente a borrar:");
            Long id = Long.parseLong(scanner.nextLine());

            //Buscamos el objeto con el id proporcionado
            Cliente c = em.find(Cliente.class, id);

            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();

        }catch (Exception e){
            em.getTransaction().rollback();
        }
        em.close();
    }
}
