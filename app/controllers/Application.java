package controllers;

import models.Showing;
import play.*;
import play.data.Form;
import play.mvc.*;

import sun.security.krb5.internal.Ticket;
import views.html.*;

public class Application extends Controller {


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

    public static Result getDetailView(String showingUrl) {
        return TODO;
        //return ok(Showing.detailViewByUrl(showingUrl));
    }
}
