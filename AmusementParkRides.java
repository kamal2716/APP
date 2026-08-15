public class AmusementParkRides {

    static class Ride {
        int rideNumber;
        String rideName;

        // Constructor to initialize the ride details.
        public Ride(int rideNumber, String rideName) {
            this.rideNumber = rideNumber;
            this.rideName = rideName;
        }
    }

    public static void main(String[] args) {
        // Store the 5 rides using an array of objects.
        Ride[] rides = new Ride[5];
        rides[0] = new Ride(1, "Roller Coaster");
        rides[1] = new Ride(2, "Ferris Wheel");
        rides[2] = new Ride(3, "Bumper Cars");
        rides[3] = new Ride(4, "Water Ride");
        rides[4] = new Ride(5, "Haunted House");

        // Use a for loop to access each ride.
        for (int i = 0; i < rides.length; i++) {
            // Display the ride name along with its corresponding pattern.
            System.out.printf("%-14s : ", rides[i].rideName);
            
            // Use a nested for loop to print the * pattern.
            // The number of * should correspond to the ride number/activity level.
            for (int j = 0; j < rides[i].rideNumber; j++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line for the next ride
        }
    }
}
