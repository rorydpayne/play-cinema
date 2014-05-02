package models;

import java.util.List;
import java.util.Map;
import play.modules.mongodb.jackson.MongoDB;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.ObjectId;


/**
 * Created by rory.payne on 02/05/14.
 */
public class Showing {

    @Id
    @ObjectId
    public String id;

    public String movie_title;
    public String[] director;
    public String[] cast;
    public String release_date;
    public String running_length;
    public String age_rating;
    public String age_rating_img_url;
    public String synopsis;
    public String img_url;
    public Map<String, String> prices;
    public Map<String, String> time_and_date;
    public Map<String, String> sales_data;

    public static JacksonDBCollection<Showing, String> collection = MongoDB.getCollection("showings",
                                                                                                  Showing.class,
                                                                                                  String.class
                                                                                                  );

    public Showing() {

    }

    public Showing(String movie_title,
                   String[] director,
                   String[] cast,
                   String release_date,
                   String running_length,
                   String age_rating,
                   String age_rating_img_url,
                   String synopsis,
                   String img_url,
                   Map<String, String> prices,
                   Map<String, String> time_and_date,
                   Map<String, String> sales_data) {
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
        this.sales_data=sales_data;
    }

    public List<String> getListPageData() {
        return Showing.collection.findOne().toString().toCharArray();
    }
}
