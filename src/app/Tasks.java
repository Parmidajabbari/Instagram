package app;

import com.google.gson.Gson;

public class Tasks {

    private static final String signUp =
            "{'task':'signUp', 'currentUserId':'0', 'currentUsername':'%s', 'password':'%s', 'email':'%s'}";
    private static final String signUpPart1 =
            "{'task':'signUpPart1', 'currentUserId':'0', 'username':'%s', 'email':'%s'}";
    private static final String showFollowers =
            "{'task':'showFollowers', 'currentUserId':'%s', 'username':'%s'}";
    private static final String showFollowings =
            "{'task':'showFollowings', 'currentUserId':'%s', 'username':'%s'}";
    private static final String showComments =
            "{'task':'showComments', 'currentUserId':'%s', 'postId':'%s'}";
    private static final String sendEmail =
            "{'task':'sendEmail', 'currentUserId':'0', 'username':'%s', 'email':'%s'}";
    private static final String checkCode =
            "{'task':'checkCode', 'currentUserId':'0', 'username':'%s', 'email':'%s', 'code':'%s'}";
    private static final String login =
            "{'task':'login', 'currentUserId':'0', 'username':'%s' 'password':'%s'}";
    private static final String timeline =
            "{'task':'timeline', 'currentUserId':'%s'}";
    private static final String newPost =
            "{'task':'newPost', 'currentUserId':'%s'}";
    private static final String like =
            "{'task':'like', 'currentUserId':'%s', 'postId':'%s'}";
    private static final String unLike =
            "{'task':'unLike', 'currentUserId':'%s', 'postId':'%s'}";
    private static final String profileView =
            "{'task':'profileView', 'currentUserId':'%s', 'viewedUserId':'%s'}";
    private static final String comment =
            "{'task':'comment', 'currentUserId':'%s', 'postId':'%s', 'comment':'%s'}";
    private static final String follow =
            "{'task':'follow', 'currentUserId':'%s', 'followedUserId':'%s'}";
    private static final String unFollow =
            "{'task':'unFollow', 'currentUserId':'%s', 'unFollowedUserId':'%s'}";
    private static final String block =
            "{'task':'block', 'currentUserId':'%s', 'blockedUserId':'%s'}";
    private static final String unBlock =
            "{'task':'unBlock', 'currentUserId':'%s', 'unBlockedUserId':'%s'}";
    private static final String search =
            "{'task':'search', 'currentUserId':'%s', 'searchedName':'%s'}";
    private static final String postView =
            "{'task':'postView', 'currentUserId':'%s', 'postId':'%s'}";
    private static final String notification =
            "{'task':'notification', 'currentUserId':'%s'}";
    private static final String direct =
            "{'task':'direct', 'currentUserId':'%s', 'secondUserId':'%s', 'message':'%s'}";

    public static String getSendEmail(String username, String email) {
        return new Gson().toJson(String.format(sendEmail, username, email));
    }

    public static String getCheckCode(String username, String email, String code) {
        return new Gson().toJson(String.format(checkCode, username, email, code));
    }

    public static String getShowFollowers(String currentUserId, String username) {
        return new Gson().toJson(String.format(showFollowers, currentUserId, username));
    }

    public static String getShowFollowings(String currentUserId, String username) {
        return new Gson().toJson(String.format(showFollowings, currentUserId, username));
    }

    public static String getShowComments(String currentUserId, String username) {
        return new Gson().toJson(String.format(showComments, currentUserId, username));
    }

    public static String getSignUpPart1(String username, String email) {
        return new Gson().toJson(String.format(signUpPart1, username, email));
    }

    public static String getSignUpTask(String currentUsername, String password, String email) {
        return new Gson().toJson(String.format(signUp, currentUsername, password, email));
    }

    public static String getLoginTask(String username, String password) {
        return new Gson().toJson(String.format(login, username, password));
    }

    public static String getTimelineTask(String currentUserId) {
        return new Gson().toJson(String.format(timeline, currentUserId));
    }

    public static String getNewPostTask(String currentUserId) {
        return new Gson().toJson(String.format(newPost, currentUserId));
    }

    public static String getLikeTask(String currentUserId, String postId) {
        return new Gson().toJson(String.format(like, currentUserId, postId));
    }

    public static String getUnLikeTask(String currentUserId, String postId) {
        return new Gson().toJson(String.format(unLike, currentUserId, postId));
    }

    public static String getProfileViewTask(String currentUserId, String viewedUserId) {
        return new Gson().toJson(String.format(profileView, currentUserId, viewedUserId));
    }

    public static String getCommentTask(String currentUserId, String postId, String commented) {
        return new Gson().toJson(String.format(comment, currentUserId, postId, commented));
    }

    public static String getFollowTask(String currentUserId, String followedUserId) {
        return new Gson().toJson(String.format(follow, currentUserId, followedUserId));
    }

    public static String getUnFollowTask(String currentUserId, String unFollowedUserId) {
        return new Gson().toJson(String.format(unFollow, currentUserId, unFollowedUserId));
    }

    public static String getBlockTask(String currentUserId, String blockedUserId) {
        return new Gson().toJson(String.format(block, currentUserId, blockedUserId));
    }

    public static String getUnBlockTask(String currentUserId, String unBlockedUserId) {
        return new Gson().toJson(String.format(unBlock, currentUserId, unBlockedUserId));
    }

    public static String getSearchTask(String currentUserId, String searchedName) {
        return new Gson().toJson(String.format(search, currentUserId, searchedName));
    }

    public static String getPostViewTask(String currentUserId, String postId) {
        return new Gson().toJson(String.format(postView, currentUserId, postId));
    }

    public static String getNotificationTask(String currentUserId) {
        return new Gson().toJson(String.format(notification, currentUserId));
    }

    public  static String getDirectTask(String currentUserId, String secondUserId, String message) {
        return new Gson().toJson(String.format(direct, currentUserId, secondUserId, message));
    }
}
