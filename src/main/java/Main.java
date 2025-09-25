import handler.*;
import model.*;
import persistence.*;
import service.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        IUserRepository userRepo = UserSqlRepository.getInstance();
        IMediaRepository mediaRepo = MediaSqlRepository.getInstance();
        IRatingRepository ratingRepo = RatingSqlRepository.getInstance();

        IUserService userService = UserService.getInstance(userRepo);
        IMediaService mediaService = new MediaService(mediaRepo);
        IRatingService ratingService = new RatingService(ratingRepo);

        UserHandler userHandler = new UserHandler(userService);
        MediaHandler mediaHandler = new MediaHandler(mediaService);
        RatingHandler ratingHandler = new RatingHandler(ratingService);

        UserModel alice = new UserModel("alice", "123");
        UserModel bob   = new UserModel("bob", "456");

        userHandler.register(alice);
        userHandler.register(bob);

        boolean loginOk = userHandler.login(new UserModel("alice", "123"));
        System.out.println("Login Alice: " + loginOk);

        MediaModel m1 = new MediaModel("m1", "Inception");
        m1.setType("MOVIE");
        m1.setReleaseYear(2010);
        m1.setOwnerUsername("alice");
        mediaHandler.add(m1);

        MediaModel m2 = new MediaModel("m2", "Breaking Bad");
        m2.setType("SERIES");
        m2.setReleaseYear(2008);
        m2.setOwnerUsername("bob");
        mediaHandler.add(m2);

        List<MediaModel> mediaList = mediaHandler.list();
        System.out.println("Alle Media-Einträge:");
        for (MediaModel media : mediaList) {
            System.out.println(" - " + media.getTitle() + " (" + media.getType() + ")");
        }

        RatingModel r1 = new RatingModel("r1", "m1", "alice", 5);
        r1.setComment("Großartiger Film!");
        ratingHandler.add(r1);

        RatingModel r2 = new RatingModel("r2", "m1", "bob", 4);
        r2.setComment("Sehr gut, aber etwas verwirrend");
        ratingHandler.add(r2);

        List<RatingModel> ratings = ratingHandler.byMedia("m1");
        System.out.println("Ratings für Inception:");
        for (RatingModel r : ratings) {
            System.out.println(" - " + r.getUsername() + " gibt " + r.getScore() + " Sterne: " + r.getComment());
        }

        Double avg = ratingHandler.average("m1");
        System.out.println("Durchschnitt für Inception: " + avg);
    }
}
