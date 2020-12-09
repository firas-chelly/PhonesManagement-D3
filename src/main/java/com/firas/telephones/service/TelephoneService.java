package com.firas.telephones.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.firas.telephones.entities.Telephone;

public interface TelephoneService {
	Telephone saveTelephone(Telephone t);
	Telephone updateTelephone(Telephone t);
	void deleteTelephone(Telephone t);
	 void deleteTelephoneById(Long id);
	 Telephone getTelephone(Long id);
	List<Telephone> getAllTelephones();
	Page<Telephone> getAllTelephonesParPage(int page, int size);


}
