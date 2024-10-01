package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class OTPUtils {

    public static final String OTP_TOKEN_DATABASE = "buildersid-stg";
    public static final String OTP_TOKEN_COLLECTION = "OtpTokens";
    public static final String PHONENUMBER_OR_EMAIL_FIELD = "key";
    public static final String PHONE_NUMBER_OR_EMAIL_FIELD = PHONENUMBER_OR_EMAIL_FIELD;
    public static final String OTP_TOKEN_FIELD = "code";

    public static String getOTPtokenByPhoneNumberOrEmail (String phoneNumberOrEmail) {
        MongoClient mongoClient = MongoDb.getConnection();
        MongoDatabase database = mongoClient.getDatabase(OTP_TOKEN_DATABASE);
        MongoCollection<Document> collection = database.getCollection(OTP_TOKEN_COLLECTION);
        Document query = new Document(PHONE_NUMBER_OR_EMAIL_FIELD, phoneNumberOrEmail);
        List<Document> result = collection.find(query).into(new ArrayList<>());;
        mongoClient.close();
        System.out.println("ESSE É O TOKEN DE REDEFINIÇÃO DE SENHA: " + result);
        return result.get(0).get(OTP_TOKEN_FIELD).toString();
    }
}
