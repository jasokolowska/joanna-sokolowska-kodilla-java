package com.kodilla.patterns.strategy.social;

public class User {

    private String username;
    protected SocialPublisher socialPublisher;

    public User(String username) {
        this.username = username;
    }

    public String sharePost() {
        return socialPublisher.share();
    }

    public void setSharingMedia(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }
}
