package org.example.bookinghotel;
public abstract class Room {
    private String roomNumber;
    private double pricePerNight;
    private boolean isAvailable;

    public Room(String roomNumber, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
    }
    public String getRoomNumber() {
        return roomNumber;
    }
    public double getPricePerNight() {
        return pricePerNight;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void bookRoom() {
        isAvailable = false;
    }
    public void releaseRoom() {
        isAvailable = true;
    }

    @Override
    public abstract String toString();
}

