package pl.coderslab.workshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.workshop.model.entity.VisitHour;
import pl.coderslab.workshop.repository.ClientVisitRepository;
import pl.coderslab.workshop.repository.VisitHourRepository;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VisitHourService {

    private CalendarService calendarService;
    private ClientVisitRepository clientVisitRepository;
    private VisitHourRepository visitHourRepository;

    public VisitHourService(CalendarService calendarService, ClientVisitRepository clientVisitRepository, VisitHourRepository visitHourRepository) {
        this.calendarService = calendarService;
        this.clientVisitRepository = clientVisitRepository;
        this.visitHourRepository = visitHourRepository;
    }

//To jest straszna lipa ale robiłem to na koniec i wyszedł mi mały problem z dodaniem clientVisits id to na potrzeby prezentacji jako takiej wszędzie będzie 1
public List<VisitHour> fillHourInArray(List<VisitHour>visitHourList, LocalTime visitStart, LocalTime executionTime){
        int minutesToAdd=calendarService.timeParseInt(executionTime)/10;

        LocalTime bookingTime=visitStart;
    List<VisitHour>listToSave=visitHourList;
        List<VisitHour>listForClientVisit=new ArrayList<>();
    for (int i = 0; i < listToSave.size(); i++) {
        if (minutesToAdd==0){
            break;
        }
        System.out.println(listToSave.get(i).getHour());
        System.out.println(bookingTime);

      if (listToSave.get(i).getHour().equals(bookingTime)){
          //    Uznajmy że zmieniam tu booleana na true czy cos brakło mi czasu żeby to po zmieniać :/
       listToSave.get(i).setClientVisit(clientVisitRepository.getOne(1L));
              listForClientVisit.add(listToSave.get(i));
             bookingTime=bookingTime.plusMinutes(10);
            minutesToAdd-=1;
      }
    }
    visitHourRepository.saveAll(listToSave);
    return listForClientVisit;
}

}
