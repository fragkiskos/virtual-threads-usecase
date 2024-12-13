package com.frank.virtualthreads.proxyservice.ws;


import com.frank.virtualthreads.proxyservice.business.AvailabilityService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    @GetMapping("/hotels/availability")
    public ResponseEntity<String> getHotelsAvailability(@PathParam("from") String from, @PathParam("to") String to, @PathParam("guests") Integer guests) {
        LocalDate startDate = LocalDate.parse(from);
        LocalDate endDate = LocalDate.parse(to);
        return ResponseEntity.ok(availabilityService.hotelsAvailability(startDate, endDate, guests));
    }

    @GetMapping("/apartments/availability")
    public ResponseEntity<String> getApartmentsAvailability(@PathParam("from") String from, @PathParam("to") String to, @PathParam("guests") Integer guests) {
        LocalDate startDate = LocalDate.parse(from);
        LocalDate endDate = LocalDate.parse(to);
        return ResponseEntity.ok(availabilityService.apartmentsAvailability(startDate, endDate, guests));
    }

}
