package org.zer0.pocs.hazelcast_client;

import java.util.Map;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

public class App{
	
	
    public static void main( String[] args ){
    	App app=new App();
    	HazelcastInstance instancia=app.conectar();
    	app.crearMapDistribuido(instancia);
    	//app.leerMapDistribuido(instancia);  // Intercalar entre la llamada anterior y esta llamada
    }
    
    private HazelcastInstance conectar() {
    	ClientConfig clientConfig = new ClientConfig();
    	//clientConfig.getGroupConfig().setName("dev");
    	clientConfig.getNetworkConfig().addAddress("10.0.0.7", "192.168.1.42:5701");
    	return HazelcastClient.newHazelcastClient(clientConfig);
    }
    
    private void crearMapDistribuido(HazelcastInstance instanciaHazelcast) {
    	Map<Long, String> datos=instanciaHazelcast.getMap("tiposDocumento");
    	System.out.println("datos:"+datos);
    	datos.put(1L, "DNI");
    	datos.put(2L, "Carnet Extranjeria");
    	datos.put(3L, "Pasaporte");
    	datos.put(4L, "Libreta");
    }
    
    private void leerMapDistribuido(HazelcastInstance instanciaHazelcast) {
    	Map<Long, String> datos=instanciaHazelcast.getMap("tiposDocumento");
    	System.out.println("datos:"+datos);
    	for (Map.Entry<Long, String> m: datos.entrySet()) {
			System.out.println("key:"+m.getKey()+" val:"+m.getValue());
		}
    }
    
}

