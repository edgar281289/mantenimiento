package agenda.vista;

import java.awt.event.ActionListener;
import java.util.Map;

import agenda.modelo.Campo;
import agenda.modelo.Contacto;

public interface AgendaVista {
	String BORRA = "Borra", BUSCA = "Busca", RESETEA = "Resetea",
			ANADE = "A–ade";

	void borraContacto();

	void muestraContacto(Contacto c);

	void muestraContactos(String t);

	void daFoco(Campo c);

	void controlador(ActionListener ctrl);

	Map<Campo, String> leeDatos();
}
