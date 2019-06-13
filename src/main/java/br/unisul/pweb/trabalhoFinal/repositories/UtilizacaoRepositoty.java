package br.unisul.pweb.trabalhoFinal.repositories;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.unisul.pweb.trabalhoFinal.domain.Utilizacao;

@Repository
public interface UtilizacaoRepositoty extends JpaRepositoryImplementation<Utilizacao, Integer>{
	
	@Transactional(readOnly=true)
	public List<Utilizacao> findAllByOrderByNomeFuncionario();

	 @Transactional(readOnly=true)
	 public List<Utilizacao> findDistinctByDataContainingOrderByData(Date data);
}
