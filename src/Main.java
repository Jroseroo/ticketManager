import Tickets.Ticket;
import Usuarios.Employee;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        var empleado1 = new Employee("1", "Dani", "Rosero", "Informática");
        var ticket1 = new Ticket("Prueba", "Esto es una prueba", empleado1);

        System.out.println(ticket1.titulo);
        System.out.println(empleado1.name);
        empleado1.crearTicket("Prueba2", "Esta es la segunda prueba");
        empleado1.mostrarTicketsUser();

    }

}