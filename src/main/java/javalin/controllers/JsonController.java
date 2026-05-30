package javalin.controllers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class JsonController implements Handler {
    //https://jsonplaceholder.typicode.com/posts
    @Override
    public void handle(@NotNull Context context) throws Exception {
        var map = Map.of("userId", "1"
                , "id", "1"
                , "title", "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"
                , "body", "quia et suscipitnsuscipit recusandae consequuntur expedita et cumnreprehenderit molestiae ut ut quas totamnnostrum rerum est autem sunt rem eveniet architecto");

        throw new RuntimeException("no puede generar json");
        //context.json(List.of(map));
    }
}
