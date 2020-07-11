/**********************************************************************************************
Code generated by MKL Plug-in
Copyright: Kerubin - kerubin.platform@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

package br.com.kerubin.api.cadastros.fornecedor.entity.foto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import org.springframework.data.repository.query.Param;

@Transactional(readOnly = true)
public interface FotoRepository extends JpaRepository<FotoEntity, java.util.UUID>, QuerydslPredicateExecutor<FotoEntity> {
	
	@Transactional
	@Modifying
	@Query("delete from FotoEntity fe where fe.id in ?1")
	void deleteInBulk(java.util.List<java.util.UUID> idList);
	
	
	// WARNING: supports only where clause with like for STRING fields. For relationships entities will get the first string autocomplete key field name.
	@Query("select distinct ac.id as id, ac.nome as nome from FotoEntity ac where ( upper(ac.nome) like upper(concat('%', :query, '%')) ) order by 1 asc")
	Collection<FotoAutoComplete> autoComplete(@Param("query") String query);
}
