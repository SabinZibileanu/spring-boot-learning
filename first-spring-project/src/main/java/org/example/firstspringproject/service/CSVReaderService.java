package org.example.firstspringproject.service;
import com.opencsv.CSVReader;

import com.opencsv.CSVReaderBuilder;
import org.example.firstspringproject.Player;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVReaderService {
    public List<Player> readCSV(String file_path) {
        List<Player> players = new ArrayList<>();
        int counter_id = 1;

        try (CSVReader csvReader = new CSVReader(new FileReader(file_path))){
            String[] lines;
            csvReader.readNext();
            while ((lines = csvReader.readNext()) != null){

                Player parsed_player = parse_player(lines, counter_id);

                if(parsed_player != null){
                    players.add(parsed_player);
                    counter_id++;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return players;
    }

    private Player parse_player(String[] player_data, int id_player){
        try{
            String player_name = player_data[0];
            Integer player_age = Integer.parseInt(player_data[1]);
            String player_club = player_data[2];
            String player_position = player_data[3];

            Player player = new Player();
            player.setId(id_player);
            player.setName(player_name);
            player.setAge(player_age);
            player.setClub(player_club);
            player.setPosition(player_position);

            return player;

        } catch (NumberFormatException e) {
            System.out.println("Problem on player " + player_data[0] + " , check his age");
        }
        return null;
    }
}
