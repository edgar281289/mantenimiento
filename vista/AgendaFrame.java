package agenda.vista;

import java.awt.event.ActionListener;

import javax.swing.*;

import agenda.modelo.Agenda;

public class AgendaFrame extends JFrame {
	public AgendaFrame() {
		super("MiniAgenda");
		AgendaVista vista = new AgendaPanel();
		Agenda agenda = new Agenda();
		ActionListener ctrl = new AgendaCtrl(vista, agenda);
		vista.controlador(ctrl);

		setContentPane((JPanel) vista);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
