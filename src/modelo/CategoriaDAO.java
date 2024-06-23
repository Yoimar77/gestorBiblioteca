package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CategoriaDAO extends DatabaseConnection {
	private Connection conexion;

	public CategoriaDAO() {
	}

	// Método para cargar los productos desde la base de datos y mostrarlos en la tabla
	public void cargarProductosTabla(DefaultTableModel modelo) {
		try {
			//limpio el modelo de la tabla antes de mostrar la tabla
			modelo.setRowCount(0);
			//obtiene la conexion, del método getConnection y se la asigna a la variable conexion
			this.conexion = getConnection();
			//consulta
			String sql = "SELECT * FROM categorias";
			//prepara la conexión
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			// ya que el resultado es una tabla completa, lo almaceno en un ResultSet
			ResultSet resultado = sentencia.executeQuery();

			// Este while Llena la tabla de CategoriaView con los datos de la base de datos
			while (resultado.next()) {// resultado.next trae una fila completa de la tabla
				int id = resultado.getInt("id");//guarda el campo que trae resultado de nombre "id" en la variable id
				String nombre = resultado.getString("nombre");//guarda el campo que trae resultado de nombre "nombre" en la variable nombre
				modelo.addRow(new Object[] { id, nombre });//agrega fila por fila los componentes al modelo de la tabla
			}

			// Cierra el statement y el result set
			sentencia.close();
			resultado.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Ha ocurrido un problema al intentar mostrar la tabla: " + e.getMessage());
		} finally {//ocurra o no una excepcion, la coneccion se cierra con el método closeConnection
			closeConnection();
		}
	}

	public void actualizarRegistroTabla(Categoria categoria) {

		try {
			this.conexion = getConnection();
			String sql = "UPDATE categorias SET nombre=? WHERE id=? ";
			PreparedStatement sentencia = conexion.prepareStatement(sql);

			sentencia.setString(1, categoria.getNombre());
			sentencia.setInt(2, categoria.getId());
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

	public void buscarXid(Categoria categoria) {
		try {
			this.conexion = getConnection();
			String sql = "SELECT * FROM categorias WHERE id=?";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, categoria.getId());
			ResultSet resultado = sentencia.executeQuery();
			
			if(resultado.next()) {
				categoria.setId(Integer.parseInt(resultado.getString("id")));
				categoria.setNombre(resultado.getString("nombre"));
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
	public void eliminarRegistro(Categoria categoria) {
		this.conexion=getConnection();
		String sql = " DELETE FROM categorias WHERE id=?";
		try {
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, categoria.getId());
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
	public void buscarXnombre(Categoria categoria,DefaultTableModel modelo) {
		try {
			//limpio el modelo de la tabla antes de mostrar la tabla
			modelo.setRowCount(0);
			
			this.conexion = getConnection();
			String sql = "SELECT * FROM categorias WHERE nombre=?";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, categoria.getNombre());
			ResultSet resultado = sentencia.executeQuery();
			
			if(resultado.next()) {
				int id=resultado.getInt("id");
				String nombre = resultado.getString("nombre");
				modelo.addRow(new Object[] { id, nombre });
			}
			else {
				JOptionPane.showMessageDialog(null, "¡no existe un registro con esa categoria, intentalo de nuevo!");
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
    public void registrarCategoria(Categoria categoria) {
        try {
        	this.conexion=getConnection();
            String sql = "INSERT INTO categorias (nombre) VALUES (?)";
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, categoria.getNombre());

            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Categoría registrada correctamente!");

            sentencia.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar registrar categoría: " + e.getMessage());
        }finally {
			closeConnection();
		}
    }
	
}
