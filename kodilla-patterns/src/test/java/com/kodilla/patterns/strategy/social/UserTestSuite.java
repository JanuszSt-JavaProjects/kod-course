package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;
import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserTestSuite {

    Millenials millenialsUser = new Millenials("Morpheus");
    YGeneration yGenerationUser = new YGeneration("YattaMan");
    ZGeneration zGenerationUser = new ZGeneration("Zombie");


    @Test
    void testDefaultSharingStrategies() {

        assertEquals("Twitter", millenialsUser.sharePost());
        assertEquals("Facebook", yGenerationUser.sharePost());
        assertEquals("Snapchat", zGenerationUser.sharePost());
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given

        //When
        millenialsUser.setPublisher(new FacebookPublisher());
        yGenerationUser.setPublisher(new SnapchatPublisher());
        zGenerationUser.setPublisher(new TwitterPublisher());

        //Then
        assertEquals("Facebook", millenialsUser.sharePost());
        assertEquals("Snapchat", yGenerationUser.sharePost());
        assertEquals("Twitter", zGenerationUser.sharePost());

    }

}
