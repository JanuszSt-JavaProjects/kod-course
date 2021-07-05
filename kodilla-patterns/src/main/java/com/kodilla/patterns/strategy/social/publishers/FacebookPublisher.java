package com.kodilla.patterns.strategy.social.publishers;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class FacebookPublisher implements SocialPublisher {
    @Override
    public String share() {
        String contentToPublish = "Facebook";
        System.out.println(contentToPublish);
        return contentToPublish;
    }
}
