package agenda.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import agenda.modelo.Agenda;
import agenda.modelo.Campo;
import agenda.modelo.Contacto;

public class AgendaCtrl implements ActionListener {
	private AgendaVista vista;
	private Agenda agenda;

	public AgendaCtrl(AgendaVista v, Agenda a) {
		vista = v;
		agenda = a;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command == AgendaVista.BORRA) {
			Map<Campo, String> m = vista.leeDatos();
			Contacto c = new Contacto();
			for (Campo cm : Campo.values()) {
				c.setValor(cm, m.get(cm));
			}
			agenda.borraContacto(c);
			vista.borraContacto();
			vista.muestraContactos(toString(agenda));
		} else if (command == AgendaVista.ANADE) {
			try {
				Map<Campo, String> m = vista.leeDatos();
				Contacto c = new Contacto();
				for (Campo cm : Campo.values()) {
					c.setValor(cm, m.get(cm));
				}
				agenda.anadeContacto(c);
				vista.muestraContactos(toString(agenda));
			} catch (IllegalArgumentException ec) {
				JOptionPane.showMessageDialog(null, "Contacto repetido",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (command == AgendaVista.BUSCA) {
			Contacto c = agenda.buscaContacto(vista.leeDatos());
			if (c == null) {
				JOptionPane.showMessageDialog(null,
						"No existe contacto con esos datos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				vista.muestraContacto(c);
			}
		} else {// (command == AgendaVista.RESETEA){
			vista.muestraContactos("");
			vista.borraContacto();
			agenda.reset();
		}
	}

	private static String toString(Agenda a) {
		StringBuilder texto = new StringBuilder();
		Iterator<Contacto> iterAgenda = a.iterator();
		while (iterAgenda.hasNext()) {
			Contacto cn = iterAgenda.next();
			for (Campo cm : Campo.values()) {
				texto.append(String.format("%10s", cn.getValor(cm)));
			}
			texto.append("\n");
		}
		return texto.toString();
	}
}
