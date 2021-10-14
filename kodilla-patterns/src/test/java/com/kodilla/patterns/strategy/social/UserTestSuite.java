package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User user1 = new Millenials("user1");
        User user2 = new YGeneration("user2");
        User user3 = new ZGeneration("user3");

        //When
        String user1ShouldShare = user1.sharePost();
        String user2ShouldShare = user2.sharePost();
        String user3ShouldShare = user3.sharePost();

        //Then
        assertEquals("Sharing post on Twitter", user1ShouldShare);
        assertEquals("Sharing post on Facebook", user2ShouldShare);
        assertEquals("Sharing post on Snapchat", user3ShouldShare);

    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User user = new Millenials("user");

        //When
        user.setSharingMedia(new SnapchatPublisher());

        //Then
        assertEquals("Sharing post on Snapchat", user.sharePost());
    }
}
