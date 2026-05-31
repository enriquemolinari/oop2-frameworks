package librerias.json;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        String json = "{\"nombre\":\"José\", \"edad\":25}";
        Gson gson = new Gson();

        // Parse JSON string to User class
        User user = gson.fromJson(json, User.class);

        System.out.println(user.nombre()); // salida: Bob
        System.out.println(user.edad()); // salida: 25
    }
}

record User(String nombre, int edad) {

}
