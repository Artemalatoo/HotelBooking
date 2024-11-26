package org.example.bookinghotel;
import java.time.LocalDate;

public class Booking {
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalAmount;

    public Booking(Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = room.getPricePerNight() * (checkOutDate.getDayOfYear() - checkInDate.getDayOfYear());
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Booking: " + room.toString() + " from " + checkInDate + " to " + checkOutDate + " Total: $" + totalAmount;
    }
}

