package com.lti.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lti.RestTemplateModels.RestAddBeneficiarytTemplate;
import com.lti.RestTemplateModels.RestDisplayBeneficiaryTemplate;
import com.lti.dao.BeneficiaryDao;
import com.lti.model.AddBeneficiary;

@Service
public class AddBeneficiaryServiceImpl implements AddBeneficiarService {
	
	@Autowired
	private BeneficiaryDao beneficarydao;

	public BeneficiaryDao getBeneficarydao() {
		return beneficarydao;
	}

	public void setBeneficarydao(BeneficiaryDao beneficarydao) {
		this.beneficarydao = beneficarydao;
	}

	public AddBeneficiaryServiceImpl(BeneficiaryDao beneficarydao) {
		super();
		this.beneficarydao = beneficarydao;
	}

	public AddBeneficiaryServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public ResponseEntity<RestAddBeneficiarytTemplate> addBeneficiary(AddBeneficiary add){
		return beneficarydao.addBeneficiary(add);
	}

	@Transactional
	@Override
	public ResponseEntity<RestDisplayBeneficiaryTemplate> displayBeneficiary(Integer accountNo) {
		return beneficarydao.displayBeneficiary(accountNo);
	}
	

}
