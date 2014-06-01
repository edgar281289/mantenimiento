package tests.testsIntegridad;

import java.awt.event.ActionEvent;
import org.junit.Test;
import static org.mockito.Mockito.*;
import agenda.modelo.Agenda;
import agenda.modelo.Campo;
import agenda.modelo.Contacto;
import agenda.vista.AgendaCtrl;
import agenda.vista.AgendaPanel;

/**
 * 
 * @author Francisco Jesús Dominguez Ruíz
 * @author Edgar Pérez Ferrando
 *
 */
public class testsIntegridad {

	Agenda modelo ;
	AgendaCtrl controlador;
	AgendaPanel vista;
	
	@Test
	public void test1() {
		modelo = spy(new Agenda());
		vista = spy(new AgendaPanel());
		controlador = spy(new AgendaCtrl(vista,modelo));
		vista.controlador(controlador);
		
		ActionEvent e = mock(ActionEvent.class);
		when(e.getActionCommand()).thenReturn(vista.ANADE);
		
		controlador.actionPerformed(e);
		
		verify(modelo).anadeContacto(any(Contacto.class));
		verify(vista).muestraContactos(anyString());
		verify(vista).leeDatos();
	}

	@Test
	public void test2() {
		modelo = spy(new Agenda());
		vista = spy(new AgendaPanel());
		controlador = spy(new AgendaCtrl(vista,modelo));
		vista.controlador(controlador);
		
		ActionEvent e = mock(ActionEvent.class);
		when(e.getActionCommand()).thenReturn(vista.BORRA);
		
		controlador.actionPerformed(e);

		verify(vista).leeDatos();
		verify(modelo).borraContacto(any(Contacto.class));
		verify(vista).borraContacto();
		verify(vista).muestraContactos(anyString());
		}
		
	@Test
	public void test3() {
		modelo = spy(new Agenda());
		vista = spy(new AgendaPanel());
		controlador = spy(new AgendaCtrl(vista,modelo));
		vista.controlador(controlador);
		
		ActionEvent e = mock(ActionEvent.class);
		when(e.getActionCommand()).thenReturn(vista.BUSCA);
		
		controlador.actionPerformed(e);

		verify(vista).leeDatos();
		verify(modelo).buscaContacto(anyMapOf(Campo.class, String.class));
		verify(vista,never()).muestraContactos(anyString());
	}
	
	
	@Test
	public void test4() {
		modelo = spy(new Agenda());
		vista = spy(new AgendaPanel());
		controlador = spy(new AgendaCtrl(vista,modelo));
		vista.controlador(controlador);
		
		ActionEvent e = mock(ActionEvent.class);
		when(e.getActionCommand()).thenReturn(vista.RESETEA);
		
		controlador.actionPerformed(e);
		
		verify(vista).muestraContactos("");
		verify(vista).borraContacto();
		verify(modelo).reset();
		
	}
	
	@Test//(expected = IllegalArgumentException.class)
	public void test5() {
		Contacto c = new Contacto();
		c.setValor(Campo.NOMBRE, "Antonio");
		c.setValor(Campo.APELLIDO, "Paredes");
		c.setValor(Campo.EMAIL, "tonyparedes@gmail.com");
		c.setValor(Campo.TELEFONO, "639344708");
		
		modelo = spy(new Agenda());
		vista = spy(new AgendaPanel());
		controlador = spy(new AgendaCtrl(vista,modelo));
		vista.controlador(controlador);
		
		modelo.anadeContacto(c);
		
		ActionEvent e = mock(ActionEvent.class);
		when(e.getActionCommand()).thenReturn(vista.ANADE);
		
		when(vista.leeDatos()).thenReturn(c.getDatos());
		
		controlador.actionPerformed(e);
		
		verify(modelo,times(2)).anadeContacto(any(Contacto.class));
		verify(vista).leeDatos();
		verify(vista,never()).muestraContactos(anyString());
	}
	
	@Test //(expected = IllegalArgumentException.class)
	public void test6() {
		Contacto c = new Contacto();
		c.setValor(Campo.NOMBRE, "Antonio");
		c.setValor(Campo.APELLIDO, "Paredes");
		c.setValor(Campo.EMAIL, "tonyparedes@gmail.com");
		c.setValor(Campo.TELEFONO, "639344708");
		
		modelo = spy(new Agenda());
		vista = spy(new AgendaPanel());
		controlador = spy(new AgendaCtrl(vista,modelo));
		vista.controlador(controlador);
		
		modelo.anadeContacto(c);
		
		ActionEvent e = mock(ActionEvent.class);
		when(e.getActionCommand()).thenReturn(vista.BUSCA);
		
		when(vista.leeDatos()).thenReturn(c.getDatos());
		
		controlador.actionPerformed(e);
		
		verify(vista).leeDatos();
		verify(modelo).buscaContacto(anyMapOf(Campo.class, String.class));
		verify(vista).muestraContacto(any(Contacto.class));
	}
}
