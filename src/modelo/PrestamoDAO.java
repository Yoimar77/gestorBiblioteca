package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PrestamoDAO extends DatabaseConnection {
	 private Connection conexion;
	 public PrestamoDAO() {
		
	 }
	 public void cargarProductosTabla(DefaultTableModel modelo) {
	     try {
	    	 modelo.setRowCount(0);
	    	 this.conexion=getConnection();
	         String sql = "SELECT * FROM prestamos";
	         PreparedStatement sentencia = conexion.prepareStatement(sql);
	         ResultSet resultado = sentencia.executeQuery();

	         // Llena la tabla con los datos de la base de datos
	         while (resultado.next()) {//resultado.next trae una fila completa de la tabla 
	             int id = resultado.getInt("id");
	             int libroId= resultado.getInt("libro_id");
	             int usuarioId= resultado.getInt("usuario_id");
	             String fechaPrestamo= resultado.getString("fecha_prestamo");
	             String fechaDevolucion= resultado.getString("fecha_devolucion");
	            
	             modelo.addRow(new Object[]{id,libroId,usuarioId,fechaPrestamo,fechaDevolucion});
	         }

	         // Cierra el statement y el result set
	         sentencia.close();
	         resultado.close();

	     } catch (SQLException e) {
	         JOptionPane.showMessageDialog(null,"Ha ocurrido un problema al intentar mostrar la tabla: "+ e.getMessage());
	     }
	     finally{
	     	closeConnection();
	     }
	 }
		public void actualizarRegistroTabla(Prestamo prestamo) {

			try {
				this.conexion = getConnection();
				String sql = "UPDATE prestamos SET id =?,libro_id=?,usuario_id=?,fecha_prestamo=?,fecha_devolucion=? WHERE id=? ";
				PreparedStatement sentencia = conexion.prepareStatement(sql);

				sentencia.setInt(1,prestamo.getId());
				sentencia.setInt(2, prestamo.getLibro_id());
				sentencia.setInt(3, prestamo.getUsuario_id());
				sentencia.setString(4, prestamo.getFecha_prestamo());
				sentencia.setString(5, prestamo.getFecha_devolucion());
				sentencia.setInt(6, prestamo.getId());
				
				sentencia.execute();
				JOptionPane.showMessageDialog(null, "¡registro actualizado correctamente!");
				// Cierra el statement
				sentencia.close();

			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "¡el registro no se ha actualizado correctamente!" + e.getErrorCode());
			} finally {
				closeConnection();
			}
		}

		public void buscarXid(Prestamo prestamo) {
			try {
				this.conexion = getConnection();
				String sql = "SELECT * FROM prestamos WHERE id=?";
				PreparedStatement sentencia = conexion.prepareStatement(sql);
				sentencia.setInt(1, prestamo.getId());
				ResultSet resultado = sentencia.executeQuery();
				
				if(resultado.next()) {
					prestamo.setId(Integer.parseInt(resultado.getString("id")));
					prestamo.setUsuario_id(resultado.getInt("usuario_id"));
					prestamo.setLibro_id(resultado.getInt("libro_id"));
					prestamo.setFecha_prestamo(resultado.getString("fecha_prestamo"));
					prestamo.setFecha_devolucion(resultado.getString("fecha_devolucion"));
				}
				// Cierra el statement y result
				sentencia.close();
				resultado.close();

			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally {
				closeConnection();
			}
		}
		public void eliminarRegistro(Prestamo prestamo) {
			this.conexion=getConnection();
			String sql = " DELETE FROM prestamos WHERE id=?";
			try {
				PreparedStatement sentencia = conexion.prepareStatement(sql);
				sentencia.setInt(1, prestamo.getId());
				sentencia.execute();
				JOptionPane.showMessageDialog(null,"El registro se eliminó correctamente.");
				
				sentencia.close();
				
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,
							"Ha ocurrido un problema al intentar eliminar el registro: " + e.getMessage());
			} finally {
				closeConnection();
			}
			
			}
		public void buscarXlibroId(Prestamo prestamo,DefaultTableModel modelo) {
			try {
				//limpio el modelo de la tabla antes de mostrar la tabla
				modelo.setRowCount(0);
				
				this.conexion = getConnection();
				String sql = "SELECT * FROM prestamos WHERE libro_id=?";
				PreparedStatement sentencia = conexion.prepareStatement(sql);
				sentencia.setInt(1, prestamo.getLibro_id());
				ResultSet resultado = sentencia.executeQuery();
				
				if(resultado.next()) {
					int id=resultado.getInt("id");
					int libro_id = resultado.getInt("libro_id");
					int usuario_id = resultado.getInt("usuario_id");
					String fecha_prestamo = resultado.getString("fecha_prestamo");
					String fecha_devolucion = resultado.getString("fecha_devolucion");
					
					//agrega al modelo de la tabla todos los campos extraídos del resultado
					modelo.addRow(new Object[] { id, libro_id,usuario_id,fecha_prestamo,fecha_devolucion});
				}
				else {
					JOptionPane.showMessageDialog(null, "¡no existe un registro con ese nombre, intentalo de nuevo!");
				}
				// Cierra el statement y result
				sentencia.close();
				resultado.close();

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
						"Ha ocurrido un problema al intentar mostrar los registros: " + e.getMessage());
			} finally {
				closeConnection();
			}
		}
	    public void registrarPrestamo(Prestamo prestamo) {
	        try {
	        	this.conexion=getConnection();
	            String sql = "INSERT INTO prestamos (libro_id, usuario_id, fecha_prestamo, fecha_devolucion) VALUES (?, ?, ?, ?)";
	            PreparedStatement sentencia = conexion.prepareStatement(sql);

	            sentencia.setInt(1, prestamo.getLibro_id());
	            sentencia.setInt(2, prestamo.getUsuario_id());
	            sentencia.setString(3, prestamo.getFecha_prestamo());
	            sentencia.setString(4, prestamo.getFecha_devolucion());

	            sentencia.executeUpdate();
	            JOptionPane.showMessageDialog(null, "¡Préstamo registrado correctamente!");

	            sentencia.close();
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Error al intentar registrar préstamo: " + e.getMessage());
	        }finally {
				closeConnection();
			}
	    }
	 
}
