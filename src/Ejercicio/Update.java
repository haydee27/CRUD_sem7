
package Ejercicio;


import java.sql.SQLException;
import java.util.Scanner;

public class Update {
    
    Update() throws SQLException {
        Scanner l = new Scanner (System.in);
        Estudiante est = new Estudiante();
        Conexion_CRUD utilerias = new Conexion_CRUD();
        System.out.println("<< ACTUALIZAR REGISTRO >>");
        
        System.out.println("Ingresar registro a modificar: ");
        est.setId_estudiante(l.nextInt());
        
        String tablaBuscar = "bd_estudiante";
        String CamposBuscar = "id_estudiante, carnet_estudiante, nom_estudiante, ape_estudiante, edad_estudiante";
        String condicionBuscar = "id_estudiante = " + est.getId_estudiante();
        utilerias.desplegarRegistros(tablaBuscar, CamposBuscar, condicionBuscar);
        
        
        System.out.println("carnet: ");
        est.setCarnet_estudiante(l.next());
        
        System.out.println("Nombre: ");
        est.setNomEstudiante(l.next());
        
        System.out.println("Apellido: ");
        est.setApeEstudiante(l.next());
        
        System.out.println("Edad: ");
        est.setEdad_estudiante(l.nextInt());
        
        String tabla = "bd_estudiante";
        String camposValoresNuevos ="carnet_estudiante= '" + est.getCarnet_estudiante() + "', nom_estudiante= '" + est.getNomEstudiante() + "', ape_estudiante= '" + est.getApeEstudiante()
        +  "',edad_estudiante= '" + est.getEdad_estudiante()+"'";
        
        utilerias.actualizarEliminarRegistros(tabla, camposValoresNuevos, condicionBuscar);
        System.out.println("Modificar correctamente!");
        
        MenuPrincipal.desplegarMenu();
        
    }
}
