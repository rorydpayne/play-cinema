package models;

/**
 * Created by rory.payne on 07/05/14.
 */
public class WhenWhere {
    public String time;
    public int screen;
    public int tickets_booked;

    public WhenWhere() {

    }

    public WhenWhere(String time, int screen, int tickets_booked) {
        this.time = time;
        this.screen = screen;
        this.tickets_booked = tickets_booked;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getScreen() {
        return screen;
    }

    public void setScreen(int screen) {
        this.screen = screen;
    }

    public int getTickets_booked() {
        return tickets_booked;
    }

    public void setTickets_booked(int tickets_booked) {
        this.tickets_booked = tickets_booked;
    }
}
