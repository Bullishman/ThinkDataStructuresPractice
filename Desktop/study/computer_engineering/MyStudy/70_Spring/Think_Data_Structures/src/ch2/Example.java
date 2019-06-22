package ch2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Example {
    List empty;
    
    @Before public void initialize() {
    	empty= new ArrayList();
    	System.out.println("3");
    }
    @Test public void size() {
       System.out.println("1");
    }
    @Test public void remove() {
    	System.out.println("2");
       
    }
     
 }


