package pe.patpro.dao.impl;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.patpro.util.Criterio;
import pe.patpro.dao.GenericoDao;

@Repository
public class GenericoDaoImpl<Entidad extends Serializable, TipoLlave extends Serializable> implements GenericoDao<Entidad, TipoLlave> {

    @Autowired
    protected SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public Entidad obtener(Class<Entidad> claseEntidad, TipoLlave id) {
        return (Entidad) this.sessionFactory.getCurrentSession().get(claseEntidad.getName(), id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Entidad insertar(Entidad entidad) {
        this.sessionFactory.getCurrentSession().save(entidad);
        return entidad;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Entidad actualizar(Entidad object) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(object);
        return object;
    }

    @Override
    public void eliminar(Entidad entidad) {
        this.sessionFactory.getCurrentSession().delete(entidad);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Entidad> listar(Class<Entidad> claseEntidad) {
        Criterio filtro = Criterio.forClass(claseEntidad);
        return listarPorCriteria(filtro);
    }

    @SuppressWarnings("unchecked")
    public List<Entidad> listarPorCriteria(Criterio filtro) {
        Criteria busqueda = filtro.getExecutableCriteria(this.sessionFactory.getCurrentSession());
        busqueda.setProjection(null);
        busqueda.setFirstResult(((Criterio) filtro).getFirstResult());
        return (List<Entidad>) busqueda.list();
    }

}
