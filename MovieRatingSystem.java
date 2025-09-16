import java.util.Scanner;

public class MovieRatingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get user name
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        // Step 2: Get movie names and ratings
        String[] movies = new String[5];
        int[] ratings = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter the name of movie #" + (i + 1) + ": ");
            movies[i] = scanner.nextLine();

            int rating;
            do {
                System.out.print("Rate \"" + movies[i] + "\" (1-10): ");
                rating = scanner.nextInt();
            } while (rating < 1 || rating > 10);
            ratings[i] = rating;
            scanner.nextLine(); // consume newline
        }

        // Step 3: Calculate average rating
        int sum = 0;
        for (int rating : ratings) {
            sum += rating;
        }
        double average = sum / 5.0;
        System.out.printf("Average rating: %.2f%n", average);

        // Step 4: Classify user's taste
        if (average >= 9) {
            System.out.println("You are a cinephile!");
        } else if (average >= 7) {
            System.out.println("You enjoy movies quite a bit.");
        } else if (average >= 5) {
            System.out.println("You have mixed feelings about movies.");
        } else {
            System.out.println("You are a tough critic!");
        }

        // Step 5: Favorite or disliked movie (nested if)
        boolean foundMasterpiece = false;
        boolean foundBadMovie = false;

        for (int rating : ratings) {
            if (rating == 10) {
                foundMasterpiece = true;
            } else if (rating < 4) {
                foundBadMovie = true;
            }
        }

        if (foundMasterpiece) {
            System.out.println("Wow! You found a masterpiece.");
        }

        if (foundBadMovie) {
            System.out.println("That movie didn’t impress you much.");
        }

        // Step 6: Logical Operators
        boolean allHighRatings = true;
        boolean anyVeryLowRating = false;

        for (int rating : ratings) {
            if (rating < 7) {
                allHighRatings = false;
            }
            if (rating < 3) {
                anyVeryLowRating = true;
            }
        }

        if (allHighRatings) {
            System.out.println("You seem to enjoy most movies.");
        } else if (anyVeryLowRating) {
            System.out.println("You have strong opinions on movies!");
        }

        // Step 7: Switch statement for genre
        System.out.println("\nChoose your favorite genre:");
        System.out.println("1. Action\n2. Comedy\n3. Horror\n4. Drama\n5. Sci-Fi");
        System.out.print("Enter your favorite genre: ");
        String genre = scanner.nextLine().trim();

        switch (genre.toLowerCase()) {
            case "action":
                System.out.println("You love excitement and thrills!");
                break;
            case "comedy":
                System.out.println("You enjoy a good laugh.");
                break;
            case "horror":
                System.out.println("You have a taste for fear!");
                break;
            case "drama":
                System.out.println("You appreciate deep storytelling.");
                break;
            case "sci-fi":
                System.out.println("You love futuristic and imaginative worlds!");
                break;
            default:
                System.out.println("Interesting choice!");
        }

        // Step 8: Conditional operator for movie suggestion
        String suggestion = genre.equalsIgnoreCase("sci-fi") ? "Interstellar" : "The Dark Knight";
        System.out.println("We recommend you watch: " + suggestion);

        // Step 9: All functionality complete
        System.out.println("\nThanks for using the Movie Rating System, " + userName + "!");
        scanner.close();
    }
}




