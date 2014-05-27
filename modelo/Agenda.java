package agenda.modelo;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Agenda implements Iterable<Contacto> {
	private SortedSet<Contacto> contactos = new TreeSet<Contacto>();

	public void anadeContacto(Contacto c) {
		if (!contactos.add(c)) {
			throw new IllegalArgumentException(
					"El contacto ya est‡ en la agenda");
		}
	}

	public Contacto buscaContacto(Map<Campo, String> datos) {
		Contacto c = null;
		Iterator<Contacto> iterContactos = contactos.iterator();
		boolean found = false;
		while (!found && iterContactos.hasNext()) {
			c = iterContactos.next();
			found = true;
			for (Map.Entry<Campo, String> e : datos.entrySet()) {
				if (!c.getValor(e.getKey()).contains(e.getValue())) {
					found = false;
				}
			}
		}
		return found ? c : null;
	}

	public void borraContacto(Contacto contacto) {
		contactos.remove(contacto);
	}

	public void cambiaContacto(Contacto contacto, Campo campo, String valor) {
		contacto.setValor(campo, valor);
	}

	public void reset() {
		contactos.clear();
	}

	@Override
	public Iterator<Contacto> iterator() {
		return contactos.iterator();
	}

	public String toString() {
		String r = "agenda(";
		for (Contacto cn : contactos) {
			r += cn + ", ";
		}
		return r.substring(0, r.length() - 2) + ")";
	}
}
