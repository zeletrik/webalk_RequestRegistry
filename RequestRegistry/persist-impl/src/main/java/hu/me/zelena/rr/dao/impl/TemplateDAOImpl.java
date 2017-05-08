package hu.me.zelena.rr.dao.impl;

import hu.me.zelena.rr.dao.TemplateDAO;
import hu.me.zelena.rr.model.Template;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

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
        return manager.createQuery("SELECT c from Template c WHERE c.title LIKE ?", Template.class).setParameter(1, name).getSingleResult();
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
