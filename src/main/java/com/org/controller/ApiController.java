package com.org.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.org.model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@RestController
public class ApiController {

    @GetMapping(value="/connected")
    public <T> ResponseEntity<Data> handlePostRequest(@RequestParam("origin") String origin,@RequestParam("destination") String destination) {

        String isRoadExist = isRoadExist(origin,destination);
        Data data = new Data();
        data.setStatus(isRoadExist);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    private String isRoadExist(String origin, String destination) {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("city.txt");

        try (InputStreamReader streamReader =
                     new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] cityArray = line.split(",");
                if(origin.equalsIgnoreCase(cityArray[0]) && destination.equalsIgnoreCase(cityArray[1])) {
                    return "Yes";
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "No";
    }
}
