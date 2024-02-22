package Tema6.Ejemplos;

	public class Alumno implements Comparable<Alumno> {

	    private String nombre;
	    private String nia;
	    private int edad;

	    public Alumno(String nombre, String nia, int edad) {
	        this.nombre = nombre;
	        this.nia = nia;
	        this.edad = edad;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getNia() {
	        return nia;
	    }

	    public void setNia(String nia) {
	        this.nia = nia;
	    }

	    public int getEdad() {
	        return edad;
	    }

	    public void setEdad(int edad) {
	        this.edad = edad;
	    }

	    public int compareTo(Alumno a) {
	        if (this.nia.compareTo(a.getNia()) == 0)
	            return 0;
	        int comparacion = Integer.compare(this.edad, a.getEdad());
	        if (comparacion == 0)
	            comparacion = nia.compareTo(a.getNia());
	        return comparacion;
	    }
	/*/ 
	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((nia == null) ? 0 : nia.hashCode());
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Alumno other = (Alumno) obj;
	        if (nia == null && other.nia != null)
	            return false;
	        else if (!nia.equals(other.nia))
	            return false;
	        return true;
	    }/*/

	    @Override
	    public String toString() {
	        //return "Alumno [nombre=" + nombre + ", nia=" + nia + ", edad=" + edad + "]";
	        return nombre;
	    }

	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
	        result = prime * result + ((nia == null) ? 0 : nia.hashCode());
	        result = prime * result + edad;
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Alumno other = (Alumno) obj;
	        if (nombre == null) {
	            if (other.nombre != null)
	                return false;
	        } else if (!nombre.equals(other.nombre))
	            return false;
	        if (nia == null) {
	            if (other.nia != null)
	                return false;
	        } else if (!nia.equals(other.nia))
	            return false;
	        if (edad != other.edad)
	            return false;
	        return true;
	    } 

	}

