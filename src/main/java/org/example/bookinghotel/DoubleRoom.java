package org.example.bookinghotel;
public class DoubleRoom extends Room {

    public DoubleRoom(String roomNumber, double pricePerNight) {
        super(roomNumber, pricePerNight);
    }

    @Override
    public String toString() {
        return "Double Room - " + getRoomNumber() + ", $" + getPricePerNight() + " per night";
    }
}
