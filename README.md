# Memcached with Spring Boot [![MIT license](https://img.shields.io/badge/license-GPL_3.0-yellow.svg)](https://raw.githubusercontent.com/CodeStuff-Repo/Spring_Memcached/master/LICENSE) [![Build Status](https://travis-ci.org/CodeStuff-Repo/Spring_Memcached.svg?branch=master)](https://travis-ci.org/CodeStuff-Repo/Spring_Memcached)

## Why Memcached ?
##### *Are you interacting with Database for each transaction?*
Then you must apply a cache mechanism to avoid multiple database calls and faster response.
## [Memcached](https://memcached.org/)
A free, opensource, in-memory caching system to speedup application by reducing database load.
## Memcached with Spring
In this project you will find basic usage of memcached in spring **REST** application.
## How to use?
### Add dependency
// For Gradle project add following dependency.

```groovy
compile("net.spy:spymemcached:2.12.3")
```
### Setup Memcached
Add ***MemcachedClient*** bean in your springboot config file.

```java
// Connecting to memcached
// [host = localhost ,PORT = 11211]
// Initializing MemcachedClient.
@Bean
	public MemcachedClient cacheClient() {
		InetSocketAddress ia = new InetSocketAddress("localhost", 11211);
		MemcachedClient cacheClient = null;
		try {
		 cacheClient = new MemcachedClient(ia);
		} catch (IOException e) {
			e.printStackTrace();
		}
		LOGGER.info("Cache setup done.");
		return cacheClient;
	}
```
#### Done !!!!
Now you are ready to use memcache hosted on your local machine.  
Its simple, right?

### Add something to cache
```java
@Autowired
private MemcachedClient memcachedClient;

memcachedClient.add(key, 0, value);
```
### Fetch from cache
```java
String value = (String) memcachedClient.get(key);
```

### Delete from cache
```java
memcachedClient.delete(key);
```

### Flush everything
```java
memcachedClient.flush();
```
## Want more?
Memcached provides lot more features for caching.  
Still confused ? then,
### Fork it and explore !!!!

## Technology Stacks
| Stack | Detail |
| ------ | ------ |
| Java | [Java 8](https://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html) |
|Spring boot| [2.0.3.RELEASE](https://github.com/spring-projects/spring-boot) |
|Database|MySql|
