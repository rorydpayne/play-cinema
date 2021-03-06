import play.GlobalSettings;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.SimpleResult;

/**
 * Created by rory.payne on 20/05/2014.
 */
public class Global extends GlobalSettings {
    private class ActionWrapper extends Action.Simple {
        public ActionWrapper(Action<?> action) {
            this.delegate = action;
        }

        @Override
        public F.Promise<SimpleResult> call(Http.Context ctx) throws Throwable {
            F.Promise<SimpleResult> result = this.delegate.call(ctx);
        Http.Response response = ctx.response();
        response.setHeader("Access-Control-Allow-Origin", "*");
        return result;
    }
    }
    @Override
    public Action<?> onRequest(Http.Request request, java.lang.reflect.Method actionMethod) {
        return new ActionWrapper(super.onRequest(request, actionMethod));
    }
}
