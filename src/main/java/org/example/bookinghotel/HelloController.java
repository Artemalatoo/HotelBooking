package org.example.hotelbooking;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    // Define FXML components for the first registration
    @FXML private TextField nameField;
    @FXML private TextField lastNameField;
    @FXML private TextField passportIdField;
    @FXML private TextField phoneNumberField;
    @FXML private TextArea registrationOutput;
    @FXML private ComboBox<String> roomTypeComboBox;
    @FXML private DatePicker entryDatePicker;
    @FXML private DatePicker departureDatePicker;
    @FXML private Spinner<Integer> guestsSpinner;
    @FXML private TextArea bookingOutput;
    @FXML private ListView<String> bookingListView; // ListView to show bookings

    // Define FXML components for the second registration
    @FXML private TextField nameField2;
    @FXML private TextField lastNameField2;
    @FXML private TextField passportIdField2;
    @FXML private TextField phoneNumberField2;
    @FXML private TextArea registrationOutput2;
    @FXML private ComboBox<String> roomTypeComboBox2;
    @FXML private DatePicker entryDatePicker2;
    @FXML private DatePicker departureDatePicker2;
    @FXML private Spinner<Integer> guestsSpinner2;
    @FXML private TextArea bookingOutput2;

    // Room list initialization
    private List<Room> availableRooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    // Track booked rooms for both registrations
    private List<Room> bookedRooms = new ArrayList<>();

    @FXML
    public void initialize() {
        roomTypeComboBox.getItems().addAll("Single", "Double", "VIP");
        roomTypeComboBox2.getItems().addAll("Single", "Double", "VIP");
        guestsSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1));
        guestsSpinner2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1));
        availableRooms.add(new SingleRoom("S001", 100.0));
        availableRooms.add(new DoubleRoom("D002", 150.0));
        availableRooms.add(new VipRoom("V001", 250.0));
        bookingListView.getItems().add("Bookings will appear here.");
    }
    @FXML
    public void handleAddRegistration() {
        String name = nameField.getText();
        String lastName = lastNameField.getText();
        String passportId = passportIdField.getText();
        String phone = phoneNumberField.getText();
        String roomType = roomTypeComboBox.getValue();
        Room selectedRoom = getAvailableRoom(roomType);
        if (selectedRoom != null) {
            selectedRoom.setBooked(true);
            bookedRooms.add(selectedRoom);  
            Booking booking = new Booking(selectedRoom, entryDatePicker.getValue(), departureDatePicker.getValue());
            bookings.add(booking);
            bookingOutput.setText("Booking successful:\n" + booking.toString());
            bookingListView.getItems().add(booking.toString());
            updateAvailableRoomsComboBox();
        } else {
            bookingOutput.setText("No available rooms for the selected type.");
        }
    }
    @FXML
    public void handleAddRegistration2() {
        String name = nameField2.getText();
        String lastName = lastNameField2.getText();
        String passportId = passportIdField2.getText();
        String phone = phoneNumberField2.getText();
        String roomType = roomTypeComboBox2.getValue();
        Room selectedRoom = getAvailableRoom(roomType);
        if (selectedRoom != null) {
            selectedRoom.setBooked(true);
            bookedRooms.add(selectedRoom);  
            Booking booking = new Booking(selectedRoom, entryDatePicker2.getValue(), departureDatePicker2.getValue());
            bookings.add(booking);
            bookingOutput2.setText("Booking successful:\n" + booking.toString());
            bookingListView.getItems().add(booking.toString());
        } else {
            bookingOutput2.setText("No available rooms for the selected type.");
        }
    }
    private Room getAvailableRoom(String roomType) {
        for (Room room : availableRooms) {
            if (roomType.equalsIgnoreCase(room.getClass().getSimpleName().replace("Room", "")) && !room.isBooked()) {
                return room;
            }
        }
        return null;
    }
    private void updateAvailableRoomsComboBox() {
        roomTypeComboBox2.getItems().clear();
        roomTypeComboBox2.getItems().addAll("Single", "Double", "VIP");
        for (Room bookedRoom : bookedRooms) {
            roomTypeComboBox2.getItems().removeIf(item -> item.equalsIgnoreCase(bookedRoom.getClass().getSimpleName().replace("Room", "")));
        }
    }
}
