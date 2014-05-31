package tests.testsUnidad;

import static org.junit.Assert.*;

import org.junit.*;

import agenda.modelo.Campo;
import agenda.modelo.Contacto;

/**
 * 
 * @author Francisco Jesús Dominguez Ruíz
 * @author Edgar Pérez Ferrando
 */
public class ContactoTests {

	Contacto c;
	
	@Before
	public void init(){
		c = new Contacto();
		c.setValor(Campo.NOMBRE, "Antonio");
		c.setValor(Campo.APELLIDO, "Paredes");
		c.setValor(Campo.EMAIL, "tonyparedes@gmail.com");
		c.setValor(Campo.TELEFONO, "639344708");
	}
	
	@Test
	public void test1() {
		c.setValor(Campo.NOMBRE, "Pepe");
		assertEquals(c.getValor(Campo.NOMBRE), "Pepe");
	}
	
	@Test
	public void test2() {
		c.setValor(Campo.APELLIDO, "Gomez");
		assertEquals(c.getValor(Campo.APELLIDO), "Gomez");
	}
	
	@Test
	public void test3() {
		c.setValor(Campo.EMAIL, "chiki@gmail.com");
		assertEquals(c.getValor(Campo.EMAIL), "chiki@gmail.com");
	}
	
	@Test
	public void test4() {
		c.setValor(Campo.TELEFONO, "111111111");
		assertEquals(c.getValor(Campo.TELEFONO), "111111111");
	}
	
	@Test
	public void test5() {
		assertEquals(0,c.compareTo(c));
	}
	
	@Test
	public void test6() {
		Contacto c2 = new Contacto();
		c2.setValor(Campo.NOMBRE, "Antonio");
		c2.setValor(Campo.APELLIDO, "Paredes");
		c2.setValor(Campo.EMAIL, "tonyparedes@gmail.com");
		c2.setValor(Campo.TELEFONO, "639344708");
		assertEquals(0,c.compareTo(c2));
	}
	
	@Test (expected = NullPointerException.class)
	public void test7() {
		Contacto c2 = new Contacto();
		c2.setValor(Campo.NOMBRE, "Antonio");
		c2.setValor(Campo.APELLIDO, "Paredes");
		c2.setValor(Campo.EMAIL, "tonyparedes@gmail.com");
		c.compareTo(c2);
	}
	
	@Test
	public void test8(){
		assertEquals(c.toString(),"contacto(Antonio, Paredes, tonyparedes@gmail.com, 639344708)");
	}
	
	@Test
	public void test9(){
		Contacto c2 = new Contacto();
		c2.setValor(Campo.APELLIDO, "Paredes");
		c2.setValor(Campo.TELEFONO, "639344708");
		assertEquals(c2.toString(),"contacto(null, Paredes, null, 639344708)");
	}
	
	@Test
	public void test10(){
		Contacto c2 = new Contacto();
		c2.setValor(Campo.NOMBRE, "Antonio1");
		c2.setValor(Campo.APELLIDO, "Paredes");
		c2.setValor(Campo.EMAIL, "tonyparedes@gmail.com");
		c2.setValor(Campo.TELEFONO, "639344708");
		
		assertNotEquals(0,c2.toString());
	}

	@Test
	public void test11(){
		Contacto c2 = new Contacto();
		c2.setValor(Campo.NOMBRE, "Antonio");
		c2.setValor(Campo.APELLIDO, "Paredes1");
		c2.setValor(Campo.EMAIL, "tonyparedes@gmail.com");
		c2.setValor(Campo.TELEFONO, "639344708");
		
		assertNotEquals(0,c2.toString());
	}
	
	@Test
	public void test12(){
		Contacto c2 = new Contacto();
		c2.setValor(Campo.NOMBRE, "Antonio");
		c2.setValor(Campo.APELLIDO, "Paredes");
		c2.setValor(Campo.EMAIL, "tonyparedes1@gmail.com");
		c2.setValor(Campo.TELEFONO, "639344708");
		
		assertNotEquals(0,c2.toString());
	}
	
	@Test
	public void test13(){
		Contacto c2 = new Contacto();
		c2.setValor(Campo.NOMBRE, "Antonio");
		c2.setValor(Campo.APELLIDO, "Paredes");
		c2.setValor(Campo.EMAIL, "tonyparedes@gmail.com");
		c2.setValor(Campo.TELEFONO, "639344707");
		
		assertNotEquals(0,c2.toString());
	}
	
	@Test
	public void test14(){
		Contacto c1 = new Contacto();
		c1.setValor(Campo.NOMBRE, "Antonio");
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.EMAIL, "tonyparedes@gmail.com");
		c1.setValor(Campo.TELEFONO, "639344707");
		
		Contacto c2 = new Contacto();
		c2.setValor(Campo.NOMBRE, "Antonio");
		c2.setValor(Campo.APELLIDO, "Paredes");
		c2.setValor(Campo.EMAIL, "tonyparedes@gmail.com");
		c2.setValor(Campo.TELEFONO, "639344707");
		
		assertEquals(c1.hashCode(), c2.hashCode());
	}
	
	@Test
	public void test15(){
		Contacto c1 = new Contacto();
		c1.setValor(Campo.NOMBRE, "Antonio");
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.EMAIL, "tonyparedes@gmail.com");
		c1.setValor(Campo.TELEFONO, "639344707");
		
		Contacto c2 = new Contacto();
		c2.setValor(Campo.NOMBRE, "Antonio");
		c2.setValor(Campo.APELLIDO, "Paredes");
		c2.setValor(Campo.EMAIL, "tonyparedes@gmail.com");
		c2.setValor(Campo.TELEFONO, "154785");
		
		assertNotEquals(c1.hashCode(), c2.hashCode());
	}

	@Test
	public void test16(){
		Contacto c1 = new Contacto();
		c1.setValor(Campo.NOMBRE, "Antonio");
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.EMAIL, "tonyparedes@gmail.com");
		c1.setValor(Campo.TELEFONO, "639344707");
		
		Contacto c2 = new Contacto();
		c2.setValor(Campo.NOMBRE, "Antonio");
		c2.setValor(Campo.APELLIDO, "Paredes");
		c2.setValor(Campo.EMAIL, "tonyparedes@gmail.com");
		c2.setValor(Campo.TELEFONO, "154785");
		
		assertFalse(c1.equals(c2));
	}

	@Test
	public void test17(){
		Contacto c1 = new Contacto();
		c1.setValor(Campo.NOMBRE, "Antonio");
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.EMAIL, "tonyparedes@gmail.com");
		c1.setValor(Campo.TELEFONO, "639344707");
		
		Contacto c2 = new Contacto();
		c2.setValor(Campo.NOMBRE, "Antonio");
		c2.setValor(Campo.APELLIDO, "Paredes");
		c2.setValor(Campo.EMAIL, "tonyparedes@gmail.com");
		c2.setValor(Campo.TELEFONO, "639344707");
		
		assertTrue(c1.equals(c2));
	}
	
	@Test(expected = Exception.class)
	public void test18(){
		Contacto c1 = new Contacto();
		c1.setValor(null, "Antonio");
		c1.setValor(Campo.APELLIDO, "Paredes");
		c1.setValor(Campo.EMAIL, "tonyparedes@gmail.com");
		c1.setValor(Campo.TELEFONO, "639344707");
	}

}
