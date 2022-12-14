/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package inheritance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Restaurant {
    private long id;
    private String name;
    private String foodType;
    private float starAverage = 0.0f;
    private HashSet<Review> reviews = new HashSet<>();
//    private HashSet<Float> starsList = new HashSet<>();

    public long getId() {
        return id;
    }

    public float getStarAverage() {
        return starAverage;
    }

    public HashSet<Review> getReviews() {
        return reviews;
    }


    public Restaurant(String name, String foodType){
        this.id = createId();
        this.name = name;
        this.foodType = foodType;
        RestaurantCollection.restaurantList.put(id, this);
    }

    private long createId (){
        Random random = new Random();
        long possibleID = random.nextInt(1000000000);

        while (true){
            if(RestaurantCollection.hasKey(possibleID)){
                possibleID = random.nextInt(1000000000);
            } else {
                return possibleID;
            }
        }
    }

    public void addReview(Review review){

        review.setMyStoreID(id);

        reviews.add(review);
//        starsList.add(review.stars);

        updateRatings();
    }

    public void updateRatings(){
        Object[] ratingObjs = reviews.toArray();
        float totalStars = 0.0f;

        for (Object o : ratingObjs) {

            Review review = (Review) o;

            float starRating = (float) ((Review) o).getStars();

            totalStars += starRating;

            starAverage = totalStars / (float) ratingObjs.length;
        }
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(name + " ");
        stringBuilder.append("is a " + foodType + " restaurant. ");

        if(starAverage == 1){
            stringBuilder.append("This restaurant has a star average of " + starAverage + " star.");
        } else {
            stringBuilder.append("This restaurant has a star average of " + starAverage + " stars.");
        }

        return stringBuilder.toString();
    }
}
