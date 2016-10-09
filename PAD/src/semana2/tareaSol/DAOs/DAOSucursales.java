package semana2.tareaSol.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

import semana2.ejemplo1.DAO.DatabaseManager;
import semana2.ejemplo1.entidades.Curso;
import semana2.tareaSol.entidades.Sucursal;

public class DAOSucursales {
	private static final String ALL = "SELECT * FROM SUCURSALES";	
	private static final String INSERT = "INSERT INTO SUCURSALES (ID_SUCURSAL,TELEFONO, DIRECCION, NOMBRE) SELECT MAX(ID_SUCURSAL)+1, ?, ?,?  FROM SUCURSALES";
	
	private static final String UPDATE = "UPDATE SUCURSALES SET TELEFONO = ?, DIRECCION=?, NOMBRE=? WHERE ID_SUCURSAL=?";
	private static final String DELETE = "DELETE FROM SUCURSALES WHERE ID_SUCURSAL=?"; 
	private static final String ID = "SELECT * FROM SUCURSALES WHERE ID_SUCURSAL=?";
	
	//Inserta el curso pasado por parámetro
	public static boolean insert(Sucursal sucursal){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT);
						
			statement.setString(1, sucursal.getTelefono());
			statement.setString(2, sucursal.getDireccion());
			statement.setString(3, sucursal.getNombre());
							
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
	public static Sucursal find(long idSucursal){
				
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ID);
			statement.setLong(1, idSucursal);
									
			ResultSet resultado = statement.executeQuery();
			Sucursal sucursal = null;
			while (resultado.next()){				
				sucursal  = getSucursalFromResultSet(resultado);	
			}
			return sucursal ;	
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		

	}
		
		
	//Funcion auxiliar que traduce un registro a una instancia de curso
	private static Sucursal  getSucursalFromResultSet(ResultSet resultado) throws SQLException{
		int idSucursal = resultado.getInt("ID_SUCURSAL");
		String telefono = resultado.getString("TELEFONO");
		String dir = resultado.getString("DIRECCION");
		String nom = resultado.getString("NOMBRE");
		
		Sucursal su = new  Sucursal(idSucursal, telefono, dir,nom);
		return su;
	}
	
}

