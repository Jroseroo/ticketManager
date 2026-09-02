import ConexionBD.ConexionBD;
import Tickets.ManagerTicket;
import Tickets.Ticket;
import Usuarios.AdminApp;
import Usuarios.Employee;
import Usuarios.Technical;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ConexionBD conexionBD = new ConexionBD();
        conexionBD.onConnect();
        conexionBD.cargarEmployee();
        conexionBD.cargarTechnical();
        conexionBD.cargarTickets();
        conexionBD.cargarComentarios();

        var miEmpleado = conexionBD.allEmployee.get(0);
        //System.out.println(miEmpleado.name);
/*
        Employee empleadoIsa = null;

        for(int i = 0; i < conexionBD.allEmployee.size(); i++){
            if (conexionBD.allEmployee.get(i).ID.equals("13579246I")){
                empleadoIsa = conexionBD.allEmployee.get(i);
                break;
            }
        }

        if (empleadoIsa != null){
            System.out.println(empleadoIsa.name);
        }else {
            System.out.println("Empleado no encontrado");
        }
 */

        //System.out.println(miTec.name);

        var ticket1 = conexionBD.allTickets.get(0);
        System.out.println(ticket1.titulo + " " + ticket1.descripcion + " Estado: " + ticket1.estado + " " + ticket1.dateTime + " " + ticket1.employee.name);

    }

}