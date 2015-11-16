package org.devware.batch.writer;

import org.devware.batch.model.Item;
import java.util.List;

import org.springframework.batch.item.file.FlatFileItemWriter;

public class CustomFlatFileItemWriter extends FlatFileItemWriter<Item> {

	@Override
	public void write(List<? extends Item> arg0) throws Exception {
		
		super.write(arg0);
	}

}
