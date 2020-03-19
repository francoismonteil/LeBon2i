package DAO;

import java.util.Collection;

public interface Dao<T> {
    public boolean create(T obj);
    public T find(Class c, Integer id);
    public Collection<T> findAll(Class c);
    public boolean update(T obj);
    public boolean delete(T obj);
    public boolean deleteAll();
    public void close();/* Fermeture de connexion à la source de données */
}
