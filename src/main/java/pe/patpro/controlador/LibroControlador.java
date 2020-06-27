/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.patpro.controlador;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.patpro.entidades.Libro;
import pe.patpro.servicio.LibroServicio;
import pe.patpro.util.Respuesta;

/**
 *
 * @author mario
 */
@RestController
@RequestMapping("/libro")
public class LibroControlador {

    @Autowired
    private LibroServicio libroServicio;

    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public Respuesta listar(HttpServletRequest request) throws Exception {
        Respuesta resp = new Respuesta();
        resp.setEstadoOperacion(Respuesta.EstadoOperacionEnum.ADVERTENCIA.getValor());
        try {
            List<Libro> libro = libroServicio.listar();
            if (libro != null && !libro.isEmpty()) {
                resp.setEstadoOperacion(Respuesta.EstadoOperacionEnum.EXITO.getValor());
                resp.setOperacionMensaje("Se han listado todos los registros.");
                resp.setExtraInfo(libro);
            } else {
                resp.setOperacionMensaje("No se encontraron libros en la base de datos.");
            }
        } catch (Exception e) {
            resp.setOperacionMensaje(e != null ? e.getMessage() : "Error Desconocido.");
        }
        return resp;
    }

    @RequestMapping(value = "crear", method = RequestMethod.POST)
    public Respuesta crear(@RequestBody Libro entidad) throws Exception {
        Respuesta resp = new Respuesta();
        resp.setEstadoOperacion(Respuesta.EstadoOperacionEnum.ADVERTENCIA.getValor());
        if (entidad != null) {
            try {
                Libro guardado = libroServicio.insertar(entidad);
                if (guardado != null) {
                    resp.setEstadoOperacion(Respuesta.EstadoOperacionEnum.EXITO.getValor());
                    resp.setOperacionMensaje("Libro insertado correctamente.");
                    resp.setExtraInfo(guardado);
                } else {
                    resp.setOperacionMensaje("La operación no dio resultados, o no se logró guardar en la base de datos.");
                }
            } catch (Exception e) {
                resp.setOperacionMensaje(e != null ? e.getMessage() : "Error Desconocido.");
            }
        } else {
            resp.setEstadoOperacion("La entidad libro carece de valores.");
        }
        return resp;
    }

    @RequestMapping(value = "editar", method = RequestMethod.PUT)
    public Respuesta actualizar(@RequestBody Libro entidad) throws Exception {
        Respuesta resp = new Respuesta();
        resp.setEstadoOperacion(Respuesta.EstadoOperacionEnum.ADVERTENCIA.getValor());
        if (entidad != null) {
            try {
                Libro pedidoGuardado = libroServicio.actualizar(entidad);
                if (pedidoGuardado != null) {
                    resp.setEstadoOperacion(Respuesta.EstadoOperacionEnum.EXITO.getValor());
                    resp.setOperacionMensaje("Libro modificado correctamente.");
                    resp.setExtraInfo(pedidoGuardado);
                } else {
                    resp.setOperacionMensaje("La operación no dio resultados, o no se logró guardar en la base de datos.");
                }
            } catch (Exception e) {
                resp.setOperacionMensaje(e != null ? e.getMessage() : "Error Desconocido.");
            }
        } else {
            resp.setEstadoOperacion("La entidad libro carece de valores.");
        }
        return resp;
    }

    @RequestMapping(value = "eliminar/{id}", method = RequestMethod.DELETE)
    public Respuesta eliminar(@PathVariable("id") Integer id) throws Exception {
        Respuesta resp = new Respuesta();
        resp.setEstadoOperacion(Respuesta.EstadoOperacionEnum.ADVERTENCIA.getValor());
        try {
            boolean resultado = libroServicio.eliminar(id);
            if (resultado) {
                resp.setEstadoOperacion(Respuesta.EstadoOperacionEnum.EXITO.getValor());
                resp.setExtraInfo(id);
                resp.setOperacionMensaje("Libro eliminado correctamente.");
            } else {
                resp.setOperacionMensaje("La operación no dio resultados, o no se logró eliminar en la base de datos.");
            }
        } catch (Exception e) {
            resp.setOperacionMensaje(e != null ? e.getMessage() : "Error Desconocido.");
        }
        return resp;
    }

}
