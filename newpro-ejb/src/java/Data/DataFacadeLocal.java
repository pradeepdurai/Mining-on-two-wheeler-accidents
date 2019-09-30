/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kishore
 */
@Local
public interface DataFacadeLocal {

    void create(Data data);

    void edit(Data data);

    void remove(Data data);

    Data find(Object id);

    List<Data> findAll();

    List<Data> findRange(int[] range);

    int count();
    
}
