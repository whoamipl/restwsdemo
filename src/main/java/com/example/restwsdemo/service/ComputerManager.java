package com.example.restwsdemo.service;


import com.example.restwsdemo.domain.Computer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Stateless
public class ComputerManager {

    private List<Computer> storage = Collections.synchronizedList(new ArrayList<Computer>());

    @PersistenceContext
    EntityManager em;

    public ComputerManager() {
        storage.add(new Computer("Kabby", 16, "Ryzen 7", 1, "GTX 1080Ti", 2999,1, producentName));
        storage.add(new Computer("Core", 1, "Intel C2D", 40, "GT9500", 100,1, producentName));
        storage.add(new Computer("Cube", 8, "Intel i7-9600K", 2, "GTX 1080Ti", 5999,1, producentName));
    }


    public Computer getComputer(Integer id) {

        Computer computer = storage.get(id);
        if (computer == null) return new Computer();
        return computer;
    }

//    public List<Computer> getAllComputers() {
//        return storage;
//    }
    public void addComputer(Computer computer) {

        em.persist(computer);
    }

    public List<Computer> getAllComputer() {
        return  storage;
    }

    public java.lang.String test() {return "REST Service is running";}

    public void removeComputer(Long id) {
        em.remove(id);
    }

}
