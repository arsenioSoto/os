package mz.com.soto.junior.ordem_servico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mz.com.soto.junior.ordem_servico.domain.Tecnico;


@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
	
	@Query("SELECT obj FROM Tecnico obj WHERE obj.bi=:bi")
	Tecnico findByBi(@Param("bi")String bi);
	


}
