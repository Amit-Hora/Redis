package com.ash.redispoc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisProductPrice {

	public static void main(String[] args) {
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
		Jedis jedis = pool.getResource();
		jedis.connect();
		

		 
		 jedis.zadd("JAVA_Product",100,"PID1");
		 jedis.zadd("JAVA_Product",10,"PID2");
		 jedis.zadd("JAVA_Product",11,"PID4");
		 jedis.zadd("JAVA_Product",1200,"PID3");
		 
		 Set<String> rangeofProducts = jedis.zrangeByScore("JAVA_Product", 10,100);
		 rangeofProducts.forEach(System.out::println);
		
		
		
	}
	
}
