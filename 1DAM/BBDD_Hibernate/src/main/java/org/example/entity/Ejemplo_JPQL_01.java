package org.example.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.entity.Cliente;

import java.util.List;

public class Ejemplo_JPQL_01 {
    public static void main(String[] args) {
        /*/
         1. Creamos una instancia de EntityManagerFactory utilizando la configuración definida en el archivo
         persistence.xml. El parámetro "ejemploJPA" es el nombre de la unidad de persistencia que se utiliza
         para identificar la configuración de la base de datos y otras propiedades de persistencia.
         */
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("ejemploJPA");
        //Creamos una instancia de EntityManager.Esta nos proporciona métodos para realizar operaciones
        // de lectura, escritura, actualización y eliminación en las entidades persistentes.
        EntityManager em=emf.createEntityManager();

        /*/
        2. Realizamos una consulta a la base de datos utilizando JPQL  a través del método createQuery() de EntityManager.
        Se especifica con CLiente.class que queremos que devuelva objetos de la clase Cliente
        Utilizamos el método getResultList para obtener los resultados en forma de lista de objetos Cliente
         */
        List<Cliente> clientes =  em.createQuery("select c from Cliente c", Cliente.class).getResultList();
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
        em.close();


    }
}
