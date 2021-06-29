package app;

import java.sql.Date;
import java.util.ArrayList;

public class Profile {
    private String userName;
    private String created;
    private String bio;
    private int followersNumber;
    private int followingNumber;
    private int userId;
    private ArrayList<Integer> posts;
    private boolean isFollowing;

    public Profile(String userName , int userId , String created, String bio, int followersNumber, int followingNumber, ArrayList<Integer> posts,boolean isFollowing) {
        this.userName = userName;
        this.created = created;
        this.bio = bio;
        this.followersNumber = followersNumber;
        this.followingNumber = followingNumber;
        this.posts = posts;
        this.isFollowing = isFollowing;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getCreated() {
        return created;
    }

    public String getBio() {
        return bio;
    }

    public int getFollowersNumber() {
        return followersNumber;
    }

    public int getFollowingNumber() {
        return followingNumber;
    }

    public ArrayList<Integer> getPosts() {
        return posts;
    }

    public boolean isFollowing() {
        return isFollowing;
    }
}
