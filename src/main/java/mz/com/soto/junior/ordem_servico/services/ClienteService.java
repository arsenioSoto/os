package mz.com.soto.junior.ordem_servico.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.com.soto.junior.ordem_servico.domain.Pessoa;
import mz.com.soto.junior.ordem_servico.domain.Cliente;
import mz.com.soto.junior.ordem_servico.dtos.ClienteDTO;
import mz.com.soto.junior.ordem_servico.repositories.PessoaRepository;
import mz.com.soto.junior.ordem_servico.repositories.ClienteRepository;
import mz.com.soto.junior.ordem_servico.services.exceptions.DataIntegratyViolationExecption;
import mz.com.soto.junior.ordem_servico.services.exceptions.ObjecteNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository tecnicoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = tecnicoRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjecteNotFoundException(
				"Objecto nao encontrado! ID: "+ id + " Tipo: " + Cliente.class.getName()));
	}

	public List<Cliente> findAll() {
		
		return tecnicoRepository.findAll();
	}
	
	public Cliente create(ClienteDTO objDTO) {
		if (findByBI(objDTO) != null) {
			throw new DataIntegratyViolationExecption("Codigo ja Existente na Base de dados, por favor insira um codigo diferente");
		}
		return tecnicoRepository.save(new Cliente(null, objDTO.getNome(), objDTO.getBi(), objDTO.getTelefone()));
	}
	
	
	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		Cliente oldObj = findById(id);
		
		if (findByBI(objDTO) != null && findByBI(objDTO).getId() != id) {
			throw new DataIntegratyViolationExecption("Codigo ja Existente na Base de dados, por favor insira um codigo diferente");
		}
		
		
		oldObj.setNome(objDTO.getNome());
		oldObj.setBi(objDTO.getBi());
		oldObj.setTelefone(objDTO.getTelefone());
		
		return tecnicoRepository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Cliente obj = findById(id);
		if (obj.getList().size() > 0) {
			throw new DataIntegratyViolationExecption("Este Cliente esta Vinculado a uma Ordem de servico nao pode ser delectado, apague a ordem de servico onde o mesmo encontra se vinculado!");
		}
		tecnicoRepository.deleteById(id);
		
	}

	
	private Pessoa findByBI(ClienteDTO objDTO) {
		Pessoa obj = pessoaRepository.findByBi(objDTO.getBi());
		
		if (obj != null) {
			return obj;
		}
		
		return null;
	}

	
	
}
