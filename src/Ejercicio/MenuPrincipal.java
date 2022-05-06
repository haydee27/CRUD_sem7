
package Ejercicio;


import java.sql.SQLException;
import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) throws SQLException {
        desplegarMenu();
    }
    

    public static void desplegarMenu() throws SQLException {
        Scanner OS = new Scanner (System.in);
        String OM;
        
        System.out.println("<<<<<<<<<<<<< CRUD >>>>>>>>>>>>> ");
        System.out.println("----REGISTROS DE ESTUDIANTES---- ");
        System.out.println("*     Opciones:                 *");
        System.out.println("*1 Crear registro de estudiante *");
        System.out.println("*2 Consultar registros          *");
        System.out.println("*3 Actualizar registros         *");
        System.out.println("*4 Eliminar registros           *");
        System.out.println("*5 Salir                        *");
        System.out.println("<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
        System.out.println("Seleccionar opcion: ");
        OM = OS.next();
        
        //Desplegando menu
        switch (OM){
            case "1":
                Create c = new Create();
            break;
            case "2":
                Read r = new Read();
            break;  
            case "3":
                Update u = new Update();
            break;
            case "4":
                Delete d = new Delete();
            break;
            case "5":
                System.exit(0);
            break;
            default:
                System.out.println("Seleccion invalida! ");
            break;
        }
    }
    
}

