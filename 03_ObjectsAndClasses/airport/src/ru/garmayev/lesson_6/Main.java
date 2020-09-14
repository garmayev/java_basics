package ru.garmayev.lesson_6;

import com.skillbox.airport.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        List<Terminal> terminals = airport.getTerminals();

        for (int i = 0; i < terminals.size(); i++) {
            Terminal terminal = terminals.get(i);
            List<Flight> flight = terminal.getFlights();
            System.out.println("Terminal " + terminal.getName() + ":");
            for (int j = 0; j < flight.size(); j++) {
                System.out.println("\t" + flight.get(j).getCode() + " | " + flight.get(j).getDate() + " | " + flight.get(j).getType());
            }
        }
    }
}
