package org.example.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.entity.Cliente;

import javax.swing.*;
import java.util.Scanner;

//MODIFICACIÓN DE UN OBJETO EXISTENTE
public class Ejemplo_03_Actualizar {

    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("ejemploJPA");
        EntityManager em=emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);

        try{
            /*/Los pasos a seguir serán:
                - Solicitamos Id
                - Buscamos el objeto con dicho id
                - Actualizamos
             */
            System.out.println("Ingrese el ID del cliente a modificar:");
            Long id = Long.parseLong(scanner.nextLine());

            //Buscamos el objeto con el id proporcionado
            Cliente c = em.find(Cliente.class, id);

            //Modificamos
            System.out.println("Ingrese el nuevo nombre:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el nuevo apellido:");
            String apellido = scanner.nextLine();

            System.out.println("Ingrese la nueva forma de pago:");
            String pago = scanner.nextLine();

            em.getTransaction().begin();

            // Actualizamos el cliente con los nuevos datos
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setFormaPago(pago);

            em.getTransaction().commit();

        }catch (Exception e){
            em.getTransaction().rollback();
        }
        em.close();

    }
}
