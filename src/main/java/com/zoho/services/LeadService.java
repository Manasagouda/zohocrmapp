package com.zoho.services;

import java.util.List;

import com.zoho.entities.Lead;

public interface LeadService {

	public void saveLeadInfo(Lead lead);

	public List<Lead> findAllLeads();

	public Lead findById(long id);

	public void deleteOneLead(long id);
}
