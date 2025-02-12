package org.example.firstspringproject;
import org.example.firstspringproject.service.CSVReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController

public class PlayerController {
    @Autowired
    private CSVReaderService csvReaderService;
    private final static String FILE_PLAYERS_DATA = "utils/superliga_data.csv";

    @GetMapping("/players")
    public List<Player> getAllPlayers() {

        return csvReaderService.readCSV(FILE_PLAYERS_DATA);
    }

    @GetMapping("/risingstars")
    public List<Player> getRisingStars() {

        List<Player> all_players = csvReaderService.readCSV(FILE_PLAYERS_DATA);

        return all_players.stream()
                .filter(player -> player.getAge() <= 24)
                .collect(Collectors.toList());
    }
}
