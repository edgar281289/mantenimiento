package agenda.vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import agenda.modelo.Campo;
import agenda.modelo.Contacto;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AgendaPanel extends JPanel implements AgendaVista {
	private Map<Campo, JTextField> jtfs;
	private JButton bBorra, bBusca, bAnade, bResetea;
	private JTextArea aTexto;

	public AgendaPanel() {
		setName("panel");
		
		jtfs = new HashMap<Campo, JTextField>();
		jtfs.put(Campo.APELLIDO, new JTextField());
		jtfs.get(Campo.APELLIDO).setName("tfApellido");
		jtfs.put(Campo.NOMBRE, new JTextField());
		jtfs.get(Campo.NOMBRE).setName("tfNombre");
		jtfs.put(Campo.TELEFONO, new JTextField());
		jtfs.get(Campo.TELEFONO).setName("tfTelefono");
		jtfs.put(Campo.EMAIL, new JTextField());
		jtfs.get(Campo.EMAIL).setName("tfEmail");
		bBorra = new JButton("BORRA");
		bBorra.setName("bBorra");
		bBusca = new JButton("BUSCA");
		bBusca.setName("bBusca");
		bAnade = new JButton("AÑADE");
		bAnade.setName("bAnade");
		bResetea = new JButton("RESETEA");
		bResetea.setName("bResetea");
		aTexto = new JTextArea(10, 20);
		aTexto.setEditable(false);

		JPanel botonera = new JPanel();
		botonera.setLayout(new GridLayout(4, 3, 10, 10));
		JLabel lApellido = new JLabel("Apellido");
		lApellido.setHorizontalAlignment(SwingConstants.CENTER);
		botonera.add(lApellido);
		botonera.add(jtfs.get(Campo.APELLIDO));
		botonera.add(bBorra);
		JLabel lNombre = new JLabel("Nombre");
		lNombre.setHorizontalAlignment(SwingConstants.CENTER);
		botonera.add(lNombre);
		botonera.add(jtfs.get(Campo.NOMBRE));
		botonera.add(bBusca);
		JLabel lTelefono = new JLabel("Teléfono");
		lTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		botonera.add(lTelefono);
		botonera.add(jtfs.get(Campo.TELEFONO));
		botonera.add(bAnade);
		JLabel lEmail = new JLabel("E-mail");
		lEmail.setHorizontalAlignment(SwingConstants.CENTER);
		botonera.add(lEmail);
		botonera.add(jtfs.get(Campo.EMAIL));
		botonera.add(bResetea);
		setLayout(new GridLayout(2, 1));
		add(aTexto);
		add(botonera);
	}

	@Override
	public void controlador(ActionListener ctrl) {
		bBorra.addActionListener(ctrl);
		bBorra.setActionCommand(AgendaVista.BORRA);
		bBusca.addActionListener(ctrl);
		bBusca.setActionCommand(AgendaVista.BUSCA);
		bAnade.addActionListener(ctrl);
		bAnade.setActionCommand(AgendaVista.ANADE);
		bResetea.addActionListener(ctrl);
		bResetea.setActionCommand(AgendaVista.RESETEA);
	}

	@Override
	public void borraContacto() {
		for (Campo c : jtfs.keySet()) {
			jtfs.get(c).setText("");
		}
	}

	@Override
	public void muestraContacto(Contacto cn) {
		for (Campo cm : jtfs.keySet()) {
			jtfs.get(cm).setText(cn.getValor(cm));
		}
	}

	@Override
	public void muestraContactos(String t) {
		aTexto.setText(t);
	}

	@Override
	public void daFoco(Campo c) {
		jtfs.get(c).requestFocus();
	}

	@Override
	public Map<Campo,String> leeDatos() {
		Map<Campo,String> m = new HashMap<Campo,String>();
		for (Campo cm : Campo.values()) {
			m.put(cm, jtfs.get(cm).getText());
		}
		return m;
	}

}
