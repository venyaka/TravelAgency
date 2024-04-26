package kz.kstu.ilkov.coursework.service.impl;

import kz.kstu.ilkov.coursework.entity.Client;
import kz.kstu.ilkov.coursework.entity.Tour;
import kz.kstu.ilkov.coursework.service.FileService;

import java.io.*;
import java.util.*;

public class FileServiceImpl implements FileService {
    String path = "D:\\main\\studying\\univer\\univer_projects\\CoursWork\\target\\classes\\";
    public List<String> readAllCountry() {
        List<String> countries = new ArrayList<>();
        File directoryPath = new File(path + "tour/country");
        File[] filesList = directoryPath.listFiles();

        for(File file : filesList)
            countries.add(file.getName());

        return countries;
    }

    public List<String> readSityByCountry(String country) {
        return null;
    }

    public String readDescriptionByCountry(String country) {
        StringBuilder inputText = new StringBuilder();

        try {
            FileReader file = new FileReader(path + "tour/country/" + country + "/description.txt");

            int i;
            while ((i = file.read()) != -1)
                inputText.append((char)i);
        }
            catch (IOException e) {
            System.err.println(e);
        }
        return inputText.toString();
    }

    public List<String> readAllTransportType() {
        StringBuilder inputText = new StringBuilder();

        try {
            FileReader file = new FileReader(path + "tour\\type.txt");
            int i;
            while ((i = file.read()) != -1)
                inputText.append((char)i);
        }
            catch (IOException e) {
            System.err.println(e);
        }

        return Arrays.stream(inputText.toString().split(" ")).toList();
    }

    public List<String> findAllTourType() {
        StringBuilder inputText = new StringBuilder();

        try {
            FileReader file = new FileReader(path + "tour/type.txt");
            int i;

            while ((i = file.read()) != -1)
                inputText.append((char)i);
        }
            catch (IOException e) {
            System.err.println(e);
        }

        return Arrays.stream(inputText.toString().split(" ")).toList();
    }

    public List<List<String>> readAllClient() {
        List<List<String>> clientList = new ArrayList<>();
        StringBuilder inputText = new StringBuilder();

        try {
            FileReader file = new FileReader(path + "client/name.txt");
            int i;
            while ((i = file.read()) != -1)
                inputText.append((char)i);
        }
        catch (IOException e) {
            System.err.println(e);
        }

        List<String> splitText = Arrays.stream(inputText.toString().split("\n")).toList();

        for (int j = 0; j < splitText.size(); j++) {
            clientList.add(Arrays.stream(splitText.get(j).split(" ")).toList());
        }
        return clientList;
    }

    public boolean writeAllClients(List<Client> clientList) {
        ClassLoader classLoader = getClass().getClassLoader();
        StringBuilder outputText = new StringBuilder();
        try {
            for (Client client : clientList)
                outputText.append(client.toString());

            FileWriter file = new FileWriter(classLoader.getResource("out/clientList.txt").getFile());

            for (char i : outputText.toString().toCharArray()) {
                System.out.println(i);
                file.write(i);
            }

            file.close();
            return true;
        }
            catch (IOException e) {
            System.err.println(e);
        }
        return false;
    }

    public boolean writeAllTours(List<Tour> tourList) {
        return false;
    }
}
