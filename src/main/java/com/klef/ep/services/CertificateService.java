package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Certficate;
import com.klef.ep.models.Faculty;

@Remote
public interface CertificateService {
	 public String addCertificate(Certficate certficate);
	 public Certficate viewcerbyid(int studentId);
	 public List<Certficate> viewallcert();
}
