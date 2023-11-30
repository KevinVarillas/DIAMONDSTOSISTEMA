/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author analu
 */
public class Session {
    
	private static Map<String,Object> datos;
	
	static {
		datos = new HashMap<>();
	}
	
	private Session() {
	}

	public static void put( String key, Object object){
		datos.put(key, object);
	}
	
	public static Object get( String key){
		return datos.get(key);
	}
}
