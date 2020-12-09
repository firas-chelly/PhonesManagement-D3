package com.firas.telephones;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.firas.telephones.entities.Company;
import com.firas.telephones.entities.Telephone;
import com.firas.telephones.repos.TelephoneRepository;
import com.firas.telephones.service.TelephoneService;

@SpringBootTest
class TelephonesApplicationTests {
	
	@Autowired
	private TelephoneRepository telephoneRepository;
	@Autowired
	private TelephoneService telephoneService;
	
	@Test
	public void testCreateTelephone() {
	Telephone tel = new Telephone("Samsung S10 Ultra",2450.0,new Date());
	telephoneRepository.save(tel);
	}
	
	@Test
	public void testFindTelephone()
	{
	Telephone t = telephoneRepository.findById(1L).get();
	System.out.println(t);
	}
	
	@Test
	public void testUpdateTelephone()
	{
	Telephone t = telephoneRepository.findById(1L).get();
	t.setPrixTel(2000.0);
	telephoneRepository.save(t);
	System.out.println(t);
	}

	@Test
	public void testDeleteTelephone()
	{
		telephoneRepository.deleteById(1L);
	}
	
	
	@Test
	public void testFindAllTelephone()
	{
		List<Telephone> tel = telephoneRepository.findAll();
		
		for (Telephone t:tel) {
			System.out.println(t);
		}
	}
	
	@Test
	public void testFindByNomTelephoneContains()
	{
	Page<Telephone> tels = telephoneService.getAllTelephonesParPage(0,2);
	System.out.println(tels.getSize());
	System.out.println(tels.getTotalElements());
	System.out.println(tels.getTotalPages());
	tels.getContent().forEach(t -> {System.out.println(t.toString());
	 });
	/*ou bien
	for (Telehpone t : tels)
	{
	System.out.println(t);
	} */
	}
	
	@Test
	public void testFindTelephoneByMarque()
	{
	List<Telephone> tels = telephoneRepository.findByMarqueTel("iPhone 12");
	for (Telephone t:tels) {
		System.out.println(t);
	}
	}
	
	@Test
	public void testFindTelephoneByMarqueContains()
	{
	List<Telephone> tels = telephoneRepository.findByMarqueTelContains("S");
	for (Telephone t:tels) {
		System.out.println(t);
	}
	}
	
	@Test
	public void testFindByMarquePrix()
	{
	List<Telephone> tels = telephoneRepository.findByMarquePrix("Samsung A50",1700.0);
		for (Telephone t:tels)
		{
			System.out.println(t);
		}

	}
	
	@Test
	public void testfindByCompany()
	{
	Company com = new Company();
	com.setIdCom(1L);
	
	List<Telephone> tels = telephoneRepository.findByCompany(com);
	for (Telephone t:tels)
	{
		System.out.println(t);
	}
	}
	
	
	@Test
	public void testFindByCompanyIdCom()
	{
	List<Telephone> tels = telephoneRepository.findByCompanyIdCom(2L);
		for (Telephone t:tels)
		{
			System.out.println(t);
		}

	}
	
	@Test
	public void testfindByOrderByMarqueTelAsc()
	{
	List<Telephone> tels = telephoneRepository.findByOrderByMarqueTelAsc();
	for (Telephone t : tels)
		{
			System.out.println(t);
		}

	}
	
	@Test
	public void testTrierTelsMarquePrix()
	{
	List<Telephone> tels = telephoneRepository.trierTelsMarquePrix();
	for (Telephone t : tels)
	{
		System.out.println(t);
	}

	}
	
	

}
