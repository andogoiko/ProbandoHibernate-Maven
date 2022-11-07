package ejemplo.hibernate.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "EMPLEADO")
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_EMPLEADO")
    private long codigo;

    @Column(name = "APELLIDOS")
    private String apellidos;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;

    @ManyToOne
    @JoinColumn(name="seccion_id", nullable=false)
    private Seccion seccion;

    //javaBean es requisito

    public Empleado(){

    }

    public Empleado(long codigo, String apellidos, String nombre, Date fechaNacimiento, Seccion seccion) {
        this.codigo = codigo;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.seccion = seccion;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "codigo=" + codigo +
                ", apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", seccion=" + seccion.toString() +
                '}';
    }
}
