import java.util.Random;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoDescarga {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Completa una lista de al menos 10 URLS de descarga
	    String urlsArchivos[] = {"http://sunsite.rediris.es/mirror/ubuntu-releases/16.10/ubuntu-16.10-desktop-amd64.iso",
	    						 "http://sunsite.rediris.es/mirror/FreeBSD/ISO-IMAGES-amd64/8.2/FreeBSD-8.2-RELEASE-amd64-dvd1.iso.xz",
	    		                 "http://sunsite.rediris.es/mirror/archlinux/iso/2016.10.01/archlinux-2016.10.01-dual.iso",
	    		                 "http://sunsite.rediris.es/mirror/Lliurex/releases/14.06_64bits/releases/lliurex-escriptori-amd64_1406_20140826.iso",
	    		                 "http://sunsite.rediris.es/mirror/CentOS/7.2.1511/isos/x86_64/CentOS-7-x86_64-Everything-1511.iso",
	    		                 "http://javadl.oracle.com/webapps/download/AutoDL?BundleId=216425",
	    		                 "https://central.github.com/mac/latest",
	    		                 "https://get.adobe.com/es/flashplayer/download/?installer=FP_23_Mac_for_Safari_and_Firefox_-_NPAPI&stype=2739&standalone=1",
	    		                 "http://windows-media-player-plugin.softonic.com/descargar",
	    		                 "https://www.mozilla.org/firefox/new/?scene=2"
	    		                 
	    		                };
	    
	    // TODO: crear el ExecuteService. El thread pool debe ser fijo (2 threads).
	    ExecutorService pool = Executors.newFixedThreadPool(2);
	    // TODO: crear el CompletionService
	    CompletionService<String> poolCom = new ExecutorCompletionService<String>(pool);

	    // TODO: iterar y añadir los callables parametrizados con urlsArchivos y un tiempo
	    // variable de 10 a 20 segundos.
	    
		
		for (int i=0;i<10;i++){
			Random r = new Random();
			int espera = r.nextInt(20000)+10000;
			poolCom.submit(new DescargaCallable (urlsArchivos[i],espera));
		}
	    
	    // TODO: imprimir los resultados a medida que los recibimos.
		for (int i=0;i<10;i++){
			String resultado = poolCom.take().get();
			System.out.println(resultado);
			// TODO: Imprimir el estado del thread pool después de recibir un archivo (toString)
			System.out.println(pool.toString());
		}
	    
	    
	    // TODO: parar el thread pool de forma ordenada.
		pool.shutdown();
		System.out.println("Se ha finalizado el programa");
		
	}

}
