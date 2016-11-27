package mercergroup.assassin.dao;

import mercergroup.assassin.core.models.Persistable;

/**
 * The base level interface for the DAO
 */
public interface BaseDAO<T extends Persistable> {

    public T getObj(Object objId);
    public T insertObj(T objToInsert);
    public T deleteObj(T objToDelete);
    public T saveObj(T objToSave);
    public T updateObj(T objToUpdate);

}
