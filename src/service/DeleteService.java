
package service;
public class DeleteService {
    public static boolean searchIsvalid(String search){
        try{
           int id = Integer.parseInt(search);
           if(!search.equals("")&&id>-1){
               return true;
           }
       } catch(Exception eT){
           System.out.println("error = "+eT);
       }
        return false;
    }
}
