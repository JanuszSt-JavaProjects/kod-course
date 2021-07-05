package com.kodilla.patterns.strategy.social.publishers;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class TwitterPublisher implements SocialPublisher {
    @Override
    public String share() {
        String contentToPublish = "Twitter";
        System.out.println(contentToPublish);
        return contentToPublish;
    }
}
