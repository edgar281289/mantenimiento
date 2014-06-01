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
 *	Caso de uso - Añadir contacto
 */
public class CasoDeUso1 extends InterfazTests{

	@Test
	public void test1(){
		
		//Pre Condicion
		frame.textBox("tfApellido").requireText("");
		frame.textBox("tfNombre").requireText("");
		frame.textBox("tfEmail").requireText("");
		frame.textBox("tfTelefono").requireText("");
		
		// Proceso
		frame.textBox("tfApellido").focus();							//1
		frame.textBox("tfApellido").setText("Paredes");					//2
		
		frame.textBox("tfNombre").focus();								//3
		frame.textBox("tfNombre").setText("Antonio");					//4
		
		frame.textBox("tfTelefono").focus();							//5
		frame.textBox("tfTelefono").setText("654785421");				//6
		
		frame.textBox("tfEmail").focus();								//7
		frame.textBox("tfEmail").setText("antonioParedes@gmail.com");	//8
		
		frame.button("bAnade").click();									//9
		
		//Post Condicion
		GenericTypeMatcher<JTextArea> matcher= new GenericTypeMatcher<JTextArea>(JTextArea.class) {
			@Override
			protected boolean isMatching(JTextArea component) {
		      return true;
			}				

		};
		// Preguntar - Prueba sobre el formato de contactos
		frame.textBox(matcher).requireText(" \n");
	}
	
	@Test
	public void test2(){
		
		//Pre Condicion
		frame.textBox("tfApellido").requireText("");
		frame.textBox("tfNombre").requireText("");
		frame.textBox("tfEmail").requireText("");
		frame.textBox("tfTelefono").requireText("");
		
		// Proceso
		frame.textBox("tfNombre").focus();								//3
		frame.textBox("tfNombre").setText("Antonio");					//4
		
		frame.textBox("tfApellido").focus();							//1
		frame.textBox("tfApellido").setText("Paredes");					//2
				
		frame.textBox("tfTelefono").focus();							//5
		frame.textBox("tfTelefono").setText("654785421");				//6
		
		frame.textBox("tfEmail").focus();								//7
		frame.textBox("tfEmail").setText("antonioParedes@gmail.com");	//8
		
		frame.button("bAnade").click();									//9
		
		//Post Condicion
		GenericTypeMatcher<JTextArea> matcher= new GenericTypeMatcher<JTextArea>(JTextArea.class) {
			@Override
			protected boolean isMatching(JTextArea component) {
		      return true;
			}				

		};
		// Preguntar - Prueba sobre el formato de contactos
		frame.textBox(matcher).requireText("   Antonio   ParedesantonioParedes@gmail.com 654785421\n");
	}
	
	@Test
	public void test3(){
		
		//Pre Condicion
		frame.textBox("tfApellido").requireText("");
		frame.textBox("tfNombre").requireText("");
		frame.textBox("tfEmail").requireText("");
		frame.textBox("tfTelefono").requireText("");
		
		// Proceso
		frame.textBox("tfNombre").focus();								//3
		frame.textBox("tfNombre").setText("Antonio");					//4
						
		frame.textBox("tfTelefono").focus();							//5
		frame.textBox("tfTelefono").setText("654785421");				//6
		
		frame.textBox("tfEmail").focus();								//7
		frame.textBox("tfEmail").setText("antonioParedes@gmail.com");	//8
		
		frame.textBox("tfApellido").focus();							//1
		frame.textBox("tfApellido").setText("Paredes");					//2
		
		frame.button("bAnade").click();									//9
		
		//Post Condicion
		GenericTypeMatcher<JTextArea> matcher= new GenericTypeMatcher<JTextArea>(JTextArea.class) {
			@Override
			protected boolean isMatching(JTextArea component) {
		      return true;
			}				

		};
		// Preguntar - Prueba sobre el formato de contactos
		frame.textBox(matcher).requireText("   Antonio   ParedesantonioParedes@gmail.com 654785421\n");
	}
	
