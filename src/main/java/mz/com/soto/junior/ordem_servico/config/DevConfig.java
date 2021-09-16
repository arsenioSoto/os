package mz.com.soto.junior.ordem_servico.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import mz.com.soto.junior.ordem_servico.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;
	
	@Bean
	public boolean instanciaDB() {
	
	if(ddl.equals("create")) {
		this.dbService.instanciaDB();
		}
	return false;
	}
}
