package com.outlyer.jmx.jmxquery.tests;

import com.outlyer.jmx.jmxquery.JMXQuery;
import com.outlyer.jmx.jmxquery.tools.JMXTools;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Runs set of tests for JMXQuery command line tool
 * 
 * @author dgildeh
 */
public class JMXQueryTest {
    
    public JMXQueryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testHelpPage() throws Exception {
        //JMXQuery.main(new String[]{"-help"});
        // TODO - Figure out way to test without System.exit() crashing JUnit
    }
    
    @Test
    public void testUrlConnection() throws Exception {

        String url = "service:jmx:rmi://localhost:1099/jndi/rmi://localhost:1099/jmxrmi";
        //String url = JMXTools.getLocalJMXConnection("org.netbeans.Main");
        System.out.println("Connection URL: " + url);
        
        JMXQuery.main(new String[]{"-url", url, 
                        "-query",
                        "java.lang:type=ClassLoading/LoadedClassCount;"
                      + "java.lang:type=Memory/HeapMemoryUsage/max"});
    }
    
    @Test
    public void testListMBeans() throws Exception {

        String url = "service:jmx:rmi://localhost:1099/jndi/rmi://localhost:1099/jmxrmi";
//        String url = JMXTools.getLocalJMXConnection("org.netbeans.Main");
        System.out.println(url);
        
        JMXQuery.main(new String[]{"-url", url, "-query", "*:*"});
    }
}