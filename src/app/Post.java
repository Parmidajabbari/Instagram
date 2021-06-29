package app;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Post implements Comparable<Post>{
    private String photoString;
    private String postId;
    private int userId;
    private String caption;
    private String username;
    private String dateTime;
    private int likesCount;
    private int commentsCount;
    private ArrayList<Comment> comments = new ArrayList<>();
    private ArrayList<Long> likedByUsers = new ArrayList<>();
    public Post(String photoString, String caption, int likes, int comments, String ownerName, String uploaded, int ownerId) {
        this.photoString = photoString;
        this.caption = caption;
        this.likesCount = likes;
        this.commentsCount = comments;
        this.username = ownerName;
        this.dateTime = uploaded;
        this.userId = ownerId;
    }

    public String getPostId() {
        return postId;
    }
    public String getDateTime() {
        return dateTime;
    }

    public String getPhotoString() {
        return photoString;
    }

    public String getUsername() {
        return username;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public int getLikesCount() {
        return likesCount;
    }


    public ArrayList<Long> getLikedByUsers() {
        return likedByUsers;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public String generatePostId() {
        return UUID.randomUUID().toString();
    }
    public static void addLike(Post post , long userId) {
        post.getLikedByUsers().add(userId);

    }
    public static boolean removeLike(Post post , long userId) {
        if(post.getLikedByUsers().contains(userId)) {
            post.getLikedByUsers().remove(userId);
            return true;
        }
        return false;

    }
    public static void addComment(Post post , String comment, long userId) {
        Comment comment1 = new Comment(comment , userId);
        post.getComments().add(comment1);

    }
    public static boolean removeComment(Post post , long commentId , long userId) {
        for(int i = 0 ; i < post.getComments().size() ; i++) {
            if (post.getComments().get(i).getCommentId() == commentId) {
                post.getComments().remove(i);
                return true;
            }
        }
        return false;
    }
    public static Post getPost(String postId , ArrayList<Post> posts) {
        for(int i = 0 ; i < posts.size() ; i++) {
            if(posts.get(i).getPostId().equals(postId)) {
                return posts.get(i);
            }
        }
        return null;
    }

    public long getUserId() {
        return userId;
    }

    public String getCaption() {
        return caption;
    }
    Date date = new Date();


    @Override
    public int compareTo(Post p) {
        return getDateTime().compareTo(p.getDateTime());
    }
}

