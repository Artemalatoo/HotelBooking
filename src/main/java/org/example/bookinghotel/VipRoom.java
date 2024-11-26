package org.example.bookinghotel;

public class VipRoom extends Room{
    public VipRoom(String roomNumber, double pricePerNight) {
        super(roomNumber, pricePerNight);
    }

    @Override
    public String toString() {
        return "Vip Room - " + getRoomNumber() + ", $" + getPricePerNight() + " per night";
    }
}
