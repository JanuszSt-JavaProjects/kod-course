package com.kodilla.patterns.strategy.social;

public class User {

    protected String userName;
    protected SocialPublisher publisher;

    public User(String userName) {
        this.userName = userName;
    }

    protected void setPublisher(SocialPublisher publisher) {
        this.publisher = publisher;
    }

    protected String sharePost() {
        return publisher.share();
    }
}
