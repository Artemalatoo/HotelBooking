1 In Booking hotel system project we create abstract class and some subclasses
(SingleRoom, DoubleRoom, Room, VipRoom).
Then we created attributes for counting night, price and local date. Moreover
we used library import java.time.LocalDate; so that we could choose the day of
entry and departure days and created method calculate price.
2 we started to make interface in scene builder. Our fist step was to 
create registration tab, where we added 4 textfield for: name, last name, id and phone
number. Then we put listview and button add so after filling fields we could add them
to listview.Then in booking room tab we added datepicker for entry and departure days
spinner for how many people we live, choicebox for selecting the rooms and 
button for calculating the price that will display on listview. After we create identity in fx:id
3 Then we copy the code from view and put into controller.
we create method intialize where will be the number of rooms and their prices.
public void handleAddRegistration()  used this method for filling the fields,
String output = String.format make specific format for output,
public void handleCalculatePrice() {
        if (entryDatePicker.getValue() == null || departureDatePicker.getValue() == null) {
            bookingOutput.setText("Please select both entry and departure dates.");
            return;
        } get value for date picker to select days.
checked isavaible or not.
Project roles:
1 David created abstract class and subclasses for the project 
2 Artem created interface and hellocontroller for the project 
we distributed presentation roles. 


https://docs.google.com/document/d/1X5284J6OGN2Cgo_s03bm0xrHe1c219c5ak2ur--_CWU/edit?usp=sharing


+--------------------------+
|        <<abstract>>       |
|          Room             |
+--------------------------+
| - roomNumber: String      |
| - price: Double           |
+--------------------------+
| + getPrice(): Double      |
| + getRoomNumber(): String|
| + Availabe(): Boolean |
+--------------------------+
           ^
           |
    +------+------+
    |      |      |
+------------+  +------------+   +-------------+
| SingleRoom |  | DoubleRoom |   |  VipRoom    |
+------------+  +------------+   +-------------+
+------------------+  +-----------------+  +--------------------------+
| + getPrice()     |  | + getPrice()    |  | + getPrice()             |
| + getRoomNumber()|  | + getRoomNumber()| | +getRoomNumber()       |
+-------------------+  +------------------+  +--------------------------+

