package org.example.exercice8.service;

import org.example.exercice8.data.Bdd;
import org.example.exercice8.model.Cars;

import java.util.List;
import java.util.Optional;

public class CarService {
    public  boolean save(int id, String marque, int anneeFabrication, String couleur) {
       Cars car =  new Cars(id, marque, anneeFabrication, couleur);
        Bdd.cars.add(car);
         return true;
    }

    public Cars update(int id, Cars car) {
        for (Cars c : Bdd.cars) {
            if (c.getId() == id) {
                c.setMarque(car.getMarque());
                c.setAnneeFabrication(car.getAnneeFabrication());
                c.setCouleur(car.getCouleur());
                return c;
            }
        }
        return null;
    }


    public List<Cars> getAll() {
        return Bdd.cars;
    }

    public boolean delete(int id) {
        Bdd.cars.remove(id);
        return true;
    }

}
