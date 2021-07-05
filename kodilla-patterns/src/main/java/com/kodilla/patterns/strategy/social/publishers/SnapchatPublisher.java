package com.kodilla.patterns.strategy.social.publishers;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class SnapchatPublisher implements SocialPublisher {
    @Override
    public String share() {
        String contentToPublish = "Snapchat";
        System.out.println(contentToPublish);
        return contentToPublish;
    }
}
