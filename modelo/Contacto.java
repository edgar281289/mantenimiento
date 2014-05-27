package agenda.modelo;

import java.util.HashMap;
import java.util.Map;

public class Contacto implements Comparable<Contacto> {
	private Map<Campo, String> datos = new HashMap<Campo, String>();

	public String getValor(Campo campo) {
		return datos.get(campo);
	}

	public void setValor(Campo campo, String valor) {
		datos.put(campo, valor);
	}

	public Map<Campo, String> getDatos() {
		return datos;
	}

	public boolean equals(Object o) {
		boolean r = o instanceof Contacto;
		int i = 0;
		while (r && i < Campo.values().length) {
			if (!datos.get(Campo.values()[i]).equals(
					((Contacto) o).getValor(Campo.values()[i]))) {
				r = false;
			}
			i++;
		}
		return r;
	}

	public int hashCode() {
		int r = 0;
		for (Campo cm : Campo.values()) {
			r += datos.get(cm).hashCode();
		}
		return r;
	}

	@Override
	public int compareTo(Contacto c) {
		int r = datos.get(Campo.APELLIDO).compareTo(c.getValor(Campo.APELLIDO));
		if (r == 0) {
			r = datos.get(Campo.NOMBRE).compareTo(c.getValor(Campo.NOMBRE));
			if (r == 0) {
				r = datos.get(Campo.TELEFONO).compareTo(
						c.getValor(Campo.TELEFONO));
				if (r == 0) {
					r = datos.get(Campo.EMAIL).compareTo(
							c.getValor(Campo.EMAIL));
				}
			}
		}
		return r;
	}

	public String toString() {
		String r = "contacto(";
		for (Campo cm : Campo.values()) {
			r += datos.get(cm) + ", ";
		}
		return r.substring(0, r.length() - 2) + ")";
	}
}
