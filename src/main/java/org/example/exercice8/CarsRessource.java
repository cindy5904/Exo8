package org.example.exercice8;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/cars")
public class CarsRessource {
    @GET
    @Path("/one")
    @Produces(MediaType.APPLICATION_JSON)
    public Cars getOneCar() {
        return new Cars(1, "Peugeot", 2015, "Noire");
    }
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cars> getAllCars() {
        List<Cars> carsList = new ArrayList<>();
        carsList.add(new Cars(1, "Peugeot", 2015, "Noire"));
        carsList.add(new Cars(2, "Renault", 2018, "Blanche"));
        carsList.add(new Cars(3, "Citroen", 2019, "Rouge"));

        return carsList;
    }

}
