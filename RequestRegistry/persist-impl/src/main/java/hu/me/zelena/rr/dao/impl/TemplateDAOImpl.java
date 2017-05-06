package hu.me.zelena.rr.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.me.zelena.rr.dao.TemplateDAO;
import hu.me.zelena.rr.model.Template;

@Repository
@Transactional
public class TemplateDAOImpl implements TemplateDAO {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Template> findAll() {
		List<Template> templates = 
				manager.createQuery("Select p From Template p", Template.class).getResultList();
	return templates;
	}

	@Override
	public Template findByName(String name) {
		return manager.find(Template.class, name);
	}

	@Override
	public void insertTemplate(Template template) {
		manager.persist(template);

	}

	@Override
	public void deleteTemplate(Template template) {
		manager.remove(template);
	}

}
