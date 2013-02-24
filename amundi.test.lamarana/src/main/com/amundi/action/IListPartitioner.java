package main.com.amundi.action;

import java.util.Collection;

public interface IListPartitioner<T> {
	
	Collection<Collection<T>> partition(Collection<T> items, int size);
	
}
