package mz.com.soto.junior.ordem_servico.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.com.soto.junior.ordem_servico.domain.Cliente;
import mz.com.soto.junior.ordem_servico.domain.Os;
import mz.com.soto.junior.ordem_servico.domain.Tecnico;
import mz.com.soto.junior.ordem_servico.enuns.Prioridade;
import mz.com.soto.junior.ordem_servico.enuns.Status;
import mz.com.soto.junior.ordem_servico.repositories.ClienteRepository;
import mz.com.soto.junior.ordem_servico.repositories.OsRepository;
import mz.com.soto.junior.ordem_servico.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private OsRepository osRepository;
	public void instanciaDB() {
		
		Tecnico t1 = new Tecnico(null, "Arsenio Jose Soto Junior", "144.785.300-84", "(+258)-845-072-619");
		
		Cliente c1 = new Cliente(null, "Arsenio Junior", "598.785.300-84", "(+258)-845-172-619");
		Os  os1 = new Os(null, Prioridade.ALTA, Status.ANDAMENTO, "Teste create ODD", "Leptop", "sem solucao", 10, t1, c1); 
		
		t1.getList().add(os1);
		c1.getList().add(os1);
	
		
		tecnicoRepository.saveAll(Arrays.asList(t1));
		
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}

}
