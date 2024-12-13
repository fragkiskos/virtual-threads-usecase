package com.frank.virtualthreads.hotels.ws;

import com.frank.virtualthreads.hotels.model.HotelAvailability;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;

@RestController
public class HotelsAvailabilityController {

    @GetMapping("/availability")
    public ResponseEntity<HotelAvailability> getHotelsAvailability(@PathParam("from") String from, @PathParam("to") String to, @PathParam("guests") Integer guests) {
        LocalDate startDate = LocalDate.parse(from);
        LocalDate endDate = LocalDate.parse(to);
        delay(2000);
        return ResponseEntity.ok(new HotelAvailability(startDate, endDate, guests, Arrays.asList(1l, 2l, 3l)));
    }

    private static void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
