
package Ejercicio;


import java.sql.SQLException;

public class Read {
    public Read() throws SQLException {
        System.out.println("<< CONSULTA DE REGISTRO >>");
        mostrarResultados();
    }

    private void mostrarResultados() throws SQLException {
        try{
            Conexion_CRUD utilerias = new Conexion_CRUD();
            String tabla = "bd_estudiante";
            String CamposTabla = "*";
            String condicionBuscar= "";
            
            utilerias.desplegarRegistros(tabla, CamposTabla, condicionBuscar);
            
            
        }catch(SQLException ex) {
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage()); 
        }finally{
            MenuPrincipal.desplegarMenu();
        }
    }
}

