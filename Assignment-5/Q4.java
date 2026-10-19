import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

class EventManager {
    private String eventName;
    private LocalDate eventDate;
    private LocalTime startTime;
    private Optional<String> venue;

    public EventManager(String eventName, LocalDate eventDate, LocalTime startTime, String venueName) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.startTime = startTime;
        this.venue = Optional.ofNullable(venueName);
    }

    public void displayDetails() {
        System.out.println("Event Name: " + eventName);
        System.out.println("Event Date: " + eventDate);
        System.out.println("Start Time: " + startTime);
        System.out.println("Venue: " + venue.orElse("Venue not specified"));
    }

    public void evaluateSchedule() {
        LocalDate today = LocalDate.now();
        if (eventDate.isAfter(today)) {
            System.out.println("Status: The event is in the future.");
            long daysRemaining = ChronoUnit.DAYS.between(today, eventDate);
            System.out.println("Days remaining until the event: " + daysRemaining);
        } else if (eventDate.isEqual(today)) {
            System.out.println("Status: The event is today!");
        } else {
            System.out.println("Status: The event is in the past.");
        }
    }

    public void calculateEndTime() {
        LocalTime endTime = startTime.plusHours(2);
        System.out.println("End Time (2-hour duration): " + endTime);
    }
}

public class Q4 {
    public static void main(String[] args) {
        EventManager event = new EventManager("Technical Hackathon", LocalDate.now().plusDays(7), LocalTime.of(14, 30), null);
        
        event.displayDetails();
        System.out.println("-----------------------------------");
        event.evaluateSchedule();
        System.out.println("-----------------------------------");
        event.calculateEndTime();
    }
}