	@Test
	public void test4(){
		
		//Pre Condicion
		frame.textBox("tfApellido").requireText("");
		frame.textBox("tfNombre").requireText("");
		frame.textBox("tfEmail").requireText("");
		frame.textBox("tfTelefono").requireText("");
		
		// Proceso
		frame.textBox("tfNombre").focus();								//3
		frame.textBox("tfNombre").setText("Antonio");					//4
						
		frame.textBox("tfTelefono").focus();							//5
		frame.textBox("tfTelefono").setText("654785421");				//6
		
		frame.textBox("tfApellido").focus();							//1
		frame.textBox("tfApellido").setText("Paredes");					//2
		
		frame.textBox("tfEmail").focus();								//7
		frame.textBox("tfEmail").setText("antonioParedes@gmail.com");	//8
		
		frame.button("bAnade").click();									//9
		
		//Post Condicion
		GenericTypeMatcher<JTextArea> matcher= new GenericTypeMatcher<JTextArea>(JTextArea.class) {
			@Override
			protected boolean isMatching(JTextArea component) {
		      return true;
			}				

		};
		// Preguntar - Prueba sobre el formato de contactos
		frame.textBox(matcher).requireText("   Antonio   ParedesantonioParedes@gmail.com 654785421\n");
	}
	
	@Test
	public void test5(){
		
		//Pre Condicion
		frame.textBox("tfApellido").requireText("");
		frame.textBox("tfNombre").requireText("");
		frame.textBox("tfEmail").requireText("");
		frame.textBox("tfTelefono").requireText("");
		
		// Proceso										
		frame.textBox("tfApellido").focus();							//1
		frame.textBox("tfApellido").setText("Paredes");					//2
		
		frame.button("bAnade").click();									//9
		
		//Post Condicion
		GenericTypeMatcher<JTextArea> matcher= new GenericTypeMatcher<JTextArea>(JTextArea.class) {
			@Override
			protected boolean isMatching(JTextArea component) {
		      return true;
			}				

		};
		// Preguntar - Prueba sobre el formato de contactos
		frame.textBox(matcher).requireText("             Paredes                    \n");
	}
	
	@Test
	public void test6(){
		
		//Pre Condicion
		frame.textBox("tfApellido").requireText("");
		frame.textBox("tfNombre").requireText("");
		frame.textBox("tfEmail").requireText("");
		frame.textBox("tfTelefono").requireText("");
		
		// Proceso										
		frame.textBox("tfNombre").focus();				//1
		frame.textBox("tfNombre").setText("Antonio");	//2
		
		frame.button("bAnade").click();					//9
		
		//Post Condicion
		GenericTypeMatcher<JTextArea> matcher= new GenericTypeMatcher<JTextArea>(JTextArea.class) {
			@Override
			protected boolean isMatching(JTextArea component) {
		      return true;
			}				

		};
		// Preguntar - Prueba sobre el formato de contactos
		frame.textBox(matcher).requireText("   Antonio                              \n");
	}
	
	@Test
	public void test7(){
		
		//Pre Condicion
		frame.textBox("tfApellido").requireText("");
		frame.textBox("tfNombre").requireText("");
		frame.textBox("tfEmail").requireText("");
		frame.textBox("tfTelefono").requireText("");
		
		// Proceso										
		frame.textBox("tfEmail").focus();									//3
		frame.textBox("tfEmail").setText("antonioParedes@gmail.com");		//4
		
		frame.button("bAnade").click();					//9
		
		//Post Condicion
		GenericTypeMatcher<JTextArea> matcher= new GenericTypeMatcher<JTextArea>(JTextArea.class) {
			@Override
			protected boolean isMatching(JTextArea component) {
		      return true;
			}				

		};
		// Preguntar - Prueba sobre el formato de contactos
		frame.textBox(matcher).requireText("                    antonioParedes@gmail.com          \n");
	}
}                   

