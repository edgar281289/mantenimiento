package tests.testsUnidad;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import agenda.modelo.Agenda;
import agenda.modelo.Campo;
import agenda.modelo.Contacto;

/**
 * 
 * @author Francisco Jesús Dominguez Ruíz
 * @author Edgar Pérez Ferrando
 */
public class AgendaTest {
	
	Agenda a;
	Contacto c1;
	Contacto c2;
	
	@Before
	public void init(){
		a = new Agenda();
	}
	
	@Test (expected = IllegalArgumentException.class)//Compruebo que no se puede añadir dos contactos iguales
	public void test1() {
		c1= new Contacto();
		c2= new Contacto();
		c1.setValor(Campo.NOMBRE, "Antonio");
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.EMAIL, "tony@gmail.com");
		c1.setValor(Campo.TELEFONO, "99999999");
		c2.setValor(Campo.NOMBRE, "Antonio");
		c2.setValor(Campo.APELLIDO, "Paredes");
		c2.setValor(Campo.EMAIL, "tony@gmail.com");
		c2.setValor(Campo.TELEFONO, "99999999");
		a.anadeContacto(c1);
		a.anadeContacto(c2);
	}
	
	@Test(expected = NullPointerException.class)//Compruebo que no se puede meter ningun contacto sin telefono definidos
	public void test2(){
		c1= new Contacto();
		c2= new Contacto();
		c1.setValor(Campo.NOMBRE, "Antonio");
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.EMAIL, "tony@gmail.com");
		a.anadeContacto(c1);
	}
	
	@Test(expected = NullPointerException.class)//Compruebo que ninguno de los campos puede ser null
	public void test3(){
		c1= new Contacto();
		c2= new Contacto();
		c1.setValor(Campo.NOMBRE, null);
		c1.setValor(Campo.APELLIDO, null);
		c1.setValor(Campo.EMAIL, null);
		c1.setValor(Campo.TELEFONO, null);
		a.anadeContacto(c1);
	}
	
	@Test
	public void test4(){//Compruebo el toString con un contacto
		c1= new Contacto();
		c2= new Contacto();
		c1.setValor(Campo.NOMBRE, "Antonio");
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.EMAIL, "tony@gmail.com");
		c1.setValor(Campo.TELEFONO, "99999999");
		a.anadeContacto(c1);
		assertEquals("agenda(contacto(Antonio, Paredes, tony@gmail.com, 99999999))",a.toString());
	}
	@Test
	public void test5(){//Compruebo el toString con más de un contacto
		c1= new Contacto();
		c2= new Contacto();
		c1.setValor(Campo.NOMBRE, "Antonio");
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.EMAIL, "tony@gmail.com");
		c1.setValor(Campo.TELEFONO, "99999999");
		c2.setValor(Campo.NOMBRE, "Pepe");
		c2.setValor(Campo.APELLIDO, "Paredes");
		c2.setValor(Campo.EMAIL, "tony@gmail.com");
		c2.setValor(Campo.TELEFONO, "99999999");
		a.anadeContacto(c1);
		a.anadeContacto(c2);
		assertEquals("agenda(contacto(Antonio, Paredes, tony@gmail.com, 99999999), " +
				"contacto(Pepe, Paredes, tony@gmail.com, 99999999))",a.toString());
	}
	
	@Test
	public void test6(){//Compruebo que funciona el iterator
		c1= new Contacto();
		c2= new Contacto();
		c1.setValor(Campo.NOMBRE, "Antonio");
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.EMAIL, "tony@gmail.com");
		c1.setValor(Campo.TELEFONO, "99999999");
		c2.setValor(Campo.NOMBRE, "Pepe");
		c2.setValor(Campo.APELLIDO, "Paredes");
		c2.setValor(Campo.EMAIL, "tony@gmail.com");
		c2.setValor(Campo.TELEFONO, "99999999");
		Contacto [] c = new Contacto[2];
		c[0]=c1;
		c[1]=c2;
		a.anadeContacto(c1);
		a.anadeContacto(c2);
		Iterator<Contacto> iter = a.iterator();
		int tam=0;
		while(iter.hasNext()){
			assertEquals(iter.next(),c[tam]);
			tam++;
		}
		assertEquals(tam,2);
	}
	
	@Test 
	public void test7(){
		c1 = new Contacto();
		c2= new Contacto();
		c1.setValor(Campo.NOMBRE, "Antonio");
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.EMAIL, "tony@gmail.com");
		c1.setValor(Campo.TELEFONO, "99999999");
		c2.setValor(Campo.NOMBRE, "Pepe");
		c2.setValor(Campo.APELLIDO, "Paredes");
		c2.setValor(Campo.EMAIL, "tony@gmail.com");
		c2.setValor(Campo.TELEFONO, "99999999");
		a.anadeContacto(c1);
		assertNotSame(a.buscaContacto(c1.getDatos()),null);
		assertEquals(a.buscaContacto(c1.getDatos()),c1);
	}
	
	@Test 
	public void test8(){
		c1 = new Contacto();
		c2= new Contacto();
		c1.setValor(Campo.NOMBRE, "Antonio");
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.EMAIL, "tony@gmail.com");
		c1.setValor(Campo.TELEFONO, "99999999");
		c2.setValor(Campo.NOMBRE, "Pepe");
		c2.setValor(Campo.APELLIDO, "Paredes");
		c2.setValor(Campo.EMAIL, "tony@gmail.com");
		c2.setValor(Campo.TELEFONO, "99999999");
		a.anadeContacto(c1);
		assertEquals(a.buscaContacto(c2.getDatos()),null);
		assertNotSame(a.buscaContacto(c2.getDatos()),c1);
	}
	@Test 
	public void test9(){
		Map<Campo,String>dato = new HashMap<Campo,String>();
		dato.put(Campo.APELLIDO, "Paredes");
		c1 = new Contacto();
		c2= new Contacto();
		c1.setValor(Campo.NOMBRE, "Antonio");
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.EMAIL, "tony@gmail.com");
		c1.setValor(Campo.TELEFONO, "99999999");
		c2.setValor(Campo.NOMBRE, "Pepe");
		c2.setValor(Campo.APELLIDO, "Paredes");
		c2.setValor(Campo.EMAIL, "tony@gmail.com");
		c2.setValor(Campo.TELEFONO, "99999999");
		a.anadeContacto(c1);
		a.anadeContacto(c2);
		assertEquals(a.buscaContacto(dato),c1);
		assertNotSame(dato,null);
	}
	@Test 
	public void test10(){
		Map<Campo,String>dato = new HashMap<Campo,String>();
		dato.put(Campo.APELLIDO, "Paredes");
		c1 = new Contacto();
		c2= new Contacto();
		c1.setValor(Campo.NOMBRE, "Antonio");
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.EMAIL, "tony@gmail.com");
		c1.setValor(Campo.TELEFONO, "99999999");
		c2.setValor(Campo.NOMBRE, "Pepe");
		c2.setValor(Campo.APELLIDO, "Paredes");
		c2.setValor(Campo.EMAIL, "tony@gmail.com");
		c2.setValor(Campo.TELEFONO, "99999999");
		a.anadeContacto(c2);
		a.anadeContacto(c1);
		assertEquals(a.buscaContacto(dato),c1);
		assertNotSame(dato,null);
	}
	@Test 
	public void test11(){
		c1 = new Contacto();
		c2= new Contacto();
		c1.setValor(Campo.NOMBRE, "Antonio");
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.EMAIL, "tony@gmail.com");
		c1.setValor(Campo.TELEFONO, "99999999");
		c2.setValor(Campo.NOMBRE, "Pepe");
		c2.setValor(Campo.APELLIDO, "Paredes");
		c2.setValor(Campo.EMAIL, "tony@gmail.com");
		c2.setValor(Campo.TELEFONO, "99999999");
		a.anadeContacto(c1);
		a.borraContacto(c1);
		assertEquals(a.buscaContacto(c1.getDatos()), null);
	}
	@Test 
	public void test12(){
		c1 = new Contacto();
		c2= new Contacto();
		c1.setValor(Campo.NOMBRE, "Antonio");
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.EMAIL, "tony@gmail.com");
		c1.setValor(Campo.TELEFONO, "99999999");
		c2.setValor(Campo.NOMBRE, "Pepe");
		c2.setValor(Campo.APELLIDO, "Paredes");
		c2.setValor(Campo.EMAIL, "tony@gmail.com");
		c2.setValor(Campo.TELEFONO, "99999999");
		a.anadeContacto(c1);
		a.anadeContacto(c2);
		a.reset();
		assertEquals(a.buscaContacto(c1.getDatos()), null);
		assertEquals(a.buscaContacto(c2.getDatos()), null);
	}
	
	/**
	 * No se permite tener dos contactos iguales en la agenda
	 * Se han insertado 2 contactos diferentes y a continuación se modifico uno para ser igual al primero.
	 * Según se entiende, no se pueden AÑADIR dos contactos iguales, lo que da a entender que aun modificando,
	 * no deben existir en la agenda dos contactos similares.
	 * 
	 * Se espera una excepción anunciando del evento.
	 */
	@Test (expected = Exception.class)
	public void test13(){
		c1 = new Contacto();
		c2= new Contacto();
		c1.setValor(Campo.NOMBRE, "Antonio");
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.EMAIL, "tony@gmail.com");
		c1.setValor(Campo.TELEFONO, "99999999");
		c2.setValor(Campo.NOMBRE, "Pepe");
		c2.setValor(Campo.APELLIDO, "Paredes");
		c2.setValor(Campo.EMAIL, "tony@gmail.com");
		c2.setValor(Campo.TELEFONO, "99999999");
		
		a.anadeContacto(c1);
		a.anadeContacto(c2);
		
		a.cambiaContacto(c2, Campo.NOMBRE, "Antonio");
		assertEquals(a.buscaContacto(c1.getDatos()), a.buscaContacto(c2.getDatos()));
		
	}
	
	/**
	 * Esperamos que no se pueda insertar un contacto en la agenda con todos los campos vacios
	 */
	@Test(expected = Exception.class)
	public void test14(){
		c1= new Contacto();
		c1.setValor(Campo.NOMBRE, "");
		c1.setValor(Campo.APELLIDO, "");
		c1.setValor(Campo.EMAIL, "");
		c1.setValor(Campo.TELEFONO, "");
		a.anadeContacto(c1);
	}

	@Test(expected = NullPointerException.class)//Compruebo que no se puede meter ningun contacto sin nombre definidos
	public void test15(){
		c1= new Contacto();
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.EMAIL, "tony@gmail.com");
		c1.setValor(Campo.TELEFONO, "954785214");
		a.anadeContacto(c1);
	}
	
	@Test(expected = NullPointerException.class)//Compruebo que no se puede meter ningun contacto sin apellidos definidos
	public void test16(){
		c1= new Contacto();
		c1.setValor(Campo.NOMBRE, "Antonio");
		c1.setValor(Campo.EMAIL, "tony@gmail.com");
		c1.setValor(Campo.TELEFONO, "954785214");
		a.anadeContacto(c1);
	}

	@Test(expected = NullPointerException.class)//Compruebo que no se puede meter ningun contacto sin email definido
	public void test17(){
		c1= new Contacto();
		c1.setValor(Campo.NOMBRE, "Antonio");
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.TELEFONO, "954785214");
		a.anadeContacto(c1);
	}
	
	@Test(expected = NullPointerException.class)
	public void test18(){
		c1= new Contacto();
		c1.setValor(null, "Antonio");
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.TELEFONO, "954785214");
		a.anadeContacto(c1);
	}
	
	/**
	 * Borramos un contacto que no existe, no esperamos respuesta
	 */
	@Test
	public void test19(){
		c1= new Contacto();
		c1.setValor(null, "Antonio");
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.TELEFONO, "954785214");
		a.borraContacto(c1);
	}	
}
