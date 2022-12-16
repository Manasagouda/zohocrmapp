package com.zoho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoho.entities.Contacts;
import com.zoho.entities.Lead;
import com.zoho.services.ContactsServices;
import com.zoho.services.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactsServices contactService;
	
	//localhost:8080/create
	//@RequestMapping(value="/create", method=RequestMethod.GET)
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String viewCreateLeadForm() {
		return "create_lead";
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String saveOneLead(@ModelAttribute("s") Lead leads,Model model) {
		leadService.saveLeadInfo(leads);
		model.addAttribute("lead", leads);
		model.addAttribute("msg", "lead is saved");
		return "lead_info";
	}
	@RequestMapping("/listAll")
	public String getAllLeads(Model model) {
		List<Lead> leads = leadService.findAllLeads();
		model.addAttribute("leads", leads);
		return "listLeads";
	}
	@RequestMapping("leadInfo")
	public String leadInfo(@RequestParam("id")long id, Model model) {
		Lead lead = leadService.findById(id);
		model.addAttribute("lead", lead);
		return "lead_info";
	}
	@RequestMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id,Model model) {
		Lead lead = leadService.findById(id);
		Contacts contact=new Contacts();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		
		contactService.saveContactInfo(contact);
		
		leadService.deleteOneLead(id);
		
		List<Contacts> contacts = contactService.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "list_contacts";
				
	}
}
