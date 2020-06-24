/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.patpro.servicio.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.patpro.dao.GenericoDao;
import pe.patpro.entidades.Libro;
import pe.patpro.excepcion.GeneralException;
import pe.patpro.servicio.LibroServicio;

/**
 *
 * @author dev-out-03
 */
@Service
@Transactional
public class LibroServicioImp implements LibroServicio {

    @Autowired
    private GenericoDao<Libro, Integer> libroDao;

    @Override
    public Libro insertar(Libro entidad) throws GeneralException {
        return libroDao.insertar(entidad);
    }

    @Override
    public Libro actualizar(Libro entidad) throws GeneralException {
        return libroDao.actualizar(entidad);
    }

    @Override
    public List<Libro> listar() throws Exception {
        return libroDao.listar(Libro.class);
    }

    @Override
    public Libro obtener(Class<Libro> aClass, Integer id) throws Exception {
        return libroDao.obtener(Libro.class, id);
    }

    @Override
    public boolean eliminar(Libro entidad) throws Exception {
        libroDao.eliminar(entidad);
        return true;
    }

}
