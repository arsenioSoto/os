package mz.com.soto.junior.ordem_servico.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.com.soto.junior.ordem_servico.domain.Cliente;
import mz.com.soto.junior.ordem_servico.domain.Os;
import mz.com.soto.junior.ordem_servico.domain.Tecnico;
import mz.com.soto.junior.ordem_servico.dtos.OsDTO;
import mz.com.soto.junior.ordem_servico.enuns.Prioridade;
import mz.com.soto.junior.ordem_servico.enuns.Status;
import mz.com.soto.junior.ordem_servico.repositories.OsRepository;
import mz.com.soto.junior.ordem_servico.services.exceptions.DataIntegratyViolationExecption;
import mz.com.soto.junior.ordem_servico.services.exceptions.ObjecteNotFoundException;

@Service
public class OsService {

	
	@Autowired
	private OsRepository osRepository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public Os findById(Integer id) {
		Optional<Os> obj = osRepository.findById(id);
		return obj.orElseThrow(() -> new ObjecteNotFoundException(
				" Objecto nao encontrado! ID: "+ id + ", Tipo: " + Os.class.getName()));
	}
	
	public List<Os> findAll(){
		return osRepository.findAll();
	}

	public Os create(@Valid OsDTO obj) {
		return fromDTO(obj);
		
	}
	
	
	public Os update(@Valid OsDTO obj) {
		findById(obj.getId());
		return fromDTO(obj);
		
	}
	
	private Os fromDTO(OsDTO obj){
		Os newObj = new Os();
		newObj.setId(obj.getId());
		newObj.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		newObj.setStatus(Status.toEnum(obj.getStatus()));
		newObj.setObservacao(obj.getObservacao());
		newObj.setProduto(obj.getProduto());
		newObj.setDescricaoProduto(obj.getDescricaoProduto());
		newObj.setValor(obj.getValor());
		
		Tecnico tec = tecnicoService.findById(obj.getTecnico());
		Cliente cli = clienteService.findById(obj.getCliente());
		
		newObj.setTecnico(tec);
		newObj.setCliente(cli);
		
		if (newObj.getStatus().getCod().equals(2)) {
			newObj.setDataFechamento(LocalDateTime.now());
		}
		
		return osRepository.save(newObj);
	}
	

	public void delete(Integer id) {
		Os obj = findById(id);
		if (obj.getId().SIZE < 0) {
			throw new DataIntegratyViolationExecption("Esta Ordem esta Vinculado a uma Ordem de servico nao pode ser delectado, apague a ordem de servico onde o mesmo encontra se vinculado!");
		}
		osRepository.deleteById(id);
		
	}

	
}
