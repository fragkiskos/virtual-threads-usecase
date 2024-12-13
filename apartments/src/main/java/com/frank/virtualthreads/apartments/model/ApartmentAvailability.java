package com.frank.virtualthreads.apartments.model;

import java.time.LocalDate;
import java.util.List;

public class ApartmentAvailability {
    private LocalDate startDate;
    private LocalDate endDate;
    private int guests;
    List<Long> availableIds;

    public ApartmentAvailability(LocalDate startDate, LocalDate endDate, int guests, List<Long> availableIds) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.guests = guests;
        this.availableIds = availableIds;
    }

    public ApartmentAvailability() {
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public List<Long> getAvailableIds() {
        return availableIds;
    }

    public void setAvailableIds(List<Long> availableIds) {
        this.availableIds = availableIds;
    }
}
