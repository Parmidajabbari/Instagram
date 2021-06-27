package app;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jfoenix.controls.JFXTextField;
import controllers.FourthSignUpController;
import controllers.LoginPageController;
import controllers.SignUpController;

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
    }

    private void notificationTask() {
    }

    private void postViewTask() {
    }

    private void searchTask() {
    }

    private void unBlockTask() {
    }

    private void blockTask() {
    }

    private void unFollowTask() {
    }

    private void followTask() {
    }

    private void commentTask() {
    }

    private void profileViewTask() {
    }

    private void unlikeTask() {
    }

    private void likeTask() {
    }

    private void newPostTask() {
    }

    private void timelineTask() {
    }

    private void loginTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = new JFXTextField();
        if(error) {
            resultText.setText(jsonObject.get("value").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
            LoginPageController.setResultText(resultText);
            LoginPageController.setSet(false);
        }
        else {
            LoginPageController.setSet(true);
        }
    }

    private void checkCodeTask() {

    }

    private void sendEmailTask() {
    }

    private void showCommentsTask() {
    }

    private void showFollowingsTask() {
    }

    private void showFollowersTask() {
    }

    private void signupTask() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = new JFXTextField();
        if(error) {
            resultText.setText(jsonObject.get("value").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
        }
        else {

        }
        FourthSignUpController.setResultText(resultText);
    }

    private void signupPart1Task() {
        boolean error = jsonObject.get("error").getAsBoolean();
        JFXTextField resultText = new JFXTextField();
        if(error) {
            resultText.setText(jsonObject.get("value").getAsString());
            resultText.setStyle("-fx-text-inner-color: red;");
            SignUpController.setSet(false);
        }
        else {
            resultText.setText("Email and Username saved successfully");
            resultText.setStyle("-fx-text-inner-color: green;");
            SignUpController.setSet(true);
        }
        SignUpController.setResultText(resultText);
    }

}
