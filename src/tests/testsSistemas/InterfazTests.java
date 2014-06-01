package tests.testsSistemas;

import javax.swing.JFrame;
import agenda.vista.AgendaFrame;

public class InterfazTests extends UITest{

	@Override
	protected JFrame intAppContext() {
		return new AgendaFrame();
	}

}
