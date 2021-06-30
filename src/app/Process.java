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

        switch (task.toLowerCase(Locale.ROOT)) {

            case "signuppart1" : signupPart1Task();
                break;
            case "signup" : signupTask();
                break;
            case "showfollowers" : showFollowersTask();
                break;
            case "showfollowings" : showFollowingsTask();
                break;
            case "showcomments" : showCommentsTask();
                break;
            case "sendemail" : sendEmailTask();
                break;
            case "checkcode" : checkCodeTask();
                break;
            case "login" : loginTask();
                break;
            case "timeline" : timelineTask();
                break;
            case "newpost" : newPostTask();
                break;
            case "like" : likeTask();
                break;
            case "unlike" : unlikeTask();
                break;
            case "profileview" : profileViewTask();
                break;
            case "comment" : commentTask();
                break;
            case "follow" : followTask();
                break;
            case "unfollow" : unFollowTask();
                break;
            case "block" : blockTask();
                break;
            case "unblock" : unBlockTask();
                break;
            case "search" : searchTask();
                break;
            case "postview" : postViewTask();
                break;
            case "notification" : notificationTask();
                break;
            case "direct" : directTask();
                break;
            case "editusername" :  editUsernameTask();
                break;
            case "editbio" : editBioTask();
                break;
            case "editphoto" : editPhotoTask();
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
            ActivityPageController.getNotificationList().setItems(notifications);
        }
    }

    private void postViewTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        if(error) {
        }
        else {
            String photo = jsonObject.get("image").getAsString();
            String caption = jsonObject.get("caption").getAsString();
            int likesCount = jsonObject.get("likes").getAsInt();
            int commentsCount = jsonObject.get("comments").getAsInt();
            String username = jsonObject.get("ownerName").getAsString();
            String date = jsonObject.get("uploaded").getAsString();
            int ownerId = jsonObject.get("ownerId").getAsInt();
            Post post = new Post(photo,caption,likesCount,commentsCount,username,date,ownerId);
            ShowPostController.setPost(post);
        }
    }

    private void searchTask() throws IOException {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = SearchPageController.getResultText();
        if(error) {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
            SearchPageController.setResultText(resultText);
        }
        else {
            String message = Tasks.getProfileViewTask(Integer.toString(LoginPageController.getUserId()),
                    jsonObject.get("Result").getAsString());
            //Client.sendRequest(message);
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

    private void unFollowTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = new JFXTextField();
        if(error) {
            resultText.setText(jsonObject.get("result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        else {
            //String massage = Tasks.getProfileViewTask(Integer.toString(LoginPageController.getUserId()),);
            //Client.sendRequest(massage);
        }
    }

    private void followTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = new JFXTextField();
        if(error) {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        else {
            //String massage = Tasks.getProfileViewTask(Integer.toString(LoginPageController.getUserId()), );
            // Client.sendRequest(massage);
        }
}

    private void commentTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = new JFXTextField();
        if(error) {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        else {
            int commentId = jsonObject.get("Result").getAsInt();
            //String massage = Tasks.getCommentTask();
            // Client.sendRequest(massage);
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

    private void unlikeTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = new JFXTextField();
        if(error) {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        else {
            //String massage = Tasks.getPostViewTask(Integer.toString(LoginPageController.getUserId()),);
            // Client.sendRequest(massage);
        }
    }

    private void likeTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = new JFXTextField();
        if(error) {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        else {
            //String massage = Tasks.getPostViewTask(Integer.toString(LoginPageController.getUserId()),);
            // Client.sendRequest(massage);
        }
    }

    private void newPostTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = NewPostController.getResultText();
        if(error) {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
            NewPostController.setResultText(resultText);
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
        JFXTextField resultText = LoginPageController.getResultText();
        if(error) {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
            LoginPageController.setResultText(resultText);
            LoginPageController.setIsDone(false);
        }
        else {
            LoginPageController.setUserId(jsonObject.get("Result").getAsInt());
            LoginPageController.setIsDone(true);
        }
    }

    private void checkCodeTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = SecondSignUpController.getResultText();
        if(error) {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
            SecondSignUpController.setIsDone(false);

        }
        else {
            resultText.setText("Email verified successfully");
            resultText.setStyle("-fx-text-inner-color: green;");
            SecondSignUpController.setIsDone(true);
        }
        SecondSignUpController.setResultText(resultText);
    }

    private void sendEmailTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = new JFXTextField();
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
            CommentPageController.getCommentsList().setItems(comments);
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
            ShowFollowingsController.getFollowingsList().setItems(followings);
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
            ShowFollowersController.getFollowersList().setItems(followers);
        }
    }

    private void signupTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = FourthSignUpController.getResultText();
        if(error) {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
            FourthSignUpController.setIsDone(false);
        }
        else {
            LoginPageController.setUserId(jsonObject.get("Result").getAsInt());
            FourthSignUpController.setIsDone(true);
        }
        FourthSignUpController.setResultText(resultText);
    }

    private void signupPart1Task() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = SignUpController.getResultText();
        if(error) {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
            SignUpController.setIsDone(false);
        }
        else {
            resultText.setText("Email and Username saved successfully");
            resultText.setStyle("-fx-text-inner-color: green;");
            SignUpController.setIsDone(true);
        }
        SignUpController.setResultText(resultText);

    }
    private void editBioTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = EditProfileController.getResultText();
        if(error) {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        else {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        EditProfileController.setResultText(resultText);
    }
    private void editPhotoTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = EditProfileController.getResultText();
        if(error) {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        else {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        EditProfileController.setResultText(resultText);
    }
    private void editUsernameTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = EditProfileController.getResultText();
        if(error) {
            resultText.setText(jsonObject.get("Result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        else {
            resultText.setText("Username saved successfully");
            resultText.setStyle("-fx-text-inner-color: green;");
        }
        EditProfileController.setResultText(resultText);
    }
}
