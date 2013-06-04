package ie.ucc.bis.service;

import ie.ucc.bis.domain.Patient;


public class SupportingLifeService implements SupportingLifeServiceInf {

	public Patient getPatientById(long id) {
		return new Patient(id, "Todd Martin");
	}
}
