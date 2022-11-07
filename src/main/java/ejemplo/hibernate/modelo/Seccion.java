package ejemplo.hibernate.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SECCION")
public class Seccion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_SECCION")
    private long CodSeccion;

    @Column(name = "NOMBRE")
    private String nombre;


    @OneToMany(mappedBy = "seccion", cascade = CascadeType.ALL) // el cascade es necesario para que guarde los empleados
    private List<Empleado> items;

    //javaBean es requisito

    public Seccion(){

    }

    public Seccion(long codSeccion, String nombre) {
        CodSeccion = codSeccion;
        this.nombre = nombre;
    }

    public long getCodSeccion() {
        return CodSeccion;
    }

    public void setCodSeccion(long codSeccion) {
        CodSeccion = codSeccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getItems() {
        return items;
    }

    public void setItems(List<Empleado> items) {
        this.items = items;
    }

    @Override
    public String toString() {

        var ref = new Object() {
            String empleados = "";
        };

        items.forEach(emp -> ref.empleados += "\t{" + emp.getNombre() + "}\n");

        return "Seccion{" +
                "CodSeccion=" + CodSeccion +
                ", nombre='" + nombre + "',\n" +
                "Empleados=\n{\n" + ref.empleados +  "\t}\n" +
                '}';
    }
}
