package spring.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DemoController {
    @RequestMapping(method = RequestMethod.GET, path = "/hola")
    public String bla(@RequestParam String param1) {
        return "Hola Mundo! - Spring. Param: " + param1;
    }

    //https://jsonplaceholder.typicode.com/posts
    @RequestMapping(method = RequestMethod.GET, path = "/json")
    public ResponseEntity<List<Map<String, String>>> json() {
        var map = Map.of("userId", "1"
                , "id", "1"
                , "title", "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"
                , "body", "quia et suscipitnsuscipit recusandae consequuntur expedita et cumnreprehenderit molestiae ut ut quas totamnnostrum rerum est autem sunt rem eveniet architecto");
        //return ResponseEntity.internalServerError().build();
        return ResponseEntity.ok(List.of(map));
//        throw new RuntimeException("no puede generar json");
    }
}
