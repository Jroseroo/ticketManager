package ConexionBD;
import Tickets.Comentarios;
import Tickets.ManagerTicket;
import Tickets.Ticket;
import Usuarios.Employee;
import Usuarios.Technical;

import java.sql.*;
import java.util.ArrayList;

public class ConexionBD {
    //Clase para conectar con Base de datos
    String url = "jdbc:mariadb://localhost:3306/ticketmanager";
    String usuario = "root";
    String password = "";

    public ArrayList<Employee> allEmployee = new ArrayList<>();
    public ArrayList<Technical> allTechnical = new ArrayList<>();
    public ArrayList<Ticket> allTickets = new ArrayList<>();
    public ArrayList<Comentarios> allComents = new ArrayList<>();

    public static void main(String[] args) {

    }

    public void onConnect(){
        try {
            Connection connection = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión realizada correctamente");
            connection.close();
        }catch (SQLException e){
            System.out.println("Error al conectar con la BD: " + e.getMessage());
        }
    }

    public void insertUser(int id, String name, String surnames, String email, String rol) {

        String query = "INSERT INTO users (ID, Name, Surnames, Email, Rol) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection(url, usuario, password);

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, surnames);
            ps.setString(4, email);
            ps.setString(5, rol);

            ps.executeUpdate();

