package org.zer0.pocs.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class App{
	
	
	HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance();
	
    public static void main( String[] args ){
    	App a=new App();
    }
}
