package controllers;

import models.Showing;
import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {


    public static Result index() {
        return redirect(routes.Application.getListView());
    }

    public static Result getListView() {
        //return ok(Showing.listView());
        return ok(Showing.detailViewByUrl("the-dark-knight"));
    }

    public static Result getDetailView(String showingUrl) {
        return ok(Showing.detailViewByUrl(showingUrl));
    }
}
