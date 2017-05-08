package hu.me.zelena.rr.dao.impl;

import hu.me.zelena.rr.dao.RequestDAO;
import hu.me.zelena.rr.model.Request;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RequestDAOImpl implements RequestDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Request> findAll() {
        List<Request> requests =
                manager.createQuery("Select p From hu.me.zelena.rr.model.Request p", Request.class).getResultList();
        return requests;
    }

    @Override
    public List<Request> findByUser(String username) {
        List<Request> requests
                = manager.createQuery("SELECT c from Request c WHERE c.user LIKE ?", Request.class).setParameter(1, username).getResultList();
        return requests;
    }

    @Override
    public Request find(int id) {
        return manager.find(Request.class, id);
    }

    @Override
    public void createRequest(Request request) {
        manager.persist(request);

    }

    @Override
    public void deleteRequest(Request request) {
        manager.remove(request);

    }

    @Override
    public void makeVerdict(int id, String verdict) {
        Request req = manager.find(Request.class, id);
        req.setStatus(verdict);

    }

    @Override
    public void forward(int id, String admin) {
        Request req = manager.find(Request.class, id);
        req.setReviewer(admin);
    }

    @Override
    public void addComment(int id, String comment) {
        Request req = manager.find(Request.class, id);
        req.setStatus(comment);
    }

}
