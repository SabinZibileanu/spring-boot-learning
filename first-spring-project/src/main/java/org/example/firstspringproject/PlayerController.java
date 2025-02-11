package org.example.firstspringproject;
import org.example.firstspringproject.service.CSVReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController

public class PlayerController {
    @Autowired
    private CSVReaderService csvReaderService;

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        String filePath = "utils/superliga_data.csv";
        return csvReaderService.readCSV(filePath);
    }
}
