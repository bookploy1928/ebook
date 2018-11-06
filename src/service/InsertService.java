/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import Data.Book;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Iterator;
import org.bson.Document;
/**
 *
 * @author kong
 */
public class InsertService {
    static MongoClient connectMlab = new MongoClient(new MongoClientURI("mongodb://admin:admin02@ds247223.mlab.com:47223/ebook"));
    static MongoDatabase db = connectMlab.getDatabase("ebook");
    static MongoCollection<Document> DBCollection;
    
    public static boolean hasEmptyFields(Book ebook) {
        if (ebook.geteBookName().length() < 1              
                || ebook.getpublisherName().length() < 1
                || ebook.getauthorName().length() < 1
                || ebook.geteBookPrice() < 1
                 || ebook.getfileBookSize() < 1
                || ebook.getepages() < 1
                || ebook.getfileEbook().length() < 1
                || ebook.geteBookCoverPrice() < 1 
                         
               
            ){
            
            return true;
        }
        return false;
    }
    
    public static boolean isNameBookEquals(Book ebook) {
         try {
            DBCollection = db.getCollection("Book");
            Document searcheBookName = new Document("BookName", ebook.geteBookName());
            FindIterable<Document> iterateDoc = DBCollection.find(searcheBookName);
            Iterator<Document> iterator = iterateDoc.iterator();
            while (iterator.hasNext()) {
                Document data = new Document(iterator.next());
                if (data.getString("BookName").equals(ebook.geteBookName())) {
                    return true;
                }
            }
        } catch (Exception eX) {
            eX.printStackTrace();
        }
        return false;
    }
    
    
}
