//package pl.coderslab.workshop.model.dto;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.*;
//
//public class VisitDayMapTest {
//
//    private Map<LocalDate, List<LocalTime>>mapa=new HashMap<>();
//
//    public VisitDayMapTest(LocalDate date,LocalTime time) {
//        if (mapa.get(date)==null){
//            List<LocalTime> timeList = new ArrayList<>();
//            timeList.add(time);
//            mapa.put(date,timeList);
//        }else {
//            mapa.get(date).add(time);
//        }
//    }
//}
