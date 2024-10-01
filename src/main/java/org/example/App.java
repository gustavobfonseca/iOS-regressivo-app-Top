package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MalformedURLException {

        MongoClient mongoClient = MongoClients.create("mongodb+srv://builders:CeKVLFNHP3CFgrzU@cluster0-pl-0.tswe9.mongodb.net/?retryWrites=true&w=majority");

        List<String> databaseNames = mongoClient.listDatabaseNames().into(new ArrayList<>());

        for (String dbName : databaseNames) {
            System.out.println("Nome do banco de dados: " + dbName);
        }

        mongoClient.close();
    }
}
