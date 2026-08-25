package Usuarios;

import java.util.ArrayList;

public abstract class ManagerEmployee {
    //Atributos
    public int ID; //DNI
    public String name;
    public String surnames;
    public String departamento;

    static ArrayList<Employee> allEmployee = new ArrayList<>();
    static int IdUserActual = 1;

    //Métodos


    //Interfaces

    public interface showEmployee{
        default void getAllEmployee(){
            for (int i = 0; i < allEmployee.size(); i++){
                System.out.println("ID" + allEmployee.get(i).ID + " " + allEmployee.get(i).name);
            }
        }

        default void searchEmployee(int id){
            try {
                if (id > allEmployee.size() || id == 0){
                    throw new ArrayIndexOutOfBoundsException("No se ha encontrado el ID");
                }else {
                    for (int i= 0; i < allEmployee.size(); i++){
                        if (allEmployee.get(i).ID == id){
                            allEmployee.get(i).getUserData();
                        }
                    }
                }
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Error: " + e.getMessage());
            }
        }

    }
}
