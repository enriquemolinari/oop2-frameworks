package javalin;

import io.javalin.Javalin;
import io.javalin.http.HttpStatus;
import javalin.controllers.DemoController;
import javalin.controllers.JsonController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.routes.apiBuilder(() -> {
                get("/bla", new DemoController());
                get("/json", new JsonController());
            });
            config.routes.exception(Exception.class, (ex, ctx) -> {
                Map<String, Object> body = new HashMap<>();
                body.put("error", ex.getClass().getName());
                body.put("message", ex.getMessage());
                body.put("timestamp", LocalDateTime.now());
                body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.getCode());
                ctx.json(body);
            });
        }).start(7070);
    }
}
