package org.example.hotelbooking;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class HelloController {
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

    @FXML
    public void initialize() {
        ObservableList<String> roomTypes = FXCollections.observableArrayList("Single", "Double", "VIP");
        roomTypeComboBox.setItems(roomTypes);
        SpinnerValueFactory<Integer> guestsFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1);
        guestsSpinner.setValueFactory(guestsFactory);
    }
    @FXML
    public void handleAddRegistration() {
        String name = nameField.getText();
        String lastName = lastNameField.getText();
        String passportId = passportIdField.getText();
        String phone = phoneNumberField.getText();

        registrationOutput.setText("Name: " + name + "\nLast Name: " + lastName +
                "\nPassport ID: " + passportId + "\nPhone: " + phone);
    }
    @FXML
    public void handleCalculatePrice() {
        try {
            
            String roomType = roomTypeComboBox.getValue();
            if (roomType == null) {
                bookingOutput.setText("Please select a room type.");
                return;
            }

            int guests = guestsSpinner.getValue();
            if (entryDatePicker.getValue() == null || departureDatePicker.getValue() == null) {
                bookingOutput.setText("Please select both entry and departure dates.");
                return;
            }

            LocalDate entryDate = entryDatePicker.getValue();
            LocalDate departureDate = departureDatePicker.getValue();
            if (!departureDate.isAfter(entryDate)) {
                bookingOutput.setText("Departure date must be after entry date.");
                return;
            }
            Room room;
            switch (roomType) {
                case "Single" -> room = new SingleRoom("S101", 50.0);
                case "Double" -> room = new DoubleRoom("D201", 75.0);
                case "VIP" -> room = new VipRoom("V301", 150.0);
                default -> throw new IllegalStateException("Unexpected room type: " + roomType);
            }
            Booking booking = new Booking(room, entryDate, departureDate);
            bookingOutput.setText("Booking Successful:\n" +
                    booking.toString() + "\nGuests: " + guests);
        } catch (Exception e) {
            bookingOutput.setText("Error: " + e.getMessage());
        }
    }
}
