package semana2.tareaSol.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import semana2.ejemplo1.DAO.DatabaseManager;
import semana2.ejemplo1.entidades.Curso;
import semana2.tareaSol.entidades.Empleado;
import semana2.tareaSol.entidades.Sucursal;

public class DAOEmpleados {
	private static final String ALL = "SELECT * FROM EMPLEADOS";	
	private static final String INSERT = "INSERT INTO EMPLEADOS (ID_EMPLEADO, CEDULA, NOMBRE, APELLIDO, SUELDO, ID_SUCURSAL) SELECT MAX(ID_EMPLEADO)+1, ?, ?,?,?,?  FROM EMPLEADOS";
	
	private static final String UPDATE = "UPDATE EMPLEADOS SET TELEFONO = ?, DIRECCION=?, NOMBRE=? WHERE ID_SUCURSAL=?";
	private static final String DELETE = "DELETE FROM EMPLEADOS WHERE ID_EMPLEADO=?"; 
	private static final String ID = "SELECT * FROM EMPLEADOS WHERE ID_EMPLEADO=?";
	
	//Inserta el curso pasado por parámetro
	public static boolean insert(Empleado empleado){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT);
						
			statement.setString(1, empleado.getCi());
			statement.setString(2, empleado.getNombre());
			statement.setString(3, empleado.getApellido());
			statement.setDouble(4, empleado.getSueldo());
			statement.setDouble(5, empleado.getSucursal().getIdSucursal());
			
			int retorno = statement.executeUpdate();
								
			return retorno>0;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean edit(Curso curso){
		
			
								
			return true;
			
		
	}
	
	public static boolean delete(Curso curso){
	
			return true;
		
	}
	

	//Obtiene todos los cursos almacenados
	public static LinkedList<Sucursal> findAll(){
		LinkedList<Sucursal> sucursales = new LinkedList<>();
		
		
			return sucursales ;
		
		
	}
	
	
	//Obtiene un curso determinado
	public static Empleado find(long idEmpleado){
				
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ID);
			statement.setLong(1, idEmpleado);
									
			ResultSet resultado = statement.executeQuery();
			Empleado empleado = null;
			while (resultado.next()){				
				empleado   = getEmpleadoFromResultSet(resultado);	
			}
			return empleado  ;	
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		

	}
		
		
	//Funcion auxiliar que traduce un registro a una instancia de curso
	private static Empleado  getEmpleadoFromResultSet(ResultSet resultado) throws SQLException{
		int idEmpleado = resultado.getInt("ID_EMPLEADO");
		String ci = resultado.getString("CEDULA");
		
		String nom = resultado.getString("NOMBRE");
		String apellido = resultado.getString("APELLIDO");
		double sueldo= resultado.getDouble("SUELDO");
		
		long idSucursal = resultado.getLong("ID_SUCURSAL");
		
		Sucursal sucursal = DAOSucursales.find(idSucursal);
		
		Empleado em = new Empleado(idEmpleado, ci, nom, apellido, sueldo, sucursal);
		return em;
	}
}
