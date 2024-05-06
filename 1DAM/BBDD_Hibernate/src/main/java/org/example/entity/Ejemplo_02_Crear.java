package org.example.entity;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.entity.Cliente;

public class Ejemplo_02_Crear {
    public static void main(String[] args) {

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("ejemploJPA");
        EntityManager em=emf.createEntityManager();

        //1º Iniciamos la transacción
        em.getTransaction().begin();

        try {

            //2º Creamos el nuevo objeto que queremos persistir
            Cliente c = new Cliente("María","García","Débito");


            //3º Persistimos la entidad usando el método persist.
            em.persist(c);

            //4º Concluimos la transacción, lo que hará el insert en la BBDD
            em.getTransaction().commit();

            //5º Buscamos y mostramos ese objeto por su id
            System.out.println("El id del cliente registrado es " + c.getId());
            c=em.find(Cliente.class, c.getId());
            System.out.println(c);
            if (c!=null) em.detach(c);

        } catch (EntityExistsException ex){
            System.out.println("El producto ya existe.");
            em.getTransaction().rollback();
        }
        /*/
        Dicha excepción se producirá solamente cuando ya exista una instancia de entidad con el mismo identificador.
         */
        em.close();


    }
}
