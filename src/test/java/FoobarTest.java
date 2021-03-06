package test.java;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;


import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

import javax.servlet.ServletException;
import org.apache.commons.collections4.map.LinkedMap;

//import org.mockito.*;
//import org.mockito.Mock;
import org.springframework.core.*;
import org.springframework.*;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import junit.framework.TestCase;
import release01.JavaServer01;

import org.apache.log4j.BasicConfigurator;
import org.json.JSONObject;
import org.junit.*;

public class FoobarTest 
{

	
	private JavaServer01 servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
	
    @BeforeClass
    public static void setUpClass() throws Exception 
    {
        // Code executed before the first test method
    	
    }

    @Before
    public void setUp() throws Exception 
    {
    	BasicConfigurator.configure();
    	servlet = new JavaServer01();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    	//MockitoAnnotations.initMocks(this);
        // Code executed before each test
    }
 
    @Test
    public void testOneThing() throws ServletException, IOException 
    {
    	//JavaServer01 js1 = new JavaServer01();
    	request.setQueryString("?file");
    	
    	servlet.doPost(request, response);
    	//System.out.println(response.getContentAsString());
    	 
    	ArrayList<String> phoneNumbers = JavaServer01.getPhoneNumbers();
    	 
    	JSONObject testObj = new JSONObject();

		for(int i = 0; i < phoneNumbers.size(); i++)
		{
			String strToSeperate = phoneNumbers.get(i);
			int idx = strToSeperate.indexOf("National");
			String seperated = strToSeperate.substring(idx, strToSeperate.length());
			strToSeperate = strToSeperate.substring(0, idx);
			testObj.put( seperated, strToSeperate );
		}
    	 
    	 assertEquals("{\"National Number: 9089089008\":\"Country Code: 1 \",\"National Number: 9099099009\":\"Country Code: 1 \"}", testObj.toString());
         /*assertEquals("{\r\n" + 
         		"  \"National Number: 9089089008\" : \"Country Code: 1 \",\r\n" + 
         		"  \"National Number: 9099099009\" : \"Country Code: 1 \"\r\n" + 
         		"}", response.getContentAsString());*/
         
    	
        // Code that tests one thing  
    	
    }

    @Test
    public void testAnotherThing() throws ServletException, IOException 
    {
    	
    	request.setQueryString("?9099059005");
    	 
    	
    	
   	 	servlet.doGet(request, response);
   	 	
   	 	ArrayList<String> phoneNumbers = JavaServer01.getPhoneNumbers();
   	 	
   	 	
   	 	assertEquals("Country Code: 1 National Number: 9099059005", phoneNumbers.get(0));
        // Code that tests another thing
    }
    /*
    @Test
    public void testSomethingElse() 
    {
        // Code that tests something else
    }*/

    @After
    public void tearDown() throws Exception 
    {
        // Code executed after each test 
    }
 
    @AfterClass
    public static void tearDownClass() throws Exception 
    {
        // Code executed after the last test method 
    }
}