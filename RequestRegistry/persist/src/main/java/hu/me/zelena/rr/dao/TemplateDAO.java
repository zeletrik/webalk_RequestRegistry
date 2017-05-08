package hu.me.zelena.rr.dao;

import hu.me.zelena.rr.model.Template;

import java.util.List;

public interface TemplateDAO {

    List<Template> findAll();

    Template findByName(String name);

    public void insertTemplate(Template template);

    public void deleteTemplate(Template template);

}
