package com.gestion.banque;

import com.gestion.banque.rmi.GestionRmiRemote;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

public class Config {
	
	@Bean
	public SimpleJaxWsServiceExporter getJWS(){
		
		SimpleJaxWsServiceExporter exporter=new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://localhost:8080/banque");
		return exporter;
	}
	
	@Bean
	public RmiServiceExporter getrmiservice(ApplicationContext ctx){
		RmiServiceExporter exporter=new RmiServiceExporter();
		exporter.setService(ctx.getBean("myRmiService"));
		exporter.setRegistryPort(1099);
		exporter.setServiceName("BK");
		exporter.setServiceInterface(GestionRmiRemote.class);
		return exporter;
	}

}
