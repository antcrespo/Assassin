package mercergroup.assassin.dao;

import mercergroup.assassin.core.models.Persistable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Bekreth on 11/26/16.
 */
public class AbstractDAO<T extends Persistable> implements BaseDAO<T> {
    protected final static Logger logger = LoggerFactory.getLogger(AbstractDAO.class);

    protected Class<T> clazz;

    protected EntityManager entityManager;
    protected EntityManager em;

    protected AbstractDAO(Class<T> clazz)
    {
        setClazz(clazz);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.em = entityManager;
    }

    public Class<T> getClazz() {
        return clazz;
    }


    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T getObj(Object id) {
        if ( null == id ) {
            return null;
        }
        return (T)em.find(clazz, id);
    }

    @Override
    public T insertObj(T obj) {
        em.persist(obj);
        return obj;
    }

    /**
     * To update an entity, we first have to get a copy of
     * an attached entity.  Then copy the new attributes
     * and save.
     */
    @Override
    public T updateObj(T obj) {
        T existingObj = em.merge(obj);
        return existingObj;
    }

    @Override
    public T saveObj(T obj) {
        if ( null == obj ) {
            return null;
        }
        if ( obj.getId() != null ) {
            return updateObj(obj);
        } else {
            return insertObj(obj);
        }

    }

    @Override
    public T deleteObj(T obj) {
        if ( null == obj ) {
            return obj;
        }
        T objx = getObj(obj.getId());
        if ( null != objx) {
            objx = em.merge(objx);
            em.remove(objx);
        }
        return objx;
    }
}
