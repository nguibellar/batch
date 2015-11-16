/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.devware.batch.dao.Iface;

import java.util.List;
import org.devware.batch.model.Item;

/**
 * Cette interface constitue la dao de l items. 
 * Elle declare deux methodes pour effectuer des operation sur la BD
 * @see ItemDao
 */
public interface ItemDao {
    
   /**
    * Cette methode effectue la suppression d'un Item 
    * @Param item  item à supprimer
    * @return nombre de item supprimé
    */
    public int deleteItem (Item item);
    
   /**
    * Cette methode effectue la suppression d'une liste d Item 
    * @Param itemList liste d item 
    * @return nombre de item supprimé
    */
    public int deleteAllItem(List< ? extends Item> itemList);
    
}
