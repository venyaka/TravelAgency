package kz.kstu.ilkov.coursework.service.impl;

import kz.kstu.ilkov.coursework.config.Consts;
import kz.kstu.ilkov.coursework.entity.Client;
import kz.kstu.ilkov.coursework.entity.Tour;
import kz.kstu.ilkov.coursework.service.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    public Client createClient(String name, String surname) {
        Client client = new Client();
        client.setId(Consts.newClientId());
        client.setName(name);
        client.setSurname(surname);
        client.setDiscount(0);
        client.setPassword("password");
        client.login = client.getId().toString();
        return client;
    }

    public void addTour(Client client, Tour tour) {
        List<Tour> newTours = client.getTours();
        newTours.add(tour);
        client.setTours(newTours);
    }

    public Client findClientByName(List<Client> clientList, String name) {
        for (Client client : clientList)
            if (client.getName().equals(name))
                return client;
        return null;
    }
    public Client findClientById(List<Client> clientList, Long id) {
        for (Client client : clientList)
            if (client.getId().equals(id))
                return client;
        return null;
    }

    public void buyTour(Client client, Tour tour) {
        List<Tour> tours = client.getTours();
        tours.add(tour);
        client.setTours(tours);
        client.setCountOfBuysTours(client.getCountOfBuysTours() + 1);
    }
}
