package org.buap.hospitalpuebla.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.buap.hospitalpuebla.dao.AbstractDAO;
import org.buap.hospitalpuebla.dao.ICitaDAO;
import org.buap.hospitalpuebla.model.Cita;

@Stateless
public class CitaDAOLocal extends AbstractDAO<Cita> implements ICitaDAO {

    @PersistenceContext(unitName = "hospitalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitaDAOLocal() {
        super(Cita.class);
    }

}
