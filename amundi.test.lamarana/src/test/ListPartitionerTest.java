package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import main.com.amundi.impl.ListPartitioner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author LamDIALLO
 * @Projet : Test technique Amundi
 */
public class ListPartitionerTest {
	
	// Example 1: partition([1,2,3,4,5], 2) ˆ[ [1,2], [2,3], [5] ]
	// Example 2: partition([1,2,3,4,5], 3) ˆ[ [1,2,3], [4,5] ]
	// Example 3: partition([1,2,3,4,5], 1) ˆ[ [1], [2], [3], [4], [5] ]
	
	private static List<Integer> inputCollection;
	
	private static Collection<Collection<Integer>> output1;
	
	private static ListPartitioner<Integer> listPartitioner;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		inputCollection = Arrays.asList(1, 2, 3, 4, 5, 6);
		listPartitioner = new ListPartitioner<Integer>();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		inputCollection = null;
		listPartitioner = null;
	}
	
	@Before
	public void setUp() throws Exception {
		output1 = new ArrayList<Collection<Integer>>();
	}
	
	@After
	public void tearDown() throws Exception {
		output1 = null;
	}
	
	// cas size < 0
	@Test
	public void testPartition_size_Inf0() {
		Collection<Collection<Integer>> output2 = listPartitioner.partition(inputCollection, -5);
		assertNull("Le retour doit etre null", output2);
	}
	
	// cas size 0
	@Test
	public void testPartition_size_0() {
		Collection<Collection<Integer>> output2 = listPartitioner.partition(inputCollection, 0);
		assertNull("Le retour doit etre null", output2);
	}
	
	// cas size = 2
	@Test
	public void testPartition_size_2() {
		int size = 2;
		output1.add(Arrays.asList(1, 2));
		output1.add(Arrays.asList(3, 4));
		output1.add(Arrays.asList(5, 6));
		
		Collection<Collection<Integer>> output2 = listPartitioner.partition(inputCollection, size);
		assertEquals("Les objets doivent etre egaux", output1, output2);
	}
	
	// cas size = 5
	@Test
	public void testPartition_size_5() {
		int size = 5;
		output1.add(Arrays.asList(1, 2, 3, 4, 5));
		output1.add(Arrays.asList(6));
		
		Collection<Collection<Integer>> output2 = listPartitioner.partition(inputCollection, size);
		assertEquals("Les objets doivent etre egaux", output1, output2);
	}
	
	// cas size > 6
	@Test
	public void testPartition_size_Sup6() {
		int size = 8;
		output1.add(Arrays.asList(1, 2, 3, 4, 5, 6));
		
		Collection<Collection<Integer>> output2 = listPartitioner.partition(inputCollection, size);
		assertEquals("Les objets doivent etre egaux", output1, output2);
	}
	
}
