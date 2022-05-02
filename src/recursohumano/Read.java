
package recursohumano;

import java.sql.SQLException;

public class Read {
    public Read() throws SQLException {
        System.out.println("<< CONSULTA DE REGISTROS >>");
        mostrarResultados(); //Llama al metodo dentro de esta clase
    }
    private void mostrarResultados() throws SQLException {
        try{
            
            ConexionCRUD utilerias = new ConexionCRUD();
            String tabla = "tb_contacto";
            String camposTabla = "*";
            //Condicion se envia vacia para indicar que todos los registros se necesitan mostrar
            String condicionBusqueda ="";
            //Metodo que realiza la busqueda
            utilerias.desplegarRegistros(tabla, camposTabla, condicionBusqueda);
        }catch (SQLException ex){
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
        }finally{
            MenuPrincipal.desplegarMenu();
        }
    }
}
