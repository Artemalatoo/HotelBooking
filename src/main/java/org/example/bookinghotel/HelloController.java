package org.example.bookinghotel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField passportIdField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextArea registrationOutput;

    @FXML
    private DatePicker entryDatePicker;

    @FXML
    private DatePicker departureDatePicker;

    @FXML
    private ComboBox<Room> roomTypeComboBox;

    @FXML
    private Spinner<Integer> guestsSpinner;

    @FXML
    private TextArea bookingOutput;
    private final List<Room> availableRooms = new ArrayList<>();

    @FXML
    public void initialize() {

        availableRooms.add(new SingleRoom("101", 50.0));
        availableRooms.add(new DoubleRoom("102", 100.0));
        availableRooms.add(new VipRoom("103", 200.0));

        roomTypeComboBox.setItems(FXCollections.observableArrayList(availableRooms));

        guestsSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1));
    }

    @FXML
    public void handleAddRegistration() {
        String name = nameField.getText();
        String lastName = lastNameField.getText();
        String passportId = passportIdField.getText();
        String phoneNumber = phoneNumberField.getText();

        if (name.isEmpty() || lastName.isEmpty() || passportId.isEmpty() || phoneNumber.isEmpty()) {
            registrationOutput.setText("Please fill out all fields.");
            return;
        }

        String output = String.format("Registered: %s %s\nPassport ID: %s\nPhone: %s\n",
                name, lastName, passportId, phoneNumber);
        registrationOutput.setText(output);

        // Clear fields after registration
        nameField.clear();
        lastNameField.clear();
        passportIdField.clear();
        phoneNumberField.clear();
    }
    @FXML
    public void handleCalculatePrice() {
        if (entryDatePicker.getValue() == null || departureDatePicker.getValue() == null) {
            bookingOutput.setText("Please select both entry and departure dates.");
            return;
        }

        Room selectedRoom = roomTypeComboBox.getValue();
        if (selectedRoom == null) {
            bookingOutput.setText("Please select a room.");
            return;
        }

        if (!selectedRoom.isAvailable()) {
            bookingOutput.setText("The selected room is not available.");
            return;
        }

        long nights = departureDatePicker.getValue().toEpochDay() - entryDatePicker.getValue().toEpochDay();

        if (nights <= 0) {
            bookingOutput.setText("Departure date must be after the entry date.");
            return;
        }

        int guests = guestsSpinner.getValue();
        double totalPrice = selectedRoom.getPricePerNight() * nights * guests;

        // Mark room as booked
        selectedRoom.bookRoom();

        bookingOutput.setText(String.format("Room: %s\nNights: %d\nGuests: %d\nTotal Price: $%.2f\nRoom booked successfully.",
                selectedRoom.getRoomNumber(), nights, guests, totalPrice));
    }

    public ObservableList<Room> getAvailableRooms() {
        ObservableList<Room> available = FXCollections.observableArrayList();
        for (Room room : availableRooms) {
            if (room.isAvailable()) {
                available.add(room);
            }
        }
        return available;
    }
}
