package org.example.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.entity.Cliente;

import java.util.Scanner;

//MODIFICACIÓN DE UN OBJETO EXISTENTE CUANDO HA SIDO DESLIGADO
public class Ejemplo_04_Actualizar {

    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("ejemploJPA");
        EntityManager em=emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);

        try{

            System.out.println("Ingrese el ID del cliente a modificar:");
            Long id = Long.parseLong(scanner.nextLine());


            //Creamos una nueva instancia de cliente con ese ID
            Cliente clienteNoGestionado = new Cliente();
            clienteNoGestionado.setId(id);

            em.getTransaction().begin();
            // Actualizamos el cliente con los nuevos datos
            clienteNoGestionado.setNombre("Teresa");
            clienteNoGestionado.setApellido("Mora");
            clienteNoGestionado.setFormaPago("Crédito");

            //Fusionamos la instancia de la entidad
            Cliente clienteActualizado = em.merge(clienteNoGestionado);

            em.getTransaction().commit();
            System.out.println(clienteActualizado);

        }catch (Exception e){
            em.getTransaction().rollback();
        }
        em.close();

    }
}
