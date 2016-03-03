package org.buap.hospitalpuebla.service.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.buap.hospitalpuebla.dao.ICitaDAO;
import org.buap.hospitalpuebla.model.Cita;
import org.buap.hospitalpuebla.service.ICitaService;

@Stateless
public class CitaServiceLocal implements ICitaService {

    // TODO 12 inyectar cita DAO

    @Override
    public List<Cita> findAll() {
        return citaDAO.findAll();
    }

    @Override
    public void create(Cita cita) {
        citaDAO.create(cita);
    }

    @Override
    public void remove(Cita cita) {
        citaDAO.remove(cita);
    }

    @Override
    public Cita find(Cita cita) {
        return citaDAO.find(cita);
    }

    @Override
    public void edit(Cita cita) {
        citaDAO.edit(cita);

    }

}
