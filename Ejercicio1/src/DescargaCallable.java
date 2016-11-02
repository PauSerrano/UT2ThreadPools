import java.util.Random;
import java.util.concurrent.Callable;

public class DescargaCallable implements Callable<String> {
	String archivo;
	int tiempoDescarga;
	
	public DescargaCallable(String archivo, int tiempoDescarga) {
		super();
		this.archivo = archivo;
		this.tiempoDescarga = tiempoDescarga;
	}
	
	@Override
	public String call() throws Exception {
		String mensaje;
		// TODO: esperar
		Thread.sleep(tiempoDescarga);
		// TODO: devolver mensaje "Archivo X descargado en T segundos"
		mensaje = "Archivo " + archivo + " descargado en "+ tiempoDescarga +" segundos";
		
		return mensaje;
	}

}
