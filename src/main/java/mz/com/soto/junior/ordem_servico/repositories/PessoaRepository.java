package mz.com.soto.junior.ordem_servico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mz.com.soto.junior.ordem_servico.domain.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	
	@Query("SELECT obj FROM Pessoa obj WHERE obj.bi=:bi")
	Pessoa findByBi(@Param("bi")String bi);
	

}
