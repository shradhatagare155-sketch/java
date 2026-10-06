class TicketBooking {
    String passengerName;
    String bookingStatus;

    TicketBooking(String passengerName) {
        this.passengerName = passengerName;
        this.bookingStatus = "Booked";
    }

    void processBooking() {
        bookingStatus = "Confirmed";
    }

    void displayBookingDetails() {
        System.out.println("Passenger Name: " + passengerName);
        System.out.println("Booking Status: " + bookingStatus);
        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }
}

class BookingThread extends Thread {
    TicketBooking booking;
    boolean displayDetails;

    BookingThread(TicketBooking booking) {
        this(booking, true);
    }

    BookingThread(TicketBooking booking, boolean displayDetails) {
        this.booking = booking;
        this.displayDetails = displayDetails;
    }

    public void run() {
        if (booking == null) {
            return;
        }

        booking.processBooking();

        if (displayDetails) {
            booking.displayBookingDetails();
        }
    }
}

class BookingRunnable implements Runnable {
    TicketBooking booking;
    boolean displayDetails;

    BookingRunnable(TicketBooking booking) {
        this(booking, true);
    }

    BookingRunnable(TicketBooking booking, boolean displayDetails) {
        this.booking = booking;
        this.displayDetails = displayDetails;
    }

    public void run() {
        if (booking == null) {
            return;
        }

        booking.processBooking();

        if (displayDetails) {
            booking.displayBookingDetails();
        }
    }
}

public class pro8 {
    public static void main(String[] args) {

        TicketBooking booking1 = new TicketBooking("Rahul");
        TicketBooking booking2 = new TicketBooking("Priya");
        TicketBooking booking3 = new TicketBooking("Aman");
        TicketBooking booking4 = new TicketBooking("Neha");
        TicketBooking booking5 = new TicketBooking("Arjun");

        BookingThread thread1 = new BookingThread(booking1);
        BookingThread thread2 = new BookingThread(booking2);

        BookingRunnable runnable1 = new BookingRunnable(booking3);
        BookingRunnable runnable2 = new BookingRunnable(booking4);

        Thread thread3 = new Thread(runnable1);
        Thread thread4 = new Thread(runnable2);

        Thread thread5 = new Thread(new BookingRunnable(booking5));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        TicketBooking emptyBooking = new TicketBooking("");
        TicketBooking nullNameBooking = new TicketBooking(null);

        Thread emptyNameThread = new BookingThread(emptyBooking);
        Thread nullNameThread = new BookingThread(nullNameBooking);

        emptyNameThread.start();
        nullNameThread.start();

        try {
            emptyNameThread.join();
            nullNameThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        BookingThread invalidBookingThread = new BookingThread(null);
        invalidBookingThread.start();

        try {
            invalidBookingThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        TicketBooking sharedBooking = new TicketBooking("Shared Passenger");

        Thread sharedThread1 = new Thread(new BookingRunnable(sharedBooking));
        Thread sharedThread2 = new Thread(new BookingRunnable(sharedBooking));

        sharedThread1.start();
        sharedThread2.start();

        try {
            sharedThread1.join();
            sharedThread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Thread interruptedThread = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    TicketBooking booking = new TicketBooking("Interrupted Passenger");
                    booking.processBooking();
                    booking.displayBookingDetails();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        interruptedThread.start();
        interruptedThread.interrupt();

        try {
            interruptedThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Thread[] largeBookings = new Thread[20];

        for (int i = 0; i < 20; i++) {
            largeBookings[i] =
                new BookingThread(
                    new TicketBooking("Passenger" + (i + 1)),
                    true
                );

            largeBookings[i].start();
        }

        try {
            for (int i = 0; i < 20; i++) {
                largeBookings[i].join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Thread[] excessiveBookings = new Thread[500];

        for (int i = 0; i < 500; i++) {
            excessiveBookings[i] =
                new BookingThread(
                    new TicketBooking("BulkPassenger" + (i + 1)),
                    false
                );

            excessiveBookings[i].start();
        }

        try {
            for (int i = 0; i < 500; i++) {
                excessiveBookings[i].join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(
            "All passenger booking requests have been processed successfully."
        );
    }
}