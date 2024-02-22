package Tema6.Ejemplos;

	import java.util.LinkedList;
	import java.util.List;

	public class Ejemplo1 {
	    public static void main(String[] args) {

	        LinkedList<Alumno> dam = new LinkedList<>();
	        //métodos interface Collection
	        dam.add(new Alumno("Pep", "222A", 25)); //Pep
	        dam.add(new Alumno("Tom", "111A", 20)); //Pep, Tom
	        dam.add(new Alumno("Jon", "444A", 21));
	        dam.add(new Alumno("Tim", "333A", 19));
	        dam.add(new Alumno("Ada", "555A", 18));
	        dam.add(new Alumno("Sam", "666A", 18)); //Pep, Tom, Jon, Tim, Ada, Sam
	        

	        //métodos interface List. En estos métodos pasamos un índice y un elemento
	        dam.set(2,new Alumno("Ana", "777A",20)); //Sustituye Jon por Ana: Pep, Tom, Ana, Tim, Ada, Sam
	        dam.add(2,new Alumno("Bil", "777A",20)); //Añade y desplaza: Pep, Tom, Bil, Ana, Tim, Ada, Sam

	        //métodos interfaces Deque
	        dam.pollFirst(); //Elimina  el primer elemento de la lista o null si está vacía
	        dam.pollLast(); //Elimina el último elemento de la lista o null si está vacía
	        dam.offerFirst(new Alumno("Jud", "888A", 24)); //Inserta al principio de la lista
	        dam.offerLast(new Alumno("Kim", "999A", 28)); //Inserta al final de la lista

	        System.out.println(dam.removeFirst());  //Elimina el primer y devuelve el primer elemento
	        System.out.println(dam.removeLast()); //Elimina el último y lo devuelve

	        System.out.println(dam);
	        
	    }

	}

