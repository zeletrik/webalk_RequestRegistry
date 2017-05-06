package hu.me.zelena.rr.service;

import java.util.List;

import hu.me.zelena.rr.model.Template;

public interface TemplateManager {
	
	List<Template> findAll();
	Template findByName(String name);
    public void insertTemplate(Template template);
    public void deleteTemplate(Template template);

}
