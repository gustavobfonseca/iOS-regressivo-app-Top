package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoDb {
    public static final String CONNECTION_STRING = "mongodb+srv://builders:CeKVLFNHP3CFgrzU@cluster0-pl-0.tswe9.mongodb.net/?retryWrites=true&w=majority";

    public static MongoClient getConnection() {
        MongoClient mongoClient = MongoClients.create(CONNECTION_STRING);
        return mongoClient;
    }
}
