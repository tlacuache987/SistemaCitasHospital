package org.buap.hospitalpuebla.service;

import java.util.List;
import javax.ejb.Local;
import org.buap.hospitalpuebla.model.Cita;

@Local
public interface ICitaService {

    public List<Cita> findAll();

    public void create(Cita cita);

    public void remove(Cita cita);

    public Cita find(Cita cita);
    
    public void edit(Cita cita);
    
}
