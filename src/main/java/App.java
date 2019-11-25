import spark.ModelAndView;
import java.util.ArrayList;
import java.util.HashMap;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.List;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

///////////////////////////////////////////////////////////////////
        get("/sightings-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightingsdisplay", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Sightings>  sightings = Sightings.getallsightings();
            model.put("sightings", sightings);
            return new ModelAndView(model, "displaysightings.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String ranger = request.queryParams("ranger");
            String location = request.queryParams("location");
            int animalId = Integer.parseInt(request.queryParams("animalId"));
            Sightings sightings = new Sightings(animalId, location, ranger);
            sightings.save();
            response.redirect("/sightingsdisplay");
            return  null;
        }, new HandlebarsTemplateEngine());
/////////////////////////////////////////////////////

        get("/Animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<EndageredAnimals>  endageredAnimals = EndageredAnimals.allEndAnimals();
            List<NotEndagered> notEndagereds = NotEndagered.all();
            model.put("Eanimal", endageredAnimals);
            model.put("Nanimal", notEndagereds);
            return new ModelAndView(model, "displayanimals.hbs");
        }, new HandlebarsTemplateEngine());

        post("/Animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String type = request.queryParams("type");

            if(type.equals("endangered")) {
                String health = request.queryParams("health");
                String age = request.queryParams("age");
                EndageredAnimals endangeredAnimal = new EndageredAnimals(name, health, age);
                endangeredAnimal.save();
            }
            else {
                NotEndagered notEndagered = new NotEndagered(name);
                notEndagered.save();
            }

            response.redirect("/Animals");
            return  null;

        }, new HandlebarsTemplateEngine());
        get("/Animals-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

//////////////////////////////////////////////////////////////


    }
}