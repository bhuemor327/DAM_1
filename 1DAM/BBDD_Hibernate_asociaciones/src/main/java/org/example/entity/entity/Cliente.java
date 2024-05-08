package org.example.entity.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//MArcamos esta tabla como una entidad, lo que significa que está asociada con una TABLA de la BBDD
@Entity

//Indicamos el nombre de la tabla en el almacen de datos
@Table (name="clientes")

public class Cliente {

    //Mapeamos los campos a los de la tabla

    //1. Para indicar que es una clave primaria utilizamos @Id
    //   Para indicar que es una clave y autoincremental utilizamos GenerateValue indicando que es autoincremental con Identity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //2. El resto se mapean de forma automática ya que tienen el mismo nombre que en la taba
    private String nombre;
    private String apellido;

    //3. Si no tiene el mismo nombre debemos utilizar  @Column con el nombre de la columna
    @Column(name = "forma_pago")
    private String formaPago;

    @OneToMany (cascade = CascadeType.ALL) //Este parámetro permite que los datos de direcciones se guarden al guardar un nuevo cliente con direcciones asociadas.
    // @JoinColumn(name="id_cliente"): Esto en lugar de crear una tabla intermedia, creará una columna con la clave foránea que nos relacionará ambas entidades
    private List<Direccion> direcciones = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String formaPago) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.formaPago = formaPago;
    }

    public Cliente(String nombre, String apellido, String formaPago, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direcciones.add(direccion);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", formaPago='" + formaPago;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

   public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }
}
