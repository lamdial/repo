package main.com.amundi.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import main.com.amundi.action.IListPartitioner;

/**
 * @author LamDIALLO
 * @Projet : Test technique Amundi
 */
public class ListPartitioner<T> implements IListPartitioner<T> {
	
	public Collection<Collection<T>> partition(Collection<T> items, int size) {
		// check if collection is not empty and size of sub-collection > 0
		if (items != null && !items.isEmpty() && size > 0) {
			Collection<Collection<T>> outputCollection = new ArrayList<Collection<T>>();
			List<T> list = new ArrayList<T>();
			list.addAll(items);
			
			while (!list.isEmpty()) {
				if (list.size() <= size) {
					outputCollection.add(list);
					return outputCollection;
				}
				
				// add sub-collection if size < list size
				outputCollection.add(new ArrayList<T>(list.subList(0, size)));
				// remove all items added to outputCollection as sub-collection
				list.subList(0, size).clear();
			}
		}
		
		return null;
	}
	
}
