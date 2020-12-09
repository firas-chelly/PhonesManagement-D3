package com.firas.telephones.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.firas.telephones.entities.Telephone;
import com.firas.telephones.service.TelephoneService;

@Controller
public class TelephoneController {
	
	@Autowired
	TelephoneService telephoneService;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createTelephone";
	}
	
	@RequestMapping("/saveTelephone")
	public String saveTelephone(@ModelAttribute("telephone") Telephone telephone,
								@RequestParam("date") String date,ModelMap modelMap) throws ParseException
	
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 telephone.setDateCreation(dateCreation);

	Telephone saveTelephone = telephoneService.saveTelephone(telephone);
	String msg ="Telephone enregistré avec Id "+saveTelephone.getIdTel();
	modelMap.addAttribute("msg", msg);
	return "createTelephone";
	}
	
	@RequestMapping("/ListeTelephones")
	public String listeTelephones(ModelMap modelMap,
									@RequestParam (name="page",defaultValue = "0") int page,
									@RequestParam (name="size", defaultValue = "2") int size)
	{
		Page<Telephone> prods = telephoneService.getAllTelephonesParPage(page, size);
		modelMap.addAttribute("telephones", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeTelephones";

	}
	
	
	@RequestMapping("/supprimerTelephone")
	public String supprimerTelephone(@RequestParam("id") Long id,
									 ModelMap modelMap,
									 @RequestParam (name="page",defaultValue = "0") int page,
									 @RequestParam (name="size", defaultValue = "2") int size)
	
	{
	telephoneService.deleteTelephoneById(id);
	Page<Telephone> tels = telephoneService.getAllTelephonesParPage(page,size);
			
			modelMap.addAttribute("telephones", tels);
			modelMap.addAttribute("pages", new int[tels.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);

	return "listeTelephones";
	}
	
	
	@RequestMapping("/modifierTelephone")
	public String editerTelephone(@RequestParam("id") Long id,
									ModelMap modelMap)
	{
	Telephone t= telephoneService.getTelephone(id);
	modelMap.addAttribute("telephone", t);
	return "editerTelephone";
	}

	@RequestMapping("/updateTelephone")
	public String updateTelephone(@ModelAttribute("telephone") Telephone telephone,
									@RequestParam("date") String date,
									ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 telephone.setDateCreation(dateCreation);

	 telephoneService.updateTelephone(telephone);
	 List<Telephone> tels = telephoneService.getAllTelephones();
	 modelMap.addAttribute("telephones", tels);
	return "listeTelephones";
	}

	

	
	}
