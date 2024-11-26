module org.example.bookinghotel {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.bookinghotel to javafx.fxml;
    exports org.example.bookinghotel;
}