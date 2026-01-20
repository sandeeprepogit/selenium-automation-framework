package DBUtils;

import com.mongodb.client.*;

public class MogoDB {

    void connectToMongoDB(){

        String mongoUri ="";
        String dbName="";
        try{
            MongoClient clients = MongoClients.create(mongoUri);
//            Document doc= clients.getDatabase(dbName).runCommand(new Document("",1));
        for (String list:clients.listDatabaseNames()){
            System.out.println("List of DataBase::"+list);
        }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
