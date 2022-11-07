package ejemplo.hibernate;

import ejemplo.hibernate.modelo.Empleado;
import ejemplo.hibernate.modelo.Seccion;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class TestEmpleados {

    //gestor de persistencia CRUD

    private static EntityManager manager;
    private static EntityManagerFactory emf;

    public static void main(String[] args){
        emf = Persistence.createEntityManagerFactory("aplicacion");
        manager = emf.createEntityManager();

        Seccion seccion = new Seccion(1, "Carnicero");
        Seccion seccion2 = new Seccion(2, "Frutero");

        Empleado empleado1 = new Empleado(10L, "Garcia", "Jose Luis", new GregorianCalendar(1988,6,6).getTime(), seccion);
        Empleado empleado2 = new Empleado(11L, "Villarán", "Jose Antonio", new GregorianCalendar(1978,6,6).getTime(), seccion);
        Empleado empleado3 = new Empleado(12L, "Mairena", "Carmen", new GregorianCalendar(1958,6,6).getTime(), seccion);

        List<Empleado> empCarni = new ArrayList<>();
        empCarni.add(empleado1);
        empCarni.add(empleado2);
        empCarni.add(empleado3);

        Empleado empleado4 = new Empleado(13L, "Manteca", "Paco", new GregorianCalendar(1988,6,6).getTime(), seccion2);
        Empleado empleado5 = new Empleado(14L, "Veneno", "La", new GregorianCalendar(1978,6,6).getTime(), seccion2);
        Empleado empleado6 = new Empleado(15L, "Esteban", "Belén", new GregorianCalendar(1958,6,6).getTime(), seccion2);

        List<Empleado> empFrut = new ArrayList<>();
        empFrut.add(empleado4);
        empFrut.add(empleado5);
        empFrut.add(empleado6);

        seccion.setItems(empCarni);
        seccion2.setItems(empFrut);

        manager.getTransaction().begin();
        manager.persist(seccion);// al darle persist digamos que el objeto tiene un puntero a la bbdd y los cambios se registran automáticamente
        manager.persist(seccion2);// al darle persist digamos que el objeto tiene un puntero a la bbdd y los cambios se registran automáticamente
        manager.getTransaction().commit();

        List<Seccion> secciones = (List<Seccion>) manager.createQuery("FROM Seccion").getResultList();

        secciones.forEach((e) -> System.out.println(e.toString()));

        System.out.printf("Hay %d secciones.\n", secciones.size());

        List<Empleado> empleados = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();

        empleados.forEach((e) -> System.out.println(e.toString()));

        System.out.printf("Hay %d empleados.", empleados.size());


    }

}
