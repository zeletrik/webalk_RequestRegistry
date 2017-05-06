package hu.me.zelena.rr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.me.zelena.rr.dao.TemplateDAO;
import hu.me.zelena.rr.model.Template;

@Service
public class TemplateManagerImpl implements TemplateManager {
	
	@Autowired
	TemplateDAO dao;

	@Override
	public List<Template> findAll() {
		return dao.findAll();
	}

	@Override
	public Template findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertTemplate(Template template) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTemplate(Template template) {
		// TODO Auto-generated method stub

	}

}
