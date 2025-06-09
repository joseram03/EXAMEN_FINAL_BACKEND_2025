package com.taller.services;

import com.taller.model.Servicio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class ConsultaService {

    @PersistenceContext(unitName = "ecommercePU")
    private EntityManager em;

    public List<Servicio> consultarServicios(Long clienteId, LocalDate fecha) {
        StringBuilder sb = new StringBuilder("SELECT s FROM Servicio s WHERE 1=1");

        if (clienteId != null) {
            sb.append(" AND s.vehiculo.cliente.id = :clienteId");
        }
        if (fecha != null) {
            sb.append(" AND s.fecha = :fecha");
        }

        TypedQuery<Servicio> query = em.createQuery(sb.toString(), Servicio.class);

        if (clienteId != null) {
            query.setParameter("clienteId", clienteId);
        }
        if (fecha != null) {
            query.setParameter("fecha", fecha);
        }

        return query.getResultList();
    }
}
