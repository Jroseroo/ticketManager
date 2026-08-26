import Tickets.ManagerTicket;
import Tickets.Ticket;
import Usuarios.AdminApp;
import Usuarios.Employee;
import Usuarios.Technical;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        var empleado1 = new Employee("Joan", "Rosero", "IT");
        empleado1.crearTicket("Prueba 1", "Primera prueba");
        empleado1.crearTicket("Prueba 2", "Segunda prueba");
        //empleado1.mostrarTicketsUser();

        var empleado2 = new Employee( "Daniela", "Gómez", "Dibujo");
        empleado2.crearTicket("Prueba 3", "Tercera prueba");
        empleado2.crearTicket("PruebaNX", "Comprobación");
        var empleado3 = new Employee("Isa", "Márquez", "Educación");
        var empleado4 = new Employee("Joan", "Gómez", "Mantenimiento");

        var admin1 = new AdminApp("3", "Isa", "Márquez");


        var tecnico1 = new Technical("1", "Monito", "Kiki");
        //empleado2.mostrarTicketsUser();
        tecnico1.showUserTicket(1);





    }

}