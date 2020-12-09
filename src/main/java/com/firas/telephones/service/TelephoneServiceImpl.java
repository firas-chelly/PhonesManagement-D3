package com.firas.telephones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.firas.telephones.entities.Company;
import com.firas.telephones.entities.Telephone;
import com.firas.telephones.repos.TelephoneRepository;

@Service
public class TelephoneServiceImpl implements TelephoneService{
	
	@Autowired
	TelephoneRepository telephoneRepository;
	
	@Override
	public Telephone saveTelephone(Telephone t) {
		return telephoneRepository.save(t);
	}

	@Override
	public Telephone updateTelephone(Telephone t) {
		return telephoneRepository.save(t);
	}

	@Override
	public void deleteTelephone(Telephone t) {
		telephoneRepository.delete(t);		
	}

	@Override
	public void deleteTelephoneById(Long id) {
		telephoneRepository.deleteById(id);		
		
	}

	@Override
	public Telephone getTelephone(Long id) {
		return telephoneRepository.findById(id).get();
	}

	@Override
	public List<Telephone> getAllTelephones() {
		return telephoneRepository.findAll();
	}

	@Override
	public Page<Telephone> getAllTelephonesParPage(int page, int size) {

		return telephoneRepository.findAll(PageRequest.of(page, size));
		}

	
	@Override
	public List<Telephone> findByMarqueTel(String marque) {
		return telephoneRepository.findByMarqueTel(marque);
	}

	@Override
	public List<Telephone> findByMarqueTelContains(String marque) {
		return telephoneRepository.findByMarqueTelContains(marque);
	}

	@Override
	public List<Telephone> findByMarquePrix(String marque, Double prix) {
		return telephoneRepository.findByMarquePrix(marque, prix);
	}

	@Override
	public List<Telephone> findByCompany(Company company) {
		return telephoneRepository.findByCompany(company);
	}

	@Override
	public List<Telephone> findByCompanyIdCom(Long id) {
		return telephoneRepository.findByCompanyIdCom(id);
	}

	@Override
	public List<Telephone> findByOrderByMarqueTelAsc() {
		return telephoneRepository.findByOrderByMarqueTelAsc();
	}

	@Override
	public List<Telephone> trierTelsMarquePrix() {
		return telephoneRepository.trierTelsMarquePrix();
	}
	}

