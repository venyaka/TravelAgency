package kz.kstu.ilkov.coursework.service;

import kz.kstu.ilkov.coursework.entity.Tour;

import java.util.List;

public interface TourService {
    Tour findById(List<Tour> tourList, long id);
    List<Tour> findByRegEx(List<Tour> tourList, String regex);

    List<Tour> replaceNameByRegEx(List<Tour> tourList, String regex, String replacement);
}
