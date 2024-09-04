package repository.inter;

import java.util.List;

/**
 *
 * @author Radin
 */
public interface Repository<T> {
    List<T> getAll(T param) throws Exception;
    void add(T param) throws Exception;
    void edit(T param) throws Exception;
    void delete(T param)throws Exception;
}