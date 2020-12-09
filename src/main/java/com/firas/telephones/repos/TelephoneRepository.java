package com.firas.telephones.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.firas.telephones.entities.Company;
import com.firas.telephones.entities.Telephone;

public interface TelephoneRepository extends JpaRepository<Telephone, Long> {
	
	List<Telephone> findByMarqueTel(String marque);
	List<Telephone> findByMarqueTelContains(String marque);

	@Query("select t from Telephone t where t.marqueTel like %:marque and t.prixTel > :prix")
	List<Telephone> findByMarquePrix (@Param("marque") String marque,@Param("prix") Double prix);

	@Query("select t from Telephone t where t.company = ?1")
	List<Telephone> findByCompany (Company company);
	
	List<Telephone> findByCompanyIdCom(Long id);
	
	List<Telephone> findByOrderByMarqueTelAsc();
	
	@Query("select t from Telephone t order by t.marqueTel ASC, t.prixTel DESC")
	List<Telephone> trierTelsMarquePrix ();
}
