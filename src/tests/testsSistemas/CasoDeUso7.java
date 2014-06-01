package tests.testsSistemas;

import static org.junit.Assert.*;

import javax.swing.JTextArea;

import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.security.ExitCallHook;
import org.fest.swing.security.NoExitSecurityManagerInstaller;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * 
 * @author Francisco Jesús Dominguez Ruíz
 * @author Edgar Pérez Ferrando
 *
 *	Caso de uso - Cerrar Ventana
 */
public class CasoDeUso7 extends InterfazTests{

	@Test
	public void test1(){
		
		final ExitCallHook exitMock = Mockito.mock(ExitCallHook.class);
		NoExitSecurityManagerInstaller noExit = NoExitSecurityManagerInstaller.installNoExitSecurityManager(exitMock);
		Mockito.reset(exitMock);
		frame.close();
		Mockito.verify(exitMock).exitCalled(0);
		noExit.uninstall();
	}

}


