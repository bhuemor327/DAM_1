package Ejemplos_colecciones;

	import java.util.LinkedList;
	import java.util.List;

	public class Ejemplo1 {
	    public static void main(String[] args) {

	        LinkedList<Alumno> dam = new LinkedList<>();
	        //m�todos interface Collection
	        dam.add(new Alumno("Pep", "222A", 25)); //Pep
	        dam.add(new Alumno("Tom", "111A", 20)); //Pep, Tom
	        dam.add(new Alumno("Jon", "444A", 21));
	        dam.add(new Alumno("Tim", "333A", 19));
	        dam.add(new Alumno("Ada", "555A", 18));
	        dam.add(new Alumno("Sam", "666A", 18)); //Pep, Tom, Jon, Tim, Ada, Sam
	        

	        //m�todos interface List. En estos m�todos pasamos un �ndice y un elemento
	        dam.set(2,new Alumno("Ana", "777A",20)); //Sustituye Jon por Ana: Pep, Tom, Ana, Tim, Ada, Sam
	        dam.add(2,new Alumno("Bil", "777A",20)); //A�ade y desplaza: Pep, Tom, Bil, Ana, Tim, Ada, Sam

	        //m�todos interfaces Deque
	        dam.pollFirst(); //Elimina  el primer elemento de la lista o null si est� vac�a
	        dam.pollLast(); //Elimina el �ltimo elemento de la lista o null si est� vac�a
	        dam.offerFirst(new Alumno("Jud", "888A", 24)); //Inserta al principio de la lista
	        dam.offerLast(new Alumno("Kim", "999A", 28)); //Inserta al final de la lista

	        System.out.println(dam.removeFirst());  //Elimina el primer y devuelve el primer elemento
	        System.out.println(dam.removeLast()); //Elimina el �ltimo y lo devuelve

	        System.out.println(dam);
	        
	    }

	}

