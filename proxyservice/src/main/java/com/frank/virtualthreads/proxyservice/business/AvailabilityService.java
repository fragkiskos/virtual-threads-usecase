package com.frank.virtualthreads.proxyservice.business;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.function.Function;

@Component
public class AvailabilityService {

    @Value("${services.hotels.host}")
    String hotelServiceHost;

    @Value("${services.apartments.host}")
    String apartmentsServiceHost;

    public String hotelsAvailability(LocalDate startDate, LocalDate endDate, Integer guests) {
        return getAvailability(hotelServiceHost, startDate, endDate, guests);
    }

    public String apartmentsAvailability(LocalDate startDate, LocalDate endDate, Integer guests) {
        return getAvailability(apartmentsServiceHost, startDate, endDate, guests);
    }

    private String getAvailability(String hotelServiceHost, LocalDate startDate, LocalDate endDate, Integer guests) {
        RestClient restClient = RestClient.builder().baseUrl(hotelServiceHost).build();
        String result = restClient.get()
                .uri(getUriWIthParams(startDate, endDate, guests))
                .retrieve()
                .body(String.class);
        return result;
    }

    private Function<UriBuilder, URI> getUriWIthParams(LocalDate startDate, LocalDate endDate, Integer guests) {
        return uriBuilder -> uriBuilder.path("/availability")
                .queryParam("from", startDate.toString())
                .queryParam("to", endDate.toString())
                .queryParam("guests", guests.toString())
                .build();
    }
}
