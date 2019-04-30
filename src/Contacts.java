import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;

public class Contacts extends TreeMap<String, String> {

	File file;
	
	public String exec(String cmd){
		String result = null;
		Scanner s = new Scanner(cmd);
		int estado = 0;
		String token;
		String nombre = "";
		while (estado != 5) {
			switch (estado) {
			case 0:
				try {
					token = s.skip("buscar|[a-zA-ZáéíóúÁÉÍÓÚ]+\\s+([a-zA-ZáéíóúÁÉÍÓÚ]+\\s+)*[a-zA-ZáéíóúÁÉÍÓÚ]+|[a-zA-ZáéíóúÁÉÍÓÚ]+").match().group(); //match contiene informacion acerca del trozo del token que se ha escaneado y para retornarlo se invoca group
//					token = s.skip("fin|buscar|[^:-]+").match().group();
					if (token.equals("buscar")) {
						estado = 2;
					}
					else {
						nombre = token;
						estado = 1;
					}
				} catch (NoSuchElementException e) { //not checked, hay que capturarla si o si
					result = "Se esperaba 'buscar' o 'fin' o un nombre";
					estado = 5;
				}

				break;
			case 1:
				try {
					s.skip("-");
					estado = 3;
				} catch (NoSuchElementException e) {
					result = "Se esperaba '-'";
					estado = 5;
				}
				break;
			case 2:
				try {
					s.skip(":");
					estado = 4;
				} catch (NoSuchElementException e) {
					result = "Se esperaba ':'";
					estado = 5;
				}
				break;
			case 3:
				try {
					token = s.skip("\\d{9}").match().group();
					put(nombre, token);
					estado = 5;
				} catch (NoSuchElementException e) {
					result = "Se esperaba un telefono";
					estado = 5;
				}
				break;
			case 4:
				try {
					token = s.skip("[a-zA-ZáéíóúÁÉÍÓÚ]+\\s+([a-zA-ZáéíóúÁÉÍÓÚ]+\\s+)*[a-zA-ZáéíóúÁÉÍÓÚ]+|[a-zA-ZáéíóúÁÉÍÓÚ]+").match().group();
					String telefono = get(token); //te da el telefono de ese token que es el nombre
					if (telefono != null) 
						result = token + " -> " + telefono;
					else
						result = token + " no se encuentra en la agenda";
					estado = 5;
				} catch (NoSuchElementException e) {
					result = "Se esperaba un nombre";
					estado = 5;
				}
				break;
			}
		}
		return result;
	}
	
	public void load(File file) {
		
	}
	
	public void save() {
		
	}
	
	public void saveas(File file) {
		this.file = file;
		save();
	}
	
}
