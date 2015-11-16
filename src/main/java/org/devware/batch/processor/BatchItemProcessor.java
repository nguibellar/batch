package org.devware.batch.processor;

import org.devware.batch.model.Item;
import org.springframework.batch.item.ItemProcessor;

/**
 * Cette classe represente le processuer de traitement des item. 
 * Elle effectu le traitement approprié aux donnée
 * @see ItemValidator
 */
public class BatchItemProcessor implements ItemProcessor<Item, Item> {
                
        @Override
	public Item process(final Item item)throws Exception {
                
                return item;
	}
}