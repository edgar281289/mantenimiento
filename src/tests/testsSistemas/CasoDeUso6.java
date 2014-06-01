package tests.testsSistemas;

import static org.junit.Assert.*;

import javax.swing.JTextArea;

import org.fest.swing.core.GenericTypeMatcher;
import org.junit.Test;

/**
 * 
 * @author Francisco Jesús Dominguez Ruíz
 * @author Edgar Pérez Ferrando
 *
 *	Caso de uso - Ventana de error en Busquedas (Repetir contacto)
 */
public class CasoDeUso6 extends InterfazTests{

	@Test
	public void test1(){
		
		//Pre Condicion
		frame.textBox("tfApellido").requireText("");
		frame.textBox("tfNombre").requireText("");
		frame.textBox("tfEmail").requireText("");
		frame.textBox("tfTelefono").requireText("");
		
		frame.textBox("tfApellido").focus();							
		frame.textBox("tfApellido").setText("Paredes");					
		frame.textBox("tfNombre").focus();								
		frame.textBox("tfNombre").setText("Antonio");					
		frame.textBox("tfTelefono").focus();							
		frame.textBox("tfTelefono").setText("654785421");				
		frame.textBox("tfEmail").focus();								
		frame.textBox("tfEmail").setText("antonioParedes@gmail.com");	
		frame.button("bAnade").click();									
		
		// Proceso
		GenericTypeMatcher<JTextArea> matcher= new GenericTypeMatcher<JTextArea>(JTextArea.class) {
			@Override
			protected boolean isMatching(JTextArea component) {
		      return true;
			}				

		};
		frame.textBox(matcher).requireText("   Antonio   ParedesantonioParedes@gmail.com 654785421\n");
		
		frame.textBox("tfApellido").focus();
		frame.textBox("tfApellido").setText("");
		frame.textBox("tfNombre").focus();
		frame.textBox("tfNombre").setText("Edgar");
		frame.textBox("tfTelefono").focus();
		frame.textBox("tfTelefono").setText("");
		frame.textBox("tfEmail").focus();
		frame.textBox("tfEmail").setText("");
		
		frame.button("bBusca").click();									
		
		frame.optionPane().requireErrorMessage().requireMessage("No existe contacto con esos datos");
		frame.optionPane().button().click();
		
		//Post Condicion
		frame.textBox("tfApellido").requireText("");
		frame.textBox("tfNombre").requireText("Edgar");
		frame.textBox("tfEmail").requireText("");
		frame.textBox("tfTelefono").requireText("");
	}
	
	@Test
	public void test2(){
		
		//Pre Condicion
		frame.textBox("tfApellido").requireText("");
		frame.textBox("tfNombre").requireText("");
		frame.textBox("tfEmail").requireText("");
		frame.textBox("tfTelefono").requireText("");
		
		frame.textBox("tfApellido").focus();							
		frame.textBox("tfApellido").setText("Paredes");					
		frame.textBox("tfNombre").focus();								
		frame.textBox("tfNombre").setText("Antonio");					
		frame.textBox("tfTelefono").focus();							
		frame.textBox("tfTelefono").setText("654785421");				
		frame.textBox("tfEmail").focus();								
		frame.textBox("tfEmail").setText("antonioParedes@gmail.com");	
		frame.button("bAnade").click();									
		
		// Proceso
		GenericTypeMatcher<JTextArea> matcher= new GenericTypeMatcher<JTextArea>(JTextArea.class) {
			@Override
			protected boolean isMatching(JTextArea component) {
		      return true;
			}				

		};
		frame.textBox(matcher).requireText("   Antonio   ParedesantonioParedes@gmail.com 654785421\n");
		
		frame.textBox("tfApellido").focus();
		frame.textBox("tfApellido").setText("");
		frame.textBox("tfNombre").focus();
		frame.textBox("tfNombre").setText("");
		frame.textBox("tfTelefono").focus();
		frame.textBox("tfTelefono").setText("");
		frame.textBox("tfEmail").focus();
		frame.textBox("tfEmail").setText("");
		
		frame.button("bBusca").click();									
		
		frame.optionPane().requireErrorMessage().requireMessage("No existe contacto con esos datos");
		frame.optionPane().button().click();
		
		//Post Condicion
		frame.textBox("tfApellido").requireText("");
		frame.textBox("tfNombre").requireText("");
		frame.textBox("tfEmail").requireText("");
		frame.textBox("tfTelefono").requireText("");
	}
}


