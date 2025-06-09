package com.taller.services;

import com.taller.model.DetalleServicio;
import com.taller.model.Servicio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ServicioService {

    @PersistenceContext(unitName = "ecommercePU")
    private EntityManager em;

    public void registrarServicio(Servicio servicio) {
        // Asociar detalles con el servicio antes de persistir
        if (servicio.getDetalles() != null) {
            for (DetalleServicio detalle : servicio.getDetalles()) {
                detalle.setServicio(servicio);
            }
        }

        em.persist(servicio);
    }

    public Servicio buscarServicioPorId(Long id) {
        return em.find(Servicio.class, id);
    }
}
