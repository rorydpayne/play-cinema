package models;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by rory.payne on 06/05/14.
 */
public class MongoProcess {

    MongoClient mongoClient;
    DB db;


    public MongoProcess() {
        try {
            mongoClient = new MongoClient("localhost", 27017);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        db = mongoClient.getDB("cinema");
    }



            /*
            * or to connect to replica set with
            * auto-detection of the primary
            */

            /*mongoClient = new MongoClient(Arrays.asList(
                    new ServerAddress("localhost", 27017),
                    new ServerAddress("localhost", 27018),
                    new ServerAddress("localhost", 27019)
            ));*/

}
