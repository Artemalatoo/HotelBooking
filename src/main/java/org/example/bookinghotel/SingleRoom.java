package org.example.bookinghotel;
public class SingleRoom extends Room {

    public SingleRoom(String roomNumber, double pricePerNight) {
        super(roomNumber, pricePerNight);
    }

    @Override
    public String toString() {
        return "Single Room - " + getRoomNumber() + ", $" + getPricePerNight() + " per night";
    }
}

