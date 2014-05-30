package controllers;

import models.Showing;
import play.*;
import play.data.Form;
import play.mvc.*;

import sun.security.krb5.internal.Ticket;
import views.html.*;

public class Application extends Controller {

    public static Result preflight(String all) {
        response().setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        response().setHeader(ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, PUT, DELETE, OPTIONS");
        response().setHeader(ACCESS_CONTROL_ALLOW_HEADERS, "Accept, Origin, Content-Type, X-Json, X-Prototype-Version, X-Requested-With, Referer, User-Agent");
        return ok();
    }
    public static Result index() {
        return redirect(routes.Application.getListView());
    }

    public static Result getListView() {
        return ok(Showing.listView()).as("application/json");
    }
//
//        Showing.updateTicketsBooked(4,"pulp-fiction", "Friday 1st August", "1pm");
//        String listView = Showing.listView();
//        String wizard = Showing.detailViewByUrl("the-wizard-of-oz");
//        String citizenKane= Showing.detailViewByUrl("citizen-kane");
//        String darkKnight = Showing.detailViewByUrl("the-dark-knight");
//        String theGodfather = Showing.detailViewByUrl("the-godfather");
//        String goodBadUgly = Showing.detailViewByUrl("the-good-the-bad-and-the-ugly");
//        String thirdMan = Showing.detailViewByUrl("the-third-man");
//        String pulpFiction = Showing.detailViewByUrl("pulp-fiction");
//        String ticketPrices = Showing.getTicketPrices();
//        String screenCapacity = Showing.getScreenCapacity(2);
//        String opportunities = Showing.getOpportunities("the-wizard-of-oz");
//        String titles = Showing.getTitles().toString();
//        return ok("BLOG SITE JSON: " + "\n\n" + listView + "\n\n\n\n\n"
//                + "DETAIL PAGE JSON" + "\n\n" + wizard + "\n\n\n\n\n"
//                + "DETAIL PAGE JSON" + "\n\n" + citizenKane + "\n\n\n\n\n"
//                + "DETAIL PAGE JSON" + "\n\n" + darkKnight + "\n\n\n\n\n"
//                + "DETAIL PAGE JSON" + "\n\n" + theGodfather + "\n\n\n\n\n"
//                + "DETAIL PAGE JSON" + "\n\n" + goodBadUgly + "\n\n\n\n\n"
//                + "DETAIL PAGE JSON" + "\n\n" + thirdMan + "\n\n\n\n\n"
//                + "DETAIL PAGE JSON" + "\n\n" + pulpFiction + "\n\n\n\n\n"
//                + "GET MOVIE TITLES" + "\n\n" + titles + "\n\n\n\n\n"
//                + "TICKET PRICES" + "\n\n" + ticketPrices+ "\n\n\n\n\n"
//                + "GET SCREEN CAPACITY PER SHOWING" + "\n\n" + screenCapacity + "\n\n\n\n\n"
//                + "GET OPPORTUNITIES PER FILM" + "\n\n" + opportunities + "\n\n\n\n\n"
//        );
//    }

    public static Result getDetailView(String showingId) {
        return ok(Showing.detailViewByUrl(showingId)).as("application/json");
    }

    public static Result getTimes(String showingId, String date) {
        return ok(Showing.getTimes(showingId, date)).as("application/json");
    }

    public static Result getTitles() {
        return ok(Showing.getTitles().toString()).as("application/json");
    }

    public static Result getOpportunities(String movie_url) {
        return ok(Showing.getOpportunities(movie_url)).as("application/json");
    }

    public static Result getPrices() {
        return ok(Showing.getTicketPrices()).as("application/json");
    }
}
