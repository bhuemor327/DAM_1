package org.example.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.example.entity.entity.Cliente;

import java.util.List;


//UTILIZANDO WHERE

public class Ejemplo_JPQL_02 {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("ejemploJPA");
        EntityManager em=emf.createEntityManager();

        //Creamos la consulta donde createQuery devuelve una instancia Query. Utilizamos parámetros
        Query query = em.createQuery("select c from Cliente c where c.formaPago=?1", Cliente.class);
        query.setParameter(1, "Débito");
        List<Cliente> clientes = query.getResultList();

        //Si tuvieramos un sólo registro, podemos utilizar getSingleResult();

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
        em.close();

        /*
       // Si quisieramos solicitar la información del pago por consola

        Scanner s = new Scanner(System.in);

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("ejemploJPA");
        EntityManager em=emf.createEntityManager();

        //Creamos la consulta donde createQuery devuelve una instancia Query. Utilizamos parámetros
        Query query = em.createQuery("select c from Cliente c where c.formaPago=?1", Cliente.class);
        System.out.println("Ingrese la forma de pago");
        String pago = s.next();
        query.setParameter(1, pago);
        List<Cliente> clientes = query.getResultList();

        //Si tuvieramos un sólo registro, podemos utilizar getSingleResult();

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
        em.close();*/





    }
}
