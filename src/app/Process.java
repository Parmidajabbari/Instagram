package app;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.jfoenix.controls.JFXTextField;
import controllers.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class Process {

    private String message;
    Gson gson;
    JsonObject jsonObject;

    public Process(String message) {
        this.message = message;
        gson = new Gson();
        jsonObject = gson.fromJson(message, JsonObject.class);
    }

    public void doTask() throws IOException {
        String task = jsonObject.get("task").getAsString();

        switch (task) {

            case "signUpPart1" : signupPart1Task();
                break;
            case "signUpPart2" : signupTask();
                break;
            case "showFollowers" : showFollowersTask();
                break;
            case "showFollowings" : showFollowingsTask();
                break;
            case "showComments" : showCommentsTask();
                break;
            case "sendEmail" : sendEmailTask();
                break;
            case "checkCode" : checkCodeTask();
                break;
            case "login" : loginTask();
                break;
            case "timeline" : timelineTask();
                break;
            case "newPost" : newPostTask();
                break;
            case "like" : likeTask();
                break;
            case "unLike" : unlikeTask();
                break;
            case "profileView" : profileViewTask();
                break;
            case "comment" : commentTask();
                break;
            case "follow" : followTask();
                break;
            case "unFollow" : unFollowTask();
                break;
            case "block" : blockTask();
                break;
            case "unBlock" : unBlockTask();
                break;
            case "search" : searchTask();
                break;
            case "postView" :
                try {
                    postViewTask();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case "notification" : notificationTask();
                break;
            case "direct" : directTask();
                break;
            case "changeUsername" :  editUsernameTask();
                break;
            case "changeBio" : editBioTask();
                break;
            case "changeProPic" : editPhotoTask();
                break;
            case "getImage" :    getImage();
                break;
        }

    }

    private void directTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        if(error) {
        }
        else {
        }
    }

    private void notificationTask() {
        boolean error = jsonObject.get("error").getAsBoolean();

        if(error) {
        }
        else {
            JsonArray array = jsonObject.getAsJsonArray("notifications");
            ArrayList<String> arrayCopy = new ArrayList<>();
            ObservableList<String> notifications = FXCollections.observableArrayList();

            for (JsonElement jsonElement : array) {
                arrayCopy.add(jsonElement.getAsString());
            }
            for (String notification : arrayCopy) {
                notifications.add(notification);
            }
            ActivityPageController.setList(notifications);
        }
    }
    private static byte[] bytes;

    public static void setBytes(byte[] bytes) {
        Process.bytes = bytes;
    }

    private void postViewTask() throws IOException, InterruptedException {

        boolean error = jsonObject.get("error").getAsBoolean();
        if(error) {
        }
        else {
            String caption = jsonObject.get("caption").getAsString();
            boolean isLiked = jsonObject.get("isLiked").getAsBoolean();
            int likesCount = jsonObject.get("likes").getAsInt();
            int commentsCount = jsonObject.get("comments").getAsInt();
            String username = jsonObject.get("ownerName").getAsString();
            String date = jsonObject.get("uploaded").getAsString();
            int ownerId = jsonObject.get("ownerId").getAsInt();
            System.out.println("0wnername   " + username);
            Post post = new Post(bytes,caption,likesCount,commentsCount,username,date,ownerId,isLiked);
            System.out.println(post.getOwnerName());
            ShowPostController.setPost(post);
            Thread.sleep(5000);
        }
    }

    private void searchTask() throws IOException {
        boolean error = jsonObject.get("error").getAsBoolean();
        if(error) {
            SearchPageController.setResult(jsonObject.get("Result").getAsString());
            SearchPageController.setIsDone(false);
        }
        else {
            SearchPageController.setShowUserId(jsonObject.get("Result").getAsInt());
            SearchPageController.setIsDone(true);
            String message = Tasks.getProfileViewTask(Integer.toString(LoginPageController.getUserId()),
                    jsonObject.get("Result").getAsString());
            Client.sendRequest(message);
        }
    }

    private void unBlockTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        if(error) {
        }
        else {
        }
    }

    private void blockTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        if(error) {
        }
        else {
        }
    }

    private void unFollowTask() throws IOException {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = new JFXTextField();
        if(error) {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        else {
            String massage = Tasks.getProfileViewTask(Integer.toString(LoginPageController.getUserId()),Integer.toString(SearchPageController.getShowUserId()));
            Client.sendRequest(massage);
        }
    }

    private void followTask() throws IOException {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = new JFXTextField();
        if(error) {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        else {
            String massage = Tasks.getProfileViewTask(Integer.toString(LoginPageController.getUserId()), Integer.toString(SearchPageController.getShowUserId()));
             Client.sendRequest(massage);
        }
}

    private void commentTask() throws IOException {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = new JFXTextField();
        if(error) {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        else {
            int commentId = jsonObject.get("Result").getAsInt();
         //   String massage = Tasks.getCommentTask();
//             Client.sendRequest(massage);
        }
    }

    private void profileViewTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = new JFXTextField();
        if(error) {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        else {
            String username = jsonObject.get("userName").getAsString();
            String date = jsonObject.get("created").getAsString();
            String bio = jsonObject.get("bio").getAsString();
            int followersNumber = jsonObject.get("followersNumber").getAsInt();
            int followingsNumber = jsonObject.get("followingNumber").getAsInt();
            int userId = jsonObject.get("userId").getAsInt();
            boolean isFollowing = jsonObject.get("isFollowing").getAsBoolean();

            ArrayList<Integer> postIds = new ArrayList<Integer>();
            JsonArray jArray = (JsonArray) jsonObject.get("posts");
            if (jArray != null) {
                for (int i = 0 ;i < jArray.size() ;i++){
                    postIds.add(jArray.get(i).getAsInt());
                }
            }
            Profile profile = new Profile(username,userId,date,bio,followersNumber,followingsNumber,postIds,isFollowing);
            if(userId == LoginPageController.getUserId()) {
                MyProfileController.setProfile(profile);
            }
            else {
                ShowProfileController.setProfile(profile);
            }
        }

    }

    private void unlikeTask() throws IOException {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = new JFXTextField();
        if(error) {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        else {

        }
    }

    private void likeTask() throws IOException {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = new JFXTextField();
        if(error) {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        else {

        }
    }

    private void newPostTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        if(error) {
            NewPostController.setResult(jsonObject.get("Result").getAsString());
            NewPostController.setIsPosted(false);
        }
        else {
            NewPostController.setPostId(jsonObject.get("Result").getAsInt());
            NewPostController.setIsPosted(true);
        }
    }

    private void timelineTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        if(error) {
        }
        else {
            ArrayList<Integer> posts = new ArrayList<Integer>();
            JsonArray jArray = (JsonArray) jsonObject.get("posts");
            if (jArray != null) {
                for (int i = 0 ;i < jArray.size() ;i++){
                    posts.add(jArray.get(i).getAsInt());
                }
            }
            HomePageController.setPostIds(posts);
        }
    }

    private void loginTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        if(error) {
            LoginPageController.setResult(jsonObject.get("Result").getAsString());
            LoginPageController.setIsDone(false);
        }
        else {
            LoginPageController.setUserId(jsonObject.get("Result").getAsInt());
            LoginPageController.setIsDone(true);
        }
    }

    private void checkCodeTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        if(error) {
            SecondSignUpController.setResult(jsonObject.get("Result").getAsString());
            SecondSignUpController.setIsDone(false);

        }
        else {
            SecondSignUpController.setResult("Email verified successfully");
            SecondSignUpController.setIsDone(true);
        }
    }

    private void sendEmailTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        if(error) {

        }
        else {
        }
    }

    private void showCommentsTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        if(error) {

        }
        else {
            JsonArray array = jsonObject.getAsJsonArray("comments");
            ArrayList<String> arrayCopy = new ArrayList<>();
            ObservableList<String> comments = FXCollections.observableArrayList();

            for (JsonElement jsonElement : array) {
                arrayCopy.add(jsonElement.getAsString());
            }
            for (String comment : arrayCopy) {
                comments.add(comment);
            }
            CommentPageController.setList(comments);
        }

    }

    private void showFollowingsTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        if (error) {

        }
        else {
            JsonArray array = jsonObject.getAsJsonArray("followings");
            ArrayList<String> arrayCopy = new ArrayList<>();
            ObservableList<String> followings = FXCollections.observableArrayList();

            for (JsonElement jsonElement : array) {
                arrayCopy.add(jsonElement.getAsString());
            }
            for (String following : arrayCopy) {
                followings.add(following);
            }
            ShowFollowingsController.setList(followings);
        }

    }

    private void showFollowersTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        if (error) {

        }
        else {
            JsonArray array = jsonObject.getAsJsonArray("followers");
            ArrayList<String> arrayCopy = new ArrayList<>();
            ObservableList<String> followers = FXCollections.observableArrayList();

            for (JsonElement jsonElement : array) {
                arrayCopy.add(jsonElement.getAsString());
            }
            for (String follower : arrayCopy) {
                followers.add(follower);
            }
            ShowFollowersController.setList(followers);
        }
    }

    private void signupTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        if(error) {
            FourthSignUpController.setResult(jsonObject.get("Result").getAsString());
            FourthSignUpController.setIsDone(false);
        }
        else {
            LoginPageController.setUserId(jsonObject.get("Result").getAsInt());
            FourthSignUpController.setIsDone(true);
        }
    }

    private void signupPart1Task() {
        boolean error = jsonObject.get("error").getAsBoolean();
        if(error) {
           SignUpController.setResult(jsonObject.get("Result").getAsString());
            SignUpController.setIsDone(false);
        }
        else {
            SignUpController.setResult("Email and Username saved successfully");
            SignUpController.setIsDone(true);
        }
    }
    private void editBioTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        if(error) {
            EditProfileController.setResult(jsonObject.get("Result").getAsString());
        }
        else {
            EditProfileController.setResult(jsonObject.get("Result").getAsString());
        }
    }
    private void editPhotoTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        if(error) {
            EditProfileController.setResult(jsonObject.get("Result").getAsString());
        }
        else {
            EditProfileController.setResult(jsonObject.get("Result").getAsString());
        }
    }
    private void editUsernameTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        if(error) {
            EditProfileController.setResult(jsonObject.get("Result").getAsString());
        }
        else {
            EditProfileController.setResult(jsonObject.get("Result").getAsString());
        }
    }
    private void getImage() throws IOException {
        bytes = Client.readMessage();
    }
}
