package app;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Post{ //implements Comparable<Post>{

    private String task;
    private boolean error;
    private String Result;
    //private final String image;
    private final String caption;
    private final int likes;
    private final int comments;
    private final String ownerName;
    private final String uploaded;
    private final int ownerId;
    private boolean isLiked;
    private byte[] imageBytes;

    public Post(byte[] imageBytes, String caption, int likes, int comments, String ownerName, String uploaded, int ownerId,boolean isLiked) {
        this.imageBytes = imageBytes;
        this.caption = caption;
        this.likes = likes;
        this.comments = comments;
        this.ownerName = ownerName;
        this.uploaded = uploaded;
        this.ownerId = ownerId;
        this.isLiked = isLiked;
    }

    public int getLikes() {
        return likes;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getComments() {
        return comments;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getUploaded() {
        return uploaded;
    }
//
//    public String generatePostId() {
//        return UUID.randomUUID().toString();
//    }
//    public static void addLike(Post post , long userId) {
//        post.getLikedByUsers().add(userId);
//
//    }
//    public static boolean removeLike(Post post , long userId) {
//        if(post.getLikedByUsers().contains(userId)) {
//            post.getLikedByUsers().remove(userId);
//            return true;
//        }
//        return false;
//
//    }
//    public static void addComment(Post post , String comment, long userId) {
//        Comment comment1 = new Comment(comment , userId);
//        post.getComments().add(comment1);
//
//    }
//    public static boolean removeComment(Post post , long commentId , long userId) {
//        for(int i = 0 ; i < post.getComments().size() ; i++) {
//            if (post.getComments().get(i).getCommentId() == commentId) {
//                post.getComments().remove(i);
//                return true;
//            }
//        }
//        return false;
//    }
//    public static Post getPost(String postId , ArrayList<Post> posts) {
//        for(int i = 0 ; i < posts.size() ; i++) {
//            if(posts.get(i).getPostId().equals(postId)) {
//                return posts.get(i);
//            }
//        }
//        return null;
//    }
//
//    public long getUserId() {
//        return userId;
//    }

    public String getCaption() {
        return caption;
    }
    Date date = new Date();


//    @Override
//    public int compareTo(Post p) {
////        return getDateTime().compareTo(p.getDateTime());
//    }
}

