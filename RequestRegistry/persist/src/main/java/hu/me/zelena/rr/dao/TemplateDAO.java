package hu.me.zelena.rr.dao;

import java.util.List;

import hu.me.zelena.rr.model.Template;

public interface TemplateDAO {
	
	List<Template> findAll();
	Template findByName(String name);
    public void insertTemplate(Template template);
    public void deleteTemplate(Template template);

}
