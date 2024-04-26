package kz.kstu.ilkov.coursework.service;

import kz.kstu.ilkov.coursework.entity.Client;
import kz.kstu.ilkov.coursework.entity.Tour;

import java.util.List;

public interface FileService {
    List<String> readAllCountry();
    List<String> readSityByCountry(String country);
    String readDescriptionByCountry(String country);
    List<String> readAllTransportType();
    List<List<String>> readAllClient();
    boolean writeAllClients(List<Client> clientList);
    boolean writeAllTours(List<Tour> tourList);
}
