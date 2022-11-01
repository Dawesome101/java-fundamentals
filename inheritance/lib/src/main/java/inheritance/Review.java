package inheritance;

public class Review {

    long myStoreID;
    String author;
    String body;
    float stars;

    public float getStars() {
        return stars;
    }

    public long getMyStoreID() {
        return myStoreID;
    }

    public void setMyStoreID(long myStoreID) {
        this.myStoreID = myStoreID;
    }

    public Review(String author, String body, float stars){
        this.author = author;
        this.body = body;
        this.stars = stars;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(author + " ");

        stringBuilder.append("gave this restaurant " + stars + " stars and left the following review: ");
        stringBuilder.append(body);

        return stringBuilder.toString();
    }
}
