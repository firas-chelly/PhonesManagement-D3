package com.firas.telephones;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.firas.telephones.entities.Telephone;
import com.firas.telephones.repos.TelephoneRepository;

@SpringBootTest
class TelephonesApplicationTests {
	
	@Autowired
	private TelephoneRepository telephoneRepository;
	
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

}
