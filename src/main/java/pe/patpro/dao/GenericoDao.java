/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.patpro.dao;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dev-out-04
 * @param <Entidad>
 * @param <TipoLlave>
 */
@Transactional
public interface GenericoDao<Entidad, TipoLlave> {

    List<Entidad> listar(Class<Entidad> claseEntidad);

    Entidad insertar(Entidad entidad);

    Entidad actualizar(Entidad entidad);

    void eliminar(Entidad entidad);

    Entidad obtener(Class<Entidad> claseEntidad, TipoLlave id);
}
