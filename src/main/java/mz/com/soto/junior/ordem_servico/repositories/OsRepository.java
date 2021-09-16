package mz.com.soto.junior.ordem_servico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mz.com.soto.junior.ordem_servico.domain.Os;
import mz.com.soto.junior.ordem_servico.domain.Pessoa;


@Repository
public interface OsRepository extends JpaRepository<Os, Integer>{
	
	@Query("SELECT obj FROM Os obj WHERE obj.id=:id")
	Pessoa findById(@Param("id")String id);

}
