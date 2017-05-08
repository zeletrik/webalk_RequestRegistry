package hu.me.zelena.rr.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "requests")
public class Request implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    private String user;
    private String reviewer;
    private String template;
    private String status;
    private String motivate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMotivate() {
        return motivate;
    }

    public void setMotivate(String motivate) {
        this.motivate = motivate;
    }


}
