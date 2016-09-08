package com.tianyl.utils;

import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

public class MongoUtil {

	public static DBCollection getDbCollection(String host, Integer port, String dbName, String collectionName) {
		try {
			Mongo mongo = new MongoClient(host, port);
			mongo.setWriteConcern(WriteConcern.SAFE);
			return mongo.getDB(dbName).getCollection(collectionName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static DBCollection getDbCollection(String host, String dbName, String collectionName) {
		return getDbCollection(host, 27017, dbName, collectionName);
	}

}
