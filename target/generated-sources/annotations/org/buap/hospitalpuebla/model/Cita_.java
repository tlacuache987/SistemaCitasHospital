package org.buap.hospitalpuebla.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-01T23:28:21")
@StaticMetamodel(Cita.class)
public class Cita_ { 

    public static volatile SingularAttribute<Cita, String> doctor;
    public static volatile SingularAttribute<Cita, String> apellidoPaterno;
    public static volatile SingularAttribute<Cita, Date> fechaCita;
    public static volatile SingularAttribute<Cita, String> sexo;
    public static volatile SingularAttribute<Cita, String> nombre;
    public static volatile SingularAttribute<Cita, String> email;
    public static volatile SingularAttribute<Cita, String> apellidoMaterno;

}