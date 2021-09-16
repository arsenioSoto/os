package mz.com.soto.junior.ordem_servico.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.com.soto.junior.ordem_servico.domain.Pessoa;
import mz.com.soto.junior.ordem_servico.domain.Tecnico;
import mz.com.soto.junior.ordem_servico.dtos.TecnicoDTO;
import mz.com.soto.junior.ordem_servico.repositories.PessoaRepository;
import mz.com.soto.junior.ordem_servico.repositories.TecnicoRepository;
import mz.com.soto.junior.ordem_servico.services.exceptions.DataIntegratyViolationExecption;
import mz.com.soto.junior.ordem_servico.services.exceptions.ObjecteNotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = tecnicoRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjecteNotFoundException(
				"Objecto nao encontrado! ID: "+ id + " Tipo: " + Tecnico.class.getName()));
	}

	public List<Tecnico> findAll() {
		
		return tecnicoRepository.findAll();
	}
	
	public Tecnico create(TecnicoDTO objDTO) {
		if (findByBI(objDTO) != null) {
			throw new DataIntegratyViolationExecption("Codigo ja Existente na Base de dados, por favor insira um codigo diferente");
		}
		return tecnicoRepository.save(new Tecnico(null, objDTO.getNome(), objDTO.getBi(), objDTO.getTelefone()));
	}
	
	
	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
		Tecnico oldObj = findById(id);
		
		if (findByBI(objDTO) != null && findByBI(objDTO).getId() != id) {
			throw new DataIntegratyViolationExecption("Codigo ja Existente na Base de dados, por favor insira um codigo diferente");
		}
		
		
		oldObj.setNome(objDTO.getNome());
		oldObj.setBi(objDTO.getBi());
		oldObj.setTelefone(objDTO.getTelefone());
		
		return tecnicoRepository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Tecnico obj = findById(id);
		if (obj.getList().size() > 0) {
			throw new DataIntegratyViolationExecption("Este Tecnico esta Vinculado a uma Ordem de servico nao pode ser delectado, apague a ordem de servico onde o mesmo encontra se vinculado!");
		}
		tecnicoRepository.deleteById(id);
		
	}

	
	private Pessoa findByBI(TecnicoDTO objDTO) {
		Pessoa obj = pessoaRepository.findByBi(objDTO.getBi());
		
		if (obj != null) {
			return obj;
		}
		
		return null;
	}

	
	
}
