package com.frank.virtualthreads.apartments.ws;

import com.frank.virtualthreads.apartments.model.ApartmentAvailability;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;

@RestController
public class ApartmentsAvailabilityController {

    @GetMapping("/availability")
    public ResponseEntity<ApartmentAvailability> getHotelsAvailability(@PathParam("from") String from, @PathParam("to") String to, @PathParam("guests") Integer guests) {
        LocalDate startDate = LocalDate.parse(from);
        LocalDate endDate = LocalDate.parse(to);
        return ResponseEntity.ok(new ApartmentAvailability(startDate, endDate, guests, Arrays.asList(1l, 2l, 3l)));
    }
}
