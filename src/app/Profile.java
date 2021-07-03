package app;

import java.sql.Date;
import java.util.ArrayList;

public class Profile {
    private String task;
    private boolean error;
    private String Result;
    private String userName;
    private String firstName;
    private String lastName;
    private String created;
    private String bio;
    private int followersNumber;
    private int followingNumber;
    private boolean isFollowing;
    private ArrayList<Integer> posts;
    private byte[] proPic;

    public byte[] getProPic() {
        return proPic;
    }

    public Profile(byte[] proPic, String userName  , String created, String bio, int followersNumber, int followingNumber, ArrayList<Integer> posts, boolean isFollowing) {
        this.userName = userName;
        this.created = created;
        this.bio = bio;
        this.followersNumber = followersNumber;
        this.followingNumber = followingNumber;
        this.posts = posts;
        this.isFollowing = isFollowing;
        this.proPic = proPic;
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
