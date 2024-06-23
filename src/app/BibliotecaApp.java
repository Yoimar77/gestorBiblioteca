package app;

import controlador.CategoriaController;
import controlador.LibroController;
import controlador.PrestamoController;
import controlador.UsuarioController;
import controlador.VentanaInicialController;
import modelo.Categoria;
import modelo.CategoriaDAO;
import modelo.Libro;
import modelo.LibroDAO;
import modelo.Prestamo;
import modelo.PrestamoDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.CategoriaView;
import vista.LibroView;
import vista.ModificarCategoriaView;
import vista.ModificarLibroView;
import vista.ModificarPrestamoView;
import vista.ModificarUsuarioView;
import vista.PrestamoView;
import vista.RegistroCategoriaView;
import vista.RegistroLibroView;
import vista.RegistroPrestamoView;
import vista.RegistroUsuarioView;
import vista.UsuarioView;
import vista.VentanaInicialView;

public class BibliotecaApp {
	public static void main(String[] args) {
		
		VentanaInicialView inicial = new VentanaInicialView();
		
		//instancias necesarias de categoría
		CategoriaView cv = new CategoriaView();
		Categoria c = new Categoria();
		CategoriaDAO cd = new CategoriaDAO();
		RegistroCategoriaView rc = new RegistroCategoriaView();
		ModificarCategoriaView mc = new ModificarCategoriaView();
		CategoriaController cc = new CategoriaController(cv,cd,c,rc,mc,inicial);
		//instancias necesarias de Usuario
		UsuarioView uv = new UsuarioView();
		Usuario u = new Usuario();
		UsuarioDAO ud= new UsuarioDAO ();
		RegistroUsuarioView ru= new RegistroUsuarioView();
		ModificarUsuarioView mu = new ModificarUsuarioView();
		UsuarioController uc = new UsuarioController(uv,ud,u,ru,mu,inicial);
		//instancias necesarias de Prestamo
		PrestamoView pv = new PrestamoView();
		Prestamo p = new Prestamo();
		PrestamoDAO pd= new PrestamoDAO ();
		RegistroPrestamoView rp= new RegistroPrestamoView();
		ModificarPrestamoView mp = new ModificarPrestamoView();
		PrestamoController pc = new PrestamoController(pv,pd,p,rp,mp, inicial);
		//instancias necesarias de Libro
		LibroView lv = new LibroView();
		Libro l = new Libro();
		LibroDAO ld= new LibroDAO ();
		RegistroLibroView rl= new RegistroLibroView();
		ModificarLibroView ml = new ModificarLibroView();
		LibroController lc = new LibroController(lv,ld,l,rl,ml,inicial);
		//instancias necesarias ventanaInicial
		
		VentanaInicialController vin =new VentanaInicialController(inicial,cv,uv,pv,lv);
		inicial.setVisible(true);	
	}
}
