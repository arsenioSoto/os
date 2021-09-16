package mz.com.soto.junior.ordem_servico.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import mz.com.soto.junior.ordem_servico.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	public void instanciaDB() {
	
	this.dbService.instanciaDB();
	
	}
}
