//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class OTPUtils {
    public static final String OTP_TOKEN_DATABASE = "buildersid-stg";
    public static final String OTP_TOKEN_COLLECTION = "OtpTokens";
    public static final String PHONENUMBER_OR_EMAIL_FIELD = "key";
    public static final String PHONE_NUMBER_OR_EMAIL_FIELD = "key";
    public static final String OTP_TOKEN_FIELD = "code";

    public OTPUtils() {
    }

    public static String getOTPtokenByPhoneNumberOrEmail(String phoneNumberOrEmail) {
        MongoClient mongoClient = MongoDb.getConnection();
        MongoDatabase database = mongoClient.getDatabase("buildersid-stg");
        MongoCollection<Document> collection = database.getCollection("OtpTokens");
        Document query = new Document("key", phoneNumberOrEmail);
        List<Document> result = (List)collection.find(query).into(new ArrayList());
        mongoClient.close();
        PrintStream var10000 = System.out;
        Document var10001 = (Document)result.get(0);
        var10000.println("ESSE É O TOKEN DE REDEFINIÇÃO DE SENHA: " + var10001.get("code").toString());
        return ((Document)result.get(0)).get("code").toString();
    }

    public static void main(String[] args) {
        getOTPtokenByPhoneNumberOrEmail("+5511922334456");
        //XCUIElementTypeOther[@name="Insira o código de segurança que enviamos para o seu ,testeca*****ail.com"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]
        //XCUIElementTypeOther[@name="Insira o código de segurança que enviamos para o seu ,testeca*****ail.com"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText
    }
}
