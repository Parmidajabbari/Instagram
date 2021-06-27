package app;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jfoenix.controls.JFXTextField;
import controllers.*;

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

    public void doTask() {
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
        }
    }

    private void postViewTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        if(error) {
        }
        else {
        }
    }

    private void searchTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = SearchPageController.getResultText();
        if(error) {
            resultText.setText(jsonObject.get("result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
            SearchPageController.setResultText(resultText);
        }
        else {
            //get given username id from server
           // String massage = Tasks.getProfileViewTask(Long.toString(LoginPageController.getUserId()),);
            // Client.sendRequest(massage);
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
            //String massage = Tasks.getProfileViewTask(Long.toString(LoginPageController.getUserId()),);
           // Client.sendRequest(massage);
        }
    }

    private void followTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = new JFXTextField();
        if(error) {
            resultText.setText(jsonObject.get("result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        else {
            //String massage = Tasks.getProfileViewTask(Long.toString(LoginPageController.getUserId()),);
            // Client.sendRequest(massage);
        }
}

    private void commentTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = new JFXTextField();
        if(error) {
            resultText.setText(jsonObject.get("result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        else {
            //String massage = Tasks.getCommentTask();
            // Client.sendRequest(massage);
        }
    }

    private void profileViewTask() {

    }

    private void unlikeTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = new JFXTextField();
        if(error) {
            resultText.setText(jsonObject.get("result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        else {
            //String massage = Tasks.getPostViewTask(Long.toString(LoginPageController.getUserId()),);
            // Client.sendRequest(massage);
        }
    }

    private void likeTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = new JFXTextField();
        if(error) {
            resultText.setText(jsonObject.get("result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        else {
            //String massage = Tasks.getPostViewTask(Long.toString(LoginPageController.getUserId()),);
            // Client.sendRequest(massage);
        }
    }

    private void newPostTask() {
    }

    private void timelineTask() {
    }

    private void loginTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = LoginPageController.getResultText();
        if(error) {
            resultText.setText(jsonObject.get("result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
            LoginPageController.setResultText(resultText);
            LoginPageController.setIsDone(false);
        }
        else {
            LoginPageController.setIsDone(true);
        }
    }

    private void checkCodeTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = SecondSignUpController.getResultText();
        if(error) {
            resultText.setText(jsonObject.get("result").getAsString());
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
    }

    private void showFollowingsTask() {
    }

    private void showFollowersTask() {
    }

    private void signupTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = FourthSignUpController.getResultText();
        if(error) {
            resultText.setText(jsonObject.get("result").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
            FourthSignUpController.setIsDone(false);
        }
        else {
            FourthSignUpController.setIsDone(true);
        }
        FourthSignUpController.setResultText(resultText);
    }

    private void signupPart1Task() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = SignUpController.getResultText();
        if(error) {
            resultText.setText(jsonObject.get("result").getAsString());
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

}
