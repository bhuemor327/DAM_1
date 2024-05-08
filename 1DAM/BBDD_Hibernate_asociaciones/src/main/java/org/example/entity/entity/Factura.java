package org.example.entity.entity;

import jakarta.persistence.*;


    @Entity
    @Table (name="facturas")

    public class Factura{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String descripcion;
        private Long total;

        //Vamos a tener una relación de muchas facturas un solo cliente
        //Utilizamos ManyToOne, donde la primera palabra corresponde a la clase en cuestión (factura)
        @ManyToOne
        private Cliente cliente;
        //En este caso, el nombre de la columna que utilizará sera cliente_id, es decir, el nombre especificado seguido de id
        //Si quieramos establecer nosotros el nombre de dicha columna, debemos utilizar @JoinColumn(name="id_column");



        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public Long getTotal() {
            return total;
        }

        public void setTotal(Long total) {
            this.total = total;
        }


        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        public Factura() {
        }

        public Factura(String descripcion, Long total, Cliente cliente) {
            this.descripcion = descripcion;
            this.total = total;
            this.cliente = cliente;
        }

        @Override
        public String toString() {
            return "Factura{" +
                    "id=" + id +
                    ", descripcion='" + descripcion + '\'' +
                    ", total=" + total +
                    ", cliente=" + cliente +
                    '}';
        }
    }

