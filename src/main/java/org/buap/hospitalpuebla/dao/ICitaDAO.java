package org.buap.hospitalpuebla.dao;

import java.util.List;
import javax.ejb.Local;
import org.buap.hospitalpuebla.model.Cita;

@Local
public interface ICitaDAO {

    void create(Cita cita);

    void edit(Cita cita);

    void remove(Cita cita);

    Cita find(Object id);

    List<Cita> findAll();
}
