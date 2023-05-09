package com.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue( true );
        Map<String, Object> map = new HashMap<>();
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        List<Long> list1 = new ArrayList<>();
        list1.add(1L);
        list1.add(2L);
        map.put("hahaha",list);
        map.put("hahahaha",list1);
        map.forEach((t,u) -> {
            System.out.println(t+"------->"+u);
        });

        System.out.println("--------------------->");

        Set<String> s1 = map.keySet();
        for(String key : s1){
            List<Long> long1 = (List<Long>) map.get(key);
            System.out.println(long1);
        }

        System.out.println("--------------------->");

        Set<Map.Entry<String,Object>> en = map.entrySet();
        for(Map.Entry<String, Object> entry: en){

        }
    }
}


