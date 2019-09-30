/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 18mx263
 */
@Local
public interface projectFacadeLocal {

    void create(project project);

    void edit(project project);

    void remove(project project);

    project find(Object id);

    List<project> findAll();

    List<project> findRange(int[] range);

    int count();
    
}
