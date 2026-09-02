package Usuarios;

import ConexionBD.ConexionBD;
import Tickets.Comentarios;
import Tickets.ManagerTicket;
import Tickets.Ticket;
import jdk.javadoc.doclet.Taglet;

import java.sql.*;
import java.util.Scanner;

import static Tickets.ManagerTicket.allTickets;

public class Technical  {
    //Atributos
    public String ID;
    public String name;
    public String surnames;
    public String email;
    public final String departamento = "Técnico";

    ConexionBD conexionBD = new ConexionBD();


    //Constructor
    public Technical(String ID,String name, String surnames, String email){
        this.ID = ID;
        this.name = name;
        this.surnames = surnames;
        this.email = email;
        //conexionBD.insertTecnical(this);
    }

    //Métodos
    public void selectAllUser(){
        String query = "Select * from users";
        String url = "jdbc:mariadb://localhost:3306/ticketmanager";
        String usuario = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, usuario, password);
            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String ID = rs.getNString("ID");
                String name = rs.getNString("Name");
                String Surnames = rs.getNString("Surnames");
                String Email = rs.getNString("Email");
                String Rol = rs.getNString("Rol");

                System.out.println("ID: " + ID + " Name: " + name + " " + Surnames + " Email: " + Email + " Rol: " + Rol );

            }

        }catch (SQLException e){
            System.out.println("Error al solicitar datos: " + e.getMessage());
        }
    }

    public void selectAllTicket(){
        String query = "Select * from tickets";
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
                String ID_Creado = rs.getNString("ID_Creador");
                String ID_Tecnico = rs.getNString("ID_Tecnico");


                System.out.println("ID: " + ID + " Titulo: " + Titulo + " Descripcion: " + Descripcion + " Estado: " + Estado + " Fecha: " + Fecha +
                        " ID_EMPLEADO: " + ID_Creado + " ID_Tecnico: " + ID_Tecnico);

            }

        }catch (SQLException e){
            System.out.println("Error al solicitar datos: " + e.getMessage());
        }
    }

    public void selectTicket(int id){
        String query = "Select * from tickets where ID=?";
        String url = "jdbc:mariadb://localhost:3306/ticketmanager";
        String usuario = "root";
        String password = "";

        try{
            Connection connection = DriverManager.getConnection(url, usuario, password);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
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

    public void assignTicket(int id){
        selectTicket(id);
        String query = "UPDATE tickets SET ID_Tecnico = ?,Estado = ?  WHERE ID = ?";
        String url = "jdbc:mariadb://localhost:3306/ticketmanager";
        String usuario = "root";
        String password = "";
        try {
            Connection connection = DriverManager.getConnection(url, usuario, password);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, this.ID);
            ps.setString(2, "En curso");
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("Ticket actualizado correctamente");
        }catch (SQLException e){
            System.out.println("No se ha podido asignar el ticket: " + e.getMessage());
        }
        selectTicket(id);
    }

    /*
    public void assignTicket(int id){
        try{
            if (id > allTickets.size() || id == 0){
                throw new ArrayIndexOutOfBoundsException("No se ha encontrado el ID indicado");
            }else {
                for(int i=0; i < allTickets.size(); i++){
                    if (id == allTickets.get(i).ID){
                        allTickets.get(i).getData();
                        System.out.println("Si desea asignarse el ticket, pulse 1");
                        System.out.println("Si desea buscar otro ticket, pulse 2");
                        var respuestaScaner = new Scanner(System.in);
                        int valorRespuesta = respuestaScaner.nextInt();
                        if (valorRespuesta == 1){
                            allTickets.get(i).tecnicoResponsable = this;
                            System.out.println("Ticket asignado correctamente");
                            allTickets.get(i).getData();
                            stateChangeEncurso(allTickets.get(i));
                        } else if (valorRespuesta == 2) {
                            System.out.println("Introduzca el ID del ticket que desea buscar");
                            var newScanner = new Scanner(System.in);
                            int nuevaBusqueda = newScanner.nextInt();
                            assignTicket(nuevaBusqueda);
                        }else{
                            System.out.println("Error: algo ha salido mal" );
                        }
                    }

                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Esta función solo se utiliza para actualizar el estado cuando se asigna el ticket
    private void stateChangeEncurso(Ticket ticket){
        ticket.estado = ManagerTicket.Estado.EnCurso;
    }

    public void updateTicketState(int id, ManagerTicket.Estado estado){
        try {
            if (id > allTickets.size() || id == 0){
                throw new ArrayIndexOutOfBoundsException("El ID introducido no es valido");
            }else{
                for(int i=0; i < allTickets.size(); i++){
                    if (id == allTickets.get(i).ID){
                        allTickets.get(i).estado =  estado;
                        allTickets.get(i).tecnicoResponsable = this;
                        System.out.println("El estado del ticket se ha actualizado correctamente");
                        allTickets.get(i).getData();
                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void commentTicket(int id){
        try{
            if (id > allTickets.size() || id == 0){
                throw new ArrayIndexOutOfBoundsException("No se ha podido encontrar el ID indicado");
            }else{
                for (int i = 0; i < allTickets.size(); i++){
                    if (id == allTickets.get(i).ID){
                        allTickets.get(i).getData();
                        System.out.println("Escriba el comentario deseado:");
                        var commentScanner = new Scanner(System.in);
                        String valorComentario = commentScanner.nextLine();
                        var newComment = new Comentarios(valorComentario);
                        allTickets.get(i).comentarios.add(newComment);
                        System.out.println("Comentario agregador correctamente");
                        for (int x = 0; x<allTickets.get(i).comentarios.size(); x++){
                            allTickets.get(i).comentarios.get(x).technical = this;
                        }

                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showComment(int id){
        try {
            if (id > allTickets.size() ||id == 0){
                throw new ArrayIndexOutOfBoundsException("No se ha podido encontrar el ticket indicado");
            }else{
                for (int i=0; i < allTickets.size(); i++){
                    if (id == allTickets.get(i).ID){
                        if (allTickets.get(i).comentarios.isEmpty()){
                            System.out.println("Aún no hay comentarios disponibles");
                        }else{
                            for (int x=0; x < allTickets.get(i).comentarios.size(); x++){
                                allTickets.get(i).comentarios.get(x).showCommentData();
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
