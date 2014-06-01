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
 *	Caso de uso - Buscar contacto
 */
public class CasoDeUso4 extends InterfazTests{

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
		frame.textBox("tfApellido").setText("Paredes");					
		
		frame.textBox("tfNombre").focus();							
		frame.textBox("tfNombre").setText("");
		
		frame.textBox("tfTelefono").focus();							
		frame.textBox("tfTelefono").setText("");					
		
		frame.textBox("tfEmail").focus();							
		frame.textBox("tfEmail").setText("");					
		
		frame.button("bBusca").click();									
		
		//Post Condicion
		frame.textBox("tfApellido").requireText("Paredes");
		frame.textBox("tfNombre").requireText("Antonio");
		frame.textBox("tfEmail").requireText("antonioParedes@gmail.com");
		frame.textBox("tfTelefono").requireText("654785421");
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
		frame.textBox("tfNombre").setText("Antonio");
		
		frame.textBox("tfTelefono").focus();							
		frame.textBox("tfTelefono").setText("");					
		
		frame.textBox("tfEmail").focus();							
		frame.textBox("tfEmail").setText("");					
		
		frame.button("bBusca").click();									
		
		//Post Condicion
		frame.textBox("tfApellido").requireText("Paredes");
		frame.textBox("tfNombre").requireText("Antonio");
		frame.textBox("tfEmail").requireText("antonioParedes@gmail.com");
		frame.textBox("tfTelefono").requireText("654785421");
	}
	
	@Test
	public void test3(){
		
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
		frame.textBox("tfTelefono").setText("654785421");					
		frame.textBox("tfEmail").focus();							
		frame.textBox("tfEmail").setText("");					
		
		frame.button("bBusca").click();									
		
		//Post Condicion
		frame.textBox("tfApellido").requireText("Paredes");
		frame.textBox("tfNombre").requireText("Antonio");
		frame.textBox("tfEmail").requireText("antonioParedes@gmail.com");
		frame.textBox("tfTelefono").requireText("654785421");
	}
	
	@Test
	public void test4(){
		
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
		frame.textBox("tfEmail").setText("antonioParedes@gmail.com");					
		
		frame.button("bBusca").click();									
		
		//Post Condicion
		frame.textBox("tfApellido").requireText("Paredes");
		frame.textBox("tfNombre").requireText("Antonio");
		frame.textBox("tfEmail").requireText("antonioParedes@gmail.com");
		frame.textBox("tfTelefono").requireText("654785421");
	}
	
	/**
	 * No deberia encontrar ningun contacto, sin embargo encuentra el primero
	 */
	@Test
	public void test5(){
		
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
		
		//Post Condicion
		frame.textBox("tfApellido").requireText("");
		frame.textBox("tfNombre").requireText("");
		frame.textBox("tfEmail").requireText("");
		frame.textBox("tfTelefono").requireText("");
	}
	
	@Test
	public void test6(){
		
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
		
		//Post Condicion
		frame.textBox("tfApellido").requireText("");
		frame.textBox("tfNombre").requireText("");
		frame.textBox("tfEmail").requireText("");
		frame.textBox("tfTelefono").requireText("");
	}
	
	/**
	 * @todo - Preguntar sobre las evaluaciones de busquedas
	 */
	@Test
	public void test7(){
		
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
		
		frame.textBox("tfApellido").focus();							
		frame.textBox("tfApellido").setText("Garcia");					
		frame.textBox("tfNombre").focus();								
		frame.textBox("tfNombre").setText("Antonio");					
		frame.textBox("tfTelefono").focus();							
		frame.textBox("tfTelefono").setText("954125587");				
		frame.textBox("tfEmail").focus();								
		frame.textBox("tfEmail").setText("pabloGarcia@gmail.com");	
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
		frame.textBox("tfNombre").setText("Antonio");
		frame.textBox("tfTelefono").focus();
		frame.textBox("tfTelefono").setText("");
		frame.textBox("tfEmail").focus();
		frame.textBox("tfEmail").setText("");
		
		frame.button("bBusca").click();									
		
		//Post Condicion
		frame.textBox("tfApellido").requireText("Paredes");
		frame.textBox("tfNombre").requireText("Antonio");
		frame.textBox("tfEmail").requireText("654785421");
		frame.textBox("tfTelefono").requireText("antonioParedes@gmail.com");
	}
}


