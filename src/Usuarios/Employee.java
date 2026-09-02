package Usuarios;

import ConexionBD.ConexionBD;
import Tickets.Comentarios;
import Tickets.Ticket;

import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.RMISocketFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends ManagerEmployee implements ConexionBD.ManageTicketDB{
    //Atributos
    public String ID; //DNI
    public String name;
    public String surnames;
    public String email;

    ArrayList<Ticket> misTickets = new ArrayList<>();
    //static ArrayList<Employee> allEmployee = new ArrayList<>();
     ConexionBD conexionDB = new ConexionBD();

     //Constructor
    public Employee(String ID, String name, String surnames, String email){
        this.ID = ID;
        this.name = name;
        this.surnames = surnames;
        this.email = email;
        //allEmployee.add(this);
        //conexionDB.insertEmployee(this);
    }

    //Métodos
    public void crearTicket(String titulo, String descripcion){
        var nuevoTicket = new Ticket(titulo, descripcion);
        nuevoTicket.employee = this;
        //misTickets.add(nuevoTicket);
        conexionDB.insertTicket(nuevoTicket);
    }

    public void mostrarTicketsUser(){
        String query = "Select * from tickets where ID_Creador =?";
        String url = "jdbc:mariadb://localhost:3306/ticketmanager";
        String usuario = "root";
        String password = "";

        try{
            Connection connection = DriverManager.getConnection(url, usuario, password);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, this.ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int ID = rs.getInt("ID");
                String Titulo = rs.getNString("Titulo");
                String Descripcion = rs.getNString("Descripcion");
                String Estado = rs.getNString("Estado");
                String Fecha = rs.getNString("Fecha");
                String ID_Creado = rs.getNString("ID_Creador");
                String ID_Tecnico = rs.getNString("ID_Tecnico");

                System.out.println("ID: " + ID + " Titulo: " + Titulo + " Descripcion: " + Descripcion + " Estado: " + Estado + " Fecha: " + Fecha +
                        " ID_EMPLEADO: " + ID_Creado + " ID_Tecnico: " + ID_Tecnico);
            }

        }catch (SQLException e){
            System.out.println("No se ha podido encontrar el ticket indicado: " + e.getMessage());
        }

    }

    public void getUserData(){
        System.out.println("ID" + this.ID + " " + this.name + " " + this.surnames);
    }

/*
    public void commentTicket(int id){
        try{
            if (id == 0){
                throw new ArrayIndexOutOfBoundsException("No se ha podido encontrar el ID indicado");
            }else{
                for(int i = 0; i < misTickets.size(); i++){
                    if (misTickets.get(i).ID == id){
                        misTickets.get(i).getData();
                        System.out.println("Escriba el comentario deseado:");
                        var comentScanner = new Scanner(System.in);
                        String valorComent = comentScanner.nextLine();
                        var newComment = new Comentarios(valorComent);
                        misTickets.get(i).comentarios.add(newComment);
                        System.out.println("Comentario agregado correctamente");
                        for (int x = 0; x < misTickets.get(i).comentarios.size(); x++){
                            misTickets.get(i).comentarios.get(x).empleado = this;
                        }
                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showComment(int id){
        try{
            if (id == 0){
                throw new ArrayIndexOutOfBoundsException("No se ha podido encontrar el ticket");
            }else {
                for (int i=0; i < misTickets.size(); i++){
                    if (misTickets.get(i).ID == id){
                        if (misTickets.get(i).comentarios.isEmpty()){
                            System.out.println("Aún no hay comentarios disponibles");
                        }else{
                            for (int x=0; x<misTickets.get(i).comentarios.size(); x++){
                                misTickets.get(i).comentarios.get(x).showCommentData();
                            }
                        }
                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

 */

}
