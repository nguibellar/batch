package org.devware.batch.writer;

import org.devware.batch.model.Item;
import java.util.List;
import org.devware.batch.dao.Iface.ItemDao;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Cette classe implemente la logique du writer du Batch. 
 * Elle utilise la dao pour effectuer des operation sur la BD
 * @see ItemDao
 */

public class BatchItemWriter implements ItemWriter<Item> {
        
       /*
        *on injecte la Dao
        */
        @Autowired
        private ItemDao dao;
        
       /*
        * On implemente la methode du Writer
        * @Param pojo liste de item issu du BatchItemProcessor
        */
	@Override
	public void write(List<? extends Item> itemList) throws Exception {
		
                dao.deleteAllItem(itemList);
	}

}
