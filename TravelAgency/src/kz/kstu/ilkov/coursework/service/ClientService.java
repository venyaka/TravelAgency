package kz.kstu.ilkov.coursework.service;

import kz.kstu.ilkov.coursework.entity.Client;
import kz.kstu.ilkov.coursework.entity.Tour;
import kz.kstu.ilkov.coursework.entity.User;

import java.util.List;

public interface ClientService {
    User createClient(String name, String surname);
    void addTour(Client client, Tour tour);

    Client findClientByName(List<Client> clientList, String name);

    Client findClientById(List<Client> clientList, Long id);

    void buyTour(Client client, Tour tour);
}
