package models;

import java.util.List;
import java.util.Map;


import com.mongodb.*;


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
        this.movie_title=movie_title;
        this.director=director;
        this.cast=cast;
        this.release_date=release_date;
        this.running_length=running_length;
        this.age_rating=age_rating;
        this.age_rating_img_url=age_rating_img_url;
        this.synopsis=synopsis;
        this.img_url=img_url;
        this.prices=prices;
        this.time_and_date=time_and_date;
    }

//    public static List<Showing> all() {
//        return Showing.collection.find().toArray();
//    }

    public static String listView() {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            DB db = mongoClient.getDB("cinema");

            DBCollection coll= db.getCollection("showings");

            BasicDBObject keys = new BasicDBObject();
            keys.put("movie_title",1);
            keys.put("running_length",1);
            keys.put("age_rating",1);
            keys.put("img_url",1);
            keys.put("synopsis",1);
            keys.put("_id", 0);
            DBCursor all = coll.find(null, keys);

            return all.toArray().toString();

        }
        catch (Exception e) {
            return "oops" + e;
        }
    }

}
