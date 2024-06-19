package org.example.exercice8.ressource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.exercice8.model.Cars;
import org.example.exercice8.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Path("/cars")
public class CarsRessource {
    CarService carService = new CarService();
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

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean postCars(@FormParam("id") int id, @FormParam("marque") String marque,
                         @FormParam("anneeFabrication") int anneeFabrication, @FormParam("couleur") String couleur) {

        carService.save(id, marque, anneeFabrication, couleur);
        return true;
    }

    @DELETE
    @Path("{id}")
    public int delete(@PathParam("id")int id){
        return id;
    }

    @GET
    @Path("/allCar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cars> getAll(){
        return carService.getAll();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cars update(@PathParam("id")int id, Cars car){
        return carService.update(id, car);
    }




}
