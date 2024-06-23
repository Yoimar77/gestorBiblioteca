package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UsuarioDAO extends DatabaseConnection{
	 private Connection conexion;
	 public UsuarioDAO() {
		 
	 }
	 public void cargarProductosTabla(DefaultTableModel modelo) {
	     try {
	    	 modelo.setRowCount(0);
	    	 this.conexion=getConnection();
	         String sql = "SELECT * FROM usuarios";
	         PreparedStatement sentencia = conexion.prepareStatement(sql);
	         ResultSet resultado = sentencia.executeQuery();

	         // Llena la tabla con los datos de la base de datos
	         while (resultado.next()) {//resultado.next trae una fila completa de la tabla 
	             int id = resultado.getInt("id");
	             String nombre= resultado.getString("nombre");
	             String email= resultado.getString("email");
	             String telefono= resultado.getString("telefono");
	             modelo.addRow(new Object[]{id,nombre,email,telefono});
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
		public void actualizarRegistroTabla(Usuario usuario) {
			try {
				this.conexion = getConnection();
				String sql = "UPDATE usuarios SET id =?,nombre=?,email=?,telefono=? WHERE id=? ";
				PreparedStatement sentencia = conexion.prepareStatement(sql);

				sentencia.setInt(1,usuario.getId());
				sentencia.setString(2, usuario.getNombre());
				sentencia.setString(3, usuario.getEmail());
				sentencia.setString(4, usuario.getTelefono());
				sentencia.setInt(5,usuario.getId());
				
				
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

		public void buscarXid(Usuario usuario) {
			try {
				this.conexion = getConnection();
				String sql = "SELECT * FROM usuarios WHERE id=?";
				PreparedStatement sentencia = conexion.prepareStatement(sql);
				sentencia.setInt(1, usuario.getId());
				ResultSet resultado = sentencia.executeQuery();
				
				if(resultado.next()) {
					usuario.setId(Integer.parseInt(resultado.getString("id")));
					usuario.setNombre(resultado.getString("nombre"));
					usuario.setEmail(resultado.getString("email"));
					usuario.setTelefono(resultado.getString("telefono"));
				}
				else {
					JOptionPane.showMessageDialog(null, "¡no existe un registro con ese id, intentalo de nuevo!");
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
		public void eliminarRegistro(Usuario usuario) {
			this.conexion=getConnection();
			String sql = " DELETE FROM usuarios WHERE id=?";
			try {
				PreparedStatement sentencia = conexion.prepareStatement(sql);
				sentencia.setInt(1, usuario.getId());
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
		public void buscarXnombre(Usuario usuario,DefaultTableModel modelo) {
			try {
				//limpio el modelo de la tabla antes de mostrar la tabla
				modelo.setRowCount(0);
				
				this.conexion = getConnection();
				String sql = "SELECT * FROM usuarios WHERE nombre=?";
				PreparedStatement sentencia = conexion.prepareStatement(sql);
				sentencia.setString(1, usuario.getNombre());
				ResultSet resultado = sentencia.executeQuery();
				
				if(resultado.next()) {
					int id=resultado.getInt("id");
					String nombre = resultado.getString("nombre");
					String email = resultado.getString("email");
					String telefono = resultado.getString("telefono");
					
					//agrega al modelo de la tabla todos los campos extraídos del resultado
					modelo.addRow(new Object[] { id, nombre,email,telefono});
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
		  public void registrarUsuario(Usuario usuario) {
		        try {
		        	this.conexion=getConnection();
		            String sql = "INSERT INTO usuarios (id,nombre, email, telefono) VALUES (?, ?, ?,?)";
		            PreparedStatement sentencia = conexion.prepareStatement(sql);
		            
		            sentencia.setInt(1, usuario.getId());
		            sentencia.setString(2, usuario.getNombre());
		            sentencia.setString(3, usuario.getEmail());
		            sentencia.setString(4, usuario.getTelefono());

		            sentencia.executeUpdate();
		            JOptionPane.showMessageDialog(null, "¡Usuario registrado correctamente!");

		            sentencia.close();
		        } catch (SQLException e) {
		            JOptionPane.showMessageDialog(null, "Error al intentar registrar usuario: " + e.getMessage());
		        }finally {
					closeConnection();
				}
		    }

}
