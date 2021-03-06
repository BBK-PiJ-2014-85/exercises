package e12;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import e7.CircleList;
import e7.ListItem;

import org.junit.Test;

public class TestCircleList {

	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	CircleList list;

	@Before
	public void setUpStream() {
		System.setOut(new PrintStream(outContent));
	}

	@Before
	public void setUpList(){
		list = new CircleList();
	}
	

	@After
	public void  cleanUpStream() {
		System.setOut(null);
	}
	
	@Test
	public void testDeleteLastItemMatched() {
		list.addItem(new ListItem("Tom",18));
		list.deleteItem("Tom");
		list.printList();
		System.out.print(".");
		assertEquals(".", outContent.toString());
	}
	
	@Test
	public void testDeleteEmptyUnMatched() {
		list.deleteItem("Tom");
		list.printList();
		System.out.print(".");
		assertEquals(".", outContent.toString());
	}
	
	@Test 
	public void testAddFirstItem() {
		list.addItem(new ListItem("Tom",18));
		list.printList();
		assertEquals("Tom 18\n", outContent.toString());
	}
	
	@Test 
	public void testAddTwoItems() {
		list.addItem(new ListItem("Tom",18));
		list.addItem(new ListItem("Harry",20));
		list.printList();
		assertEquals("Tom 18\nHarry 20\n", outContent.toString());
	}
	
	@Test
	public void testAddDeleteAddItem() {
		list.addItem(new ListItem("Tom",18));
		list.deleteItem("Tom");
		list.addItem(new ListItem("Harry",20));
		list.printList();
		assertEquals("Harry 20\n", outContent.toString());
	}
	
	@Test
	public void testDeleteItemUnmatched() {
		list.addItem(new ListItem("Tom",18));
		list.addItem(new ListItem("Harry",20));
		list.deleteItem("Fred");
		list.printList();
		assertEquals("Tom 18\nHarry 20\n", outContent.toString());
	}
	
	@Test
	public void testDeleteMiddleOfThreeItems() {
		list.addItem(new ListItem("Tom",18));
		list.addItem(new ListItem("Fred", 50));
		list.addItem(new ListItem("Harry",20));
		list.deleteItem("Fred");
		list.printList();
		assertEquals("Tom 18\nHarry 20\n", outContent.toString());
	}
	
	@Test
	public void testDeleteFirstAfterAddingMultiple(){
		list.addItem(new ListItem("Tom",18));
		list.addItem(new ListItem("Fred", 50));
		list.addItem(new ListItem("Harry",20));
		list.deleteItem("Tom");
		list.printList();
		assertEquals("Fred 50\nHarry 20\n", outContent.toString());
	}


}
