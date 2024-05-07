package org.example.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.example.entity.entity.Cliente;
import org.hibernate.internal.build.AllowSysOut;

import java.util.List;

public class Ejemplo_JPQL_03 {
    public static void main(String[] args) {

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("ejemploJPA");
        EntityManager em=emf.createEntityManager();

        // Los parámetros se indican utilizando nombres precedidos por dos puntos (:)
        // O bien con número, precedidos de una interrogación (?)

        //1. Buscamos un registro por id y mostramos sólo el nombre del mismo
        System.out.println("--- 1. Consulta del nombre buscado por id---");

        String nombreCliente = em.createQuery("select c.nombre from Cliente c where c.id=:idCliente",String.class).setParameter("idCliente", 1L).getSingleResult();
        System.out.println(nombreCliente);
        

        //2. Buscamos un registro por id y mostramos varios campos
        System.out.println("\n--- 2. Consulta del nombre y apellido buscado por id---");

            // En este caso, se especifica el tipo de resultado esperado como un array de objetos (Object[]), ya que la consulta retorna múltiples columnas.
        Object[] objetoCliente = em.createQuery("select c.id, c.nombre, c.apellido from Cliente c where c.id=:idCliente",Object[].class).setParameter("idCliente", 1L).getSingleResult();

        Long id = (Long) objetoCliente[0];
        String nombre = (String) objetoCliente[1];
        String apellido = (String) objetoCliente[2];
        System.out.println("id:"+ id + ",nombre:" + nombre + " ,apellido:"+ apellido);


        //3. Buscamos un registro por id y mostramos varios campos
        System.out.println("\n---3. Consulta del nombre, apellido e id de todos los registros---");
        // En este caso, esperamos que los resultados sean un array de objetos. Cada elemento de la lista será un array de objetos donde cada elemento del array corresponderá a una columna seleccionada.
        List<Object[]> listaClientes = em.createQuery("select c.id, c.nombre, c.apellido from Cliente c",Object[].class).getResultList();

        for (Object[] lista : listaClientes) {
             id = (Long) lista[0];
             nombre = (String) lista[1];
             apellido = (String) lista[2];
             System.out.println("id:"+ id + ",nombre:" + nombre + " ,apellido:"+ apellido);
        }


        //4. Consulta de todos los nombres de clientes
        System.out.println("\n--- 4. Consulta de nombres únicos de todos los clientes---");
        List<String> nombres = em.createQuery("select distinct (c.nombre) from Cliente c",String.class).getResultList();

        for (String nombresClientes : nombres) {
            System.out.println(nombresClientes);
        }

        //5. Consulta de todos los nombres de clientes
        System.out.println("\n--- 5. Consulta de nombres únicos de todos los clientes junto con las veces que se repite cada uno---");
        List<Object[]> nombresunicos = em.createQuery("select  c.nombre, count(c) from Cliente c group by c.nombre",Object[].class).getResultList();

        for (Object[] nombresClientes : nombresunicos) {
            String nombres_unicos = (String) nombresClientes[0];
            Long repeticiones = (Long) nombresClientes[1];

            System.out.println("Nombre: " + nombres_unicos + " Cantidad de repeticiones: " + repeticiones);
        }


        em.close();


    }
}
