/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.devware.batch.dao.Impl;

import java.util.List;
import org.devware.batch.dao.Iface.ItemDao;
import org.devware.batch.model.Item;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Cette classe constitue l implementation de la dao de l items. 
 * Elle definie deux methodes pour effectuer des operation sur la BD
 * Elle utilise l 'api jdbcDaoSupport pour recuperer le template jdbc
 * @see ItemDao JdbcDaoSupport
 */
public class ItemDaoImpl extends JdbcDaoSupport implements ItemDao {
    
    private static final String DELETE_ITEM_BY_NAME = "DELETE FROM ITEM WHERE ID=?";

    @Override
    @Transactional
    public int deleteItem(Item item) {
        
        // si l item est null ou l id de l item est nulll
        if (item == null || item.getId() == null) return 0;
        
        // on retourne le nombre d enregistrement trouvé
        return  getJdbcTemplate().
               update(DELETE_ITEM_BY_NAME,new Object[]{item.getId()});
    
    }
    
    
    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public int deleteAllItem(List<? extends Item> itemList) {
        
        int count =0;
        
        // si la liste est vide on retourne 0
        if (itemList == null || itemList.isEmpty()) return 0;
        
        /*
         *on parcour la liste en suppression
         */        
        for (Item item:itemList){
            
           count += deleteItem(item);
        }
        return count;
    }
    
}
