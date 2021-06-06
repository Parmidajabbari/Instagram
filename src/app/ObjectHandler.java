package app;

public class ObjectHandler {
    private Object object;
    private User user;
    private Comment comment;
    private Post post;
    public ObjectHandler(Object object) {
        this.object = object;
        if(object instanceof User) {
            user = (User) object;
        }

        else if (object instanceof Comment) {
            comment  = (Comment) object;
        }

        else {
            post = (Post) object;
        }
    }
    public User getUser() {
        return user;
    }

    public Comment getComment() {
        return comment;
    }

    public Post getPost() {
        return post;
    }
}
