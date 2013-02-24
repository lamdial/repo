package main.com.amundi.action;

import java.util.Collection;

/**
 * @author LamDIALLO
 * @Projet : Test technique Amundi
 */
public interface IListPartitioner<T> {
	
	Collection<Collection<T>> partition(Collection<T> items, int size);
	
}