            System.out.println("Usuario insertado correctamente");

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }
    }

    public void cargarEmployee(){
        String query = "select * from users where Rol = ?";
        String url = "jdbc:mariadb://localhost:3306/ticketmanager";
        String usuario = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, usuario, password);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "Employee");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String ID = rs.getNString("ID");
                String name = rs.getNString("Name");
                String Surnames = rs.getNString("Surnames");
                String Email = rs.getNString("Email");
                String Rol = rs.getNString("Rol");

                var newEmployee = new Employee(ID, name, Surnames, Email);
                allEmployee.add(newEmployee);

            }
            /*
            for(int i = 0; i<allEmployee.size(); i++){
                System.out.println(allEmployee.get(i).name);
            }
            */

        }catch (SQLException e){
            System.out.println("No se han podido descargar el listado de empleados: " + e.getMessage());
        }
    }

    public void cargarTechnical(){
        String query = "select * from users where Rol = ?";
        String url = "jdbc:mariadb://localhost:3306/ticketmanager";
        String usuario = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, usuario, password);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "Technical");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String ID = rs.getNString("ID");
                String name = rs.getNString("Name");
                String Surnames = rs.getNString("Surnames");
                String Email = rs.getNString("Email");
                String Rol = rs.getNString("Rol");

                var newTechnical = new Technical(ID, name, Surnames, Email);
                allTechnical.add(newTechnical);

            }
            /*
            for(int i = 0; i<allEmployee.size(); i++){
                System.out.println(allEmployee.get(i).name);
            }
            */

        }catch (SQLException e){
            System.out.println("No se han podido descargar el listado de tecnicos: " + e.getMessage());
        }
    }

    public void cargarTickets(){
        String query = "select * from tickets";
        String url = "jdbc:mariadb://localhost:3306/ticketmanager";
        String usuario = "root";
        String password = "";
        try {
            Connection connection = DriverManager.getConnection(url, usuario, password);
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int ID = rs.getInt("ID");
                String Titulo = rs.getNString("Titulo");
                String Descripcion = rs.getNString("Descripcion");
                String Estado = rs.getNString("Estado");
                String Fecha = rs.getNString("Fecha");
                String ID_Creador = rs.getNString("ID_Creador");
                String ID_Tecnico = rs.getNString("ID_Tecnico");

                var newTicket = new Ticket(Titulo, Descripcion);
                newTicket.estado = ManagerTicket.Estado.valueOf(Estado);
                newTicket.dateTime = Fecha;
                newTicket.ID = ID;
                for(int i=0; i<allEmployee.size(); i++){
                    if (allEmployee.get(i).ID.equals(ID_Creador)){
                        newTicket.employee = allEmployee.get(i);
                    }
                }
                for(int i = 0; i<allTechnical.size(); i++){
                    if (allTechnical.get(i).ID == ID_Tecnico){
                        newTicket.tecnicoResponsable = allTechnical.get(i);
                    }
                }

                allTickets.add(newTicket);
            }

        }catch (SQLException e){
            System.out.println("No se han podido descargar el listado de tecnicos: " + e.getMessage());
        }
    }

    public void cargarComentarios(){
        String query = "select * from comments";
        String url = "jdbc:mariadb://localhost:3306/ticketmanager";
        String usuario = "root";
        String password = "";
        try {
            Connection connection = DriverManager.getConnection(url, usuario, password);
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int ID = rs.getInt("ID");
                String ID_Users = rs.getNString("ID_Users");
                int ID_Tickets = rs.getInt("ID_Tickets");
                String Fecha = rs.getNString("Date");
                String Texto = rs.getNString("Texto");

                var newComment = new Comentarios(Texto);
                newComment.ID = ID;
                newComment.date = Fecha;
                for(int i=0; i<allEmployee.size(); i++){
                    if (allEmployee.get(i).ID.equals(ID_Users)){
                        newComment.empleado = allEmployee.get(i);
                    }
                }
                for(int i = 0; i<allTechnical.size(); i++){
                    if (allTechnical.get(i).ID == ID_Users){
                        newComment.technical = allTechnical.get(i);
                    }
                }

                for (int i = 0; i < allTickets.size(); i++){
                    if (allTickets.get(i).ID == ID_Tickets){
                        newComment.ticket = allTickets.get(i);
                    }
                }

                allComents.add(newComment);

            }
            System.out.println("Comentarios descargados correctamente");
        }catch (SQLException e){
            System.out.println("No se han podido descargar el listado de tecnicos: " + e.getMessage());
        }
    }



    public void insertEmployee(Employee employee){
        String query = "INSERT INTO users (ID, Name, Surnames, Email, Rol) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection connection = DriverManager.getConnection(url, usuario, password);

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, employee.ID);
            ps.setString(2, employee.name);
            ps.setString(3, employee.surnames);
            ps.setString(4, employee.email);
            ps.setString(5, "Employee");

            ps.executeUpdate();

            System.out.println("Usuario insertado correctamente");

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }
    }

    public void insertTecnical(Technical technical){
        String query = "Insert into users (ID, Name, Surnames, Email, Rol) VALUES(?, ?,?,?,?)";
        try {
            Connection connection = DriverManager.getConnection(url, usuario, password);

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, technical.ID);
            ps.setString(2, technical.name);
            ps.setString(3, technical.surnames);
            ps.setString(4, technical.email);
            ps.setString(5, "Technical");

            ps.executeUpdate();

            System.out.println("Usuario insertado correctamente");

            connection.close();

        }catch (SQLException e){
            System.out.println("Error al insertar datos: " + e.getMessage());
        }
    }

    public void insertTicket(Ticket ticket){
        String query = "Insert into tickets (Titulo, Descripcion, Estado, Fecha, ID_Creador) VALUES(?, ?,?,?,?)";
        String url = "jdbc:mariadb://localhost:3306/ticketmanager";
        String usuario = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, usuario, password);

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ticket.titulo);
            ps.setString(2, ticket.descripcion);
            ps.setString(3, String.valueOf(ticket.estado));
            ps.setString(4,ticket.dateTime );
            ps.setString(5, ticket.employee.ID);

            ps.executeUpdate();

            System.out.println("Ticket registrado correctamente");

            connection.close();

        }catch (SQLException e){
            System.out.println("Error al crear Ticket: " + e.getMessage());
        }
    }



    public interface ManageUserDB{

    }

    public interface ManageTicketDB{

    }

}

