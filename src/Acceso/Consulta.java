package Acceso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consulta 
{
	conexion iniciar = new conexion();
	
	public void insertarEnBaseDeDatos(String usuario, String contraseña) {
	    // Configurar la conexión a la base de datos Oracle
	    String url = "jdbc:oracle:thin:@localhost:1521:xe";
	    String usuarioBD = "system";
	    String contraseñaBD = "200102";

	    // Consulta SQL para la inserción
	    String consultaSQL = " INSERT INTO SYSTEM.USERS (COLUMN1, COLUMN2) VALUES (:1 , :2 )";

	    try (Connection connection = DriverManager.getConnection(url, usuarioBD, contraseñaBD);
	            PreparedStatement preparedStatement = connection.prepareStatement(consultaSQL)) {

	           preparedStatement.setString(1, usuario);
	           preparedStatement.setString(2, contraseña);

	           preparedStatement.executeUpdate();

	           System.out.println("Datos insertados correctamente en la base de datos.");

	       } catch (SQLException ex) {
	           ex.printStackTrace();
	           System.err.println("Error al insertar datos en la base de datos: " + ex.getMessage());
	       }
	}
	public void eliminarUltimo(String usuario, String contraseña) {
		 // Configurar la conexión a la base de datos Oracle
	    String url = "jdbc:oracle:thin:@localhost:1521:xe";
	    String usuarioBD = "system";
	    String contraseñaBD = "200102";

		
		String consultaEliminar="DELETE FROM SYSTEM.USERS WHERE COLUMN1 = (SELECT MAX(COLUMN1) FROM SYSTEM.USERS)"; 
			
		 try (Connection connection = DriverManager.getConnection(url, usuarioBD, contraseñaBD);
		            PreparedStatement preparedStatement = connection.prepareStatement(consultaEliminar)) {

		           preparedStatement.setString(1, usuario);
		           preparedStatement.setString(2, contraseña);

		           preparedStatement.executeUpdate();

		           System.out.println("Datos insertados correctamente en la base de datos.");

		       } catch (SQLException ex) {
		           ex.printStackTrace();
		           System.err.println("Error al eliminar datos en la base de datos: " + ex.getMessage());
		       }
	}
	

}