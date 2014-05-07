package models;

import javax.annotation.meta.When;

/**
 * Created by rory.payne on 07/05/14.
 */
public class Opportunity {
    public String date;
    public WhenWhere when_where;

    public Opportunity() {

    }

    public Opportunity(String date, WhenWhere when_where) {
        this.date = date;
        this.when_where = when_where;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public WhenWhere getWhenWhere() {
        return when_where;
    }

    public void setWhenWhere(WhenWhere when_where) {
        this.when_where = when_where;
    }
}
