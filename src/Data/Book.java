package Data;


import java.awt.Image;
import org.bson.types.ObjectId;

public class Book {  
    public int eBookId;
    public String eBookName;
    public String eBookKinds;
    public String publisherName;
    public String authorName;
    public String linkFile;
    public String fileFormat;
    public int eBookPrice;
    public int eBookCoverPrice;
    public int fileBookSize;
    public int pages;
    public ObjectId eBookCover_id;
    public Book(int pages){
        this.pages = pages;
    }
    public Book(int eBookId,String eBookName,String eBookKinds,String publisherName,
            String authorName,String linkFile,int eBookPrice,int eBookCoverPrice,
            int fileEbookSize,int pages, ObjectId eBookCover_id) {
        this.eBookId = eBookId;
        this.eBookName = eBookName;
        this.publisherName = publisherName;
        this.authorName = authorName;
        this.linkFile = linkFile;
        this.eBookPrice = eBookPrice;
        this.eBookCoverPrice = eBookCoverPrice;
        this.fileBookSize = fileEbookSize;
        this.pages = pages;
        this.eBookKinds = eBookKinds;
        this.eBookCover_id = eBookCover_id;
    }
    
     public Book(int eBookId,String eBookName,String eBookKinds,String publisherName,
            String authorName,String fileFormat,int eBookPrice,int eBookCoverPrice,
            int fileEbookSize,int pages, String linkFile) {
        this.eBookId = eBookId;
        this.eBookName = eBookName;
        this.publisherName = publisherName;
        this.authorName = authorName;
        this.fileFormat = fileFormat;
        this.eBookPrice = eBookPrice;
        this.eBookCoverPrice = eBookCoverPrice;
        this.fileBookSize = fileEbookSize;
        this.pages = pages;
        this.eBookKinds = eBookKinds;
        this.linkFile = linkFile;
    }
    
    public String geteBookName() {
        return eBookName;
    }
 
     
      public String getpublisherName() {
        return publisherName;
    }
      
       public String getauthorName() {
        return authorName;
    }
       
        public String getfileEbook() {
        return linkFile;
    }
        
         public ObjectId geteBookCover_Id() {
        return eBookCover_id;
    }
         
          public int geteBookPrice() {
        return eBookPrice;
    }
          
           public int geteBookCoverPrice() {
        return eBookCoverPrice;
    }
           
     public int getfileBookSize() {
        return fileBookSize;
    }   
        public String geteBookKinds() {
        return eBookKinds;
    }
     public int getepages() {
        return pages;
    }
     public String toString(){
         return eBookId + "\n"
                 +eBookName+ "\n"
         +publisherName+ "\n"
         +authorName+ "\n"
         +fileFormat+ "\n"
         +eBookPrice+ "\n"
         +eBookCoverPrice+ "\n"
         +fileBookSize+ "\n"
         +pages+ "\n"
         +eBookKinds+ "\n" 
         +linkFile+ "\n";
     }
}
