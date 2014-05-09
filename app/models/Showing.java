package models;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.lang.Object;


import com.mongodb.*;
import com.mongodb.QueryBuilder;
import org.bson.BSONObject;
import scala.util.parsing.json.JSONArray;
import scala.util.parsing.json.JSONObject;


/**
 * Created by rory.payne on 02/05/14.
 */

public class Showing {

    public String id;

    public String movie_title;
    public String[] director;
    public String[] cast;
    public String release_date;
    public double running_length;
    public String age_rating;
    public String age_rating_img_url;
    public String synopsis;
    public String img_url;
    public Map<String, Double> prices;
    public Map<String, Object[]> time_and_date;


    public Showing() {

    }

    public Showing(String movie_title,
                   String[] director,
                   String[] cast,
                   String release_date,
                   double running_length,
                   String age_rating,
                   String age_rating_img_url,
                   String synopsis,
                   String img_url,
                   Map<String, Double> prices,
                   Map<String, Object[]> time_and_date) {
        this.movie_title = movie_title;
        this.director = director;
        this.cast = cast;
        this.release_date = release_date;
        this.running_length = running_length;
        this.age_rating = age_rating;
        this.age_rating_img_url = age_rating_img_url;
        this.synopsis = synopsis;
        this.img_url = img_url;
        this.prices = prices;
        this.time_and_date = time_and_date;
    }

    /*
        below follows the RUD methods for the play API. Creation is dealt with
        directly with a mongo shell
     */
    // Display the JSON required for filmList page as string
    public static String listView() {
        MongoProcess mp = new MongoProcess();
        DBCollection coll = mp.db.getCollection("showings");

        BasicDBObject keys = new BasicDBObject();
        keys.put("movie_title", 1);
        keys.put("url", 1);
        keys.put("img_url", 1);
        keys.put("synopsis", 1);
        keys.put("_id", 0);
        DBCursor all = coll.find(null, keys);
        String list = all.toArray().toString();
        return list;
    }

    // Display the JSON required for filmDetail page as String
    public static String detailViewByUrl(String MovieUrl) {
        MongoProcess mp = new MongoProcess();
        DBCollection coll = mp.db.getCollection("showings");

        BasicDBObject query = new BasicDBObject();
        query.put("url", MovieUrl);

        BasicDBObject fields = new BasicDBObject();
        fields.put("movie_title", 1);
        fields.put("img_url", 1);
        fields.put("director", 1);
        fields.put("cast", 1);
        fields.put("release_date", 1);
        fields.put("running_length", 1);
        fields.put("synopsis", 1);
        fields.put("_id", 0);

        DBCursor cursor = coll.find(query, fields);

        String returnRecord = "";

        while (cursor.hasNext()) {
            returnRecord = cursor.next().toString();
        }
        return returnRecord;
    }

    public static List<String> getTitles() {
        List<String> titles = new ArrayList<String>();
        MongoProcess mp = new MongoProcess();
        DBCollection coll = mp.db.getCollection("showings");

        BasicDBObject fields = new BasicDBObject();
        fields.put("movie_title", 1);
        fields.put("_id", 0);
        DBCursor all = coll.find(null, fields);
        List<DBObject> dbList = all.toArray();
        for (int i=0; i<dbList.size(); i++) {
            String title = dbList.get(i).toString();
            titles.add(title);
        }
        return titles;
    }

    public static String getOpportunities(String MovieUrl) {
        String opportunities= "";

        MongoProcess mp = new MongoProcess();
        DBCollection coll = mp.db.getCollection("showings");

        BasicDBObject query = new BasicDBObject();
        query.put("url", MovieUrl);

        BasicDBObject fields = new BasicDBObject();
        fields.put("opportunities", 1);
        fields.put("_id", 0);

        DBCursor cursor = coll.find(query, fields);

        while (cursor.hasNext()) {
            DBObject dbo = cursor.next();
            BasicDBList dbList = (BasicDBList)dbo.get("opportunities");
            opportunities = dbList.toString();
        }
        return opportunities;
    }


    public static String getScreenCapacity(int screenNumber) {
        String capacity = "";

        MongoProcess mp = new MongoProcess();
        DBCollection coll = mp.db.getCollection("screens");

        BasicDBObject query = new BasicDBObject();
        query.put("number", screenNumber);

        BasicDBObject fields = new BasicDBObject();
        fields.put("capacity", 1);
        fields.put("_id", 0);

        DBCursor cursor = coll.find(query, fields);

        while (cursor.hasNext()) {
            capacity = (cursor.next().toString());
        }
        return capacity;
    }

    public static String getTicketPrices(){
        String ticketPrices = "";

        MongoProcess mp = new MongoProcess();
        DBCollection coll = mp.db.getCollection("prices");

        BasicDBObject fields = new BasicDBObject();
        fields.put("ticketchoice", 1);
        fields.put("ticketprice", 1);
        fields.put("_id", 0);

        DBCursor all = coll.find(null, fields);
        return ticketPrices = all.toArray().toString();
    }

    public static void updateTicketsBooked(int totalTickets, String movieUrl, String date, String time) {
        MongoProcess mp = new MongoProcess();
        DBCollection coll  = mp.db.getCollection("showings");

        BasicDBObject query = new BasicDBObject();
        query.put("url", movieUrl);
        query.append("opportunities.date", date);
        query.append("opportunities.time", time);

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("$inc", new BasicDBObject()
                .append("opportunities.$.tickets_booked", totalTickets));

        coll.update(query, newDocument);

    }
}
