/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.patpro.servicio;

import java.util.List;
import pe.patpro.entidades.Libro;

/**
 *
 * @author dev-out-03
 */
public interface LibroServicio {

    public Libro insertar(Libro entidad) throws Exception;

    public Libro actualizar(Libro entidad) throws Exception;

    public List<Libro> listar() throws Exception;

    public Libro obtener(Class<Libro> aClass, Integer id) throws Exception;

    public boolean eliminar(Libro entidad) throws Exception;
}
