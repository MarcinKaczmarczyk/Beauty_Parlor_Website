package pl.coderslab.workshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.workshop.model.entity.*;
import pl.coderslab.workshop.repository.ClientVisitRepository;
import pl.coderslab.workshop.repository.EmployeeRepository;
import pl.coderslab.workshop.repository.VisitDayRepository;
import pl.coderslab.workshop.repository.VisitHourRepository;

import java.time.LocalTime;
import java.util.*;

@Service
public class CalendarService {

    private final VisitDayRepository visitDayRepository;
    private final EmployeeRepository employeeRepository;
    private final VisitHourRepository visitHourRepository;
    private final ClientVisitRepository visitRepository;

    public CalendarService(VisitDayRepository visitDayRepository, EmployeeRepository employeeRepository, VisitHourRepository visitHourRepository, ClientVisitRepository visitRepository) {
        this.visitDayRepository = visitDayRepository;
        this.employeeRepository = employeeRepository;
        this.visitHourRepository = visitHourRepository;
        this.visitRepository = visitRepository;
    }


    /*Tworzy kalendarz wizyt na podstawie dostępnego grafiku dla pracowników */
    @Transactional
    public void createDays() {
        Set<Employee> employees = new HashSet<>(employeeRepository.findAllWithWorkHourAndVisitDayBy());
        for (Employee employee : employees) {
            Set<WorkHour> workHours = employee.getWorkHour();
//            Employee employeeToSave = employee;
            Set<VisitDay> visitDays = new HashSet<>();
            for (WorkHour workHour : workHours) {

                VisitDay visitDayToSave = new VisitDay(null, employee, workHour.getDayWork(), createHour(workHour.getStartWork(), workHour.getEndWork()));
                visitDays.add(visitDayToSave);
            }
            visitDayRepository.saveAll(visitDays);
            employee.setVisitDay(visitDays);
            employeeRepository.save(employee);
        }

    }


    //    private List<VisitHour> createHour(LocalTime startWork, LocalTime endWork) {
//        List<VisitHour> hourList = new ArrayList<>();
//        LocalTime timeToSave =startWork;
//        while (!timeToSave.equals(endWork)) {
//            VisitHour visitHourToSave=new VisitHour(null, timeToSave, null);
//            hourList.add(visitHourToSave);
//            timeToSave = timeToSave.plusMinutes(10);
//        }
//        visitHourRepository.saveAll(hourList);
//
//        return hourList;
//    }
    private List<VisitHour> createHour(LocalTime startWork, LocalTime endWork) {
        ClientVisit clientVisit = visitRepository.getOne(1L);
        List<VisitHour> hourList = new ArrayList<>();
        LocalTime timeToSave = startWork;
        while (!timeToSave.equals(endWork)) {
            VisitHour visitHourToSave;
            if (timeToSave.isAfter(LocalTime.of(10, 00)) && timeToSave.isBefore(LocalTime.of(10, 40))) {
                visitHourToSave = new VisitHour(null, timeToSave, clientVisit);
            } else {
                visitHourToSave = new VisitHour(null, timeToSave, null);
            }
            hourList.add(visitHourToSave);
            timeToSave = timeToSave.plusMinutes(10);
        }
        visitHourRepository.saveAll(hourList);

        return hourList;
    }

    //Jestem prawie pewny że można by to zrobić ow wiele ładniej i sprawniej ale z braku czasu zostawiam to tak jak jest :(
    public List<Map<Integer, List<LocalTime>>> timeMapList(List<LocalTime> times) {
        List<Map<Integer, List<LocalTime>>> visitTimeMapTest = new ArrayList<>();
        List<LocalTime> timeList = new ArrayList<>();
        int minutes = 0;
        Map<Integer, List<LocalTime>> testMap = new HashMap<>();
        for (int i = 0; i < times.size(); i++) {
            if (i < times.size() - 1) {
                if (times.get(i).plusMinutes(10L).equals(times.get(i + 1))) {
                    timeList.add(times.get(i));
                    minutes += 10;
                } else {
                    timeList.add(times.get(i));
                    minutes += 10;
                    testMap.put(minutes, timeList);
                    visitTimeMapTest.add(testMap);
                    timeList = new ArrayList<>();
                    minutes = 0;
                    testMap = new HashMap<>();
                }
            } else {
                timeList.add(times.get(i));
                minutes += 10;
                testMap.put(minutes, timeList);
                visitTimeMapTest.add(testMap);
                timeList = new ArrayList<>();
                minutes = 0;
            }
        }
        return visitTimeMapTest;
    }

   public Integer timeParseInt(LocalTime time) {
        return time.getHour() * 60 + time.getMinute();
    }

    public List<LocalTime> proposedTimesList(List<LocalTime> times, LocalTime serviceTime) {
        List<LocalTime> listWithTimeToSelect= new ArrayList<>();
        List<Map<Integer, List<LocalTime>>> listWithTimeMap = timeMapList(times);
        int servTime1 = timeParseInt(serviceTime);
        for (Map<Integer, List<LocalTime>> integerListMap : listWithTimeMap) {
            for (Integer keyServiceTime : integerListMap.keySet()) {
                if (keyServiceTime > servTime1) {
                    List<LocalTime> ListFromMap = integerListMap.get(keyServiceTime);
                    int t = (keyServiceTime - servTime1) / 10;
                    for (int i = 0; i < t; i++) {
                        listWithTimeToSelect.add(ListFromMap.get(i));
                    }
                }
                if (keyServiceTime == servTime1) {
                    listWithTimeToSelect.add(integerListMap.get(keyServiceTime).get(0));
                }
            }
        }
        return listWithTimeToSelect;
    }
}
