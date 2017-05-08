package hu.me.zelena.rr.service;

import hu.me.zelena.rr.dao.TemplateDAO;
import hu.me.zelena.rr.model.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return dao.findByName(name);
    }

    @Override
    public void insertTemplate(Template template) {
        dao.insertTemplate(template);

    }

    @Override
    public void deleteTemplate(Template template) {
        dao.deleteTemplate(template);

    }

}
