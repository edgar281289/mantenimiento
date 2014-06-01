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
 *	Caso de uso - Resetea agenda
 */
public class CasoDeUso2 extends InterfazTests{

	@Test
	public void test1(){
		
		//Pre Condicion
		frame.textBox("tfApellido").requireText("");
		frame.textBox("tfNombre").requireText("");
		frame.textBox("tfEmail").requireText("");
		frame.textBox("tfTelefono").requireText("");
		
		// Proceso
		frame.button("bResetea").click();  //1
		
		//Post Condicion
		GenericTypeMatcher<JTextArea> matcher= new GenericTypeMatcher<JTextArea>(JTextArea.class) {
			@Override
			protected boolean isMatching(JTextArea component) {
		      return true;
			}	
		};
		
		frame.textBox(matcher).requireText("");
		frame.textBox("tfApellido").requireText("");
		frame.textBox("tfNombre").requireText("");
		frame.textBox("tfTelefono").requireText("");
		frame.textBox("tfEmail").requireText("");
	}
	
	@Test
	public void test2(){
		
		//Pre Condicion
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
		frame.button("bResetea").click();
		
		//Post Condicion
		GenericTypeMatcher<JTextArea> matcher= new GenericTypeMatcher<JTextArea>(JTextArea.class) {
			@Override
			protected boolean isMatching(JTextArea component) {
		      return true;
			}	
		};
		
		frame.textBox(matcher).requireText("");
		frame.textBox("tfApellido").requireText("");
		frame.textBox("tfNombre").requireText("");
		frame.textBox("tfTelefono").requireText("");
		frame.textBox("tfEmail").requireText("");
	}
	
	@Test
	public void test3(){
		
		//Pre Condicion
		frame.textBox("tfApellido").focus();							
		frame.textBox("tfApellido").setText("Paredes");					
		frame.textBox("tfNombre").focus();								
		frame.textBox("tfNombre").setText("Antonio");					
		frame.textBox("tfTelefono").focus();							
		frame.textBox("tfTelefono").setText("654785421");				
		frame.textBox("tfEmail").focus();								
		frame.textBox("tfEmail").setText("antonioParedes@gmail.com");	
		frame.button("bAnade").click();
		
		frame.textBox("tfApellido").focus();							
		frame.textBox("tfApellido").setText("Paredes 2");					
		frame.textBox("tfNombre").focus();								
		frame.textBox("tfNombre").setText("Antonio 2");					
		frame.textBox("tfTelefono").focus();							
		frame.textBox("tfTelefono").setText("654785422");				
		frame.textBox("tfEmail").focus();								
		frame.textBox("tfEmail").setText("antonioParedes2@gmail.com");	
		frame.button("bAnade").click();
		
		// Proceso
		frame.button("bResetea").click();
		
		//Post Condicion
		GenericTypeMatcher<JTextArea> matcher= new GenericTypeMatcher<JTextArea>(JTextArea.class) {
			@Override
			protected boolean isMatching(JTextArea component) {
		      return true;
			}	
		};
		
		frame.textBox(matcher).requireText("");
		frame.textBox("tfApellido").requireText("");
		frame.textBox("tfNombre").requireText("");
		frame.textBox("tfTelefono").requireText("");
		frame.textBox("tfEmail").requireText("");
	}
}

