package workflow.usuario;

import workflow.framework.Params;
import workflow.framework.Workflow;
import workflow.framework.nodos.Crendenciales;
import workflow.framework.nodos.EmailSender;
import workflow.framework.nodos.HttpRequest;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var httpRequest = new HttpRequest("Retrieving Posts",
                "https://jsonplaceholder.typicode.com/posts",
                PostSummaryJsonParser.INPUT_JSON_KEY);
        var jsonParser = new PostSummaryJsonParser(EmailSender.BODY_KEY);
        var mailtrapUser = requireEnv("MAILTRAP_USER");
        var mailtrapPassword = requireEnv("MAILTRAP_PASSWORD");
        var emailSender = new EmailSender("Send Summary",
                new Crendenciales(mailtrapUser, mailtrapPassword));
        var workflow = Workflow.createFrom(List.of(httpRequest, jsonParser, emailSender));
        workflow.run(Params.empty());
    }

    private static String requireEnv(String name) {
        var value = System.getenv(name);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Falta la variable de entorno requerida: " + name);
        }
        return value;
    }
}
