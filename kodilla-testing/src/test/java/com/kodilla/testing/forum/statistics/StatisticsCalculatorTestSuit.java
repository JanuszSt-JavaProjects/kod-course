package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticsCalculatorTestSuit {

    @Mock
    Statistics statisticsMock;// = mock(Statistics.class);
    StatisticsCalculator statisticsCalculator = new StatisticsCalculator();

    private List<String> fillUsersList(int numberOfUsers) {
        List<String> testedUsersList = new ArrayList<>();
        for (int i = 0; i < numberOfUsers; i++) {
            testedUsersList.add("AnyName" + i);
        }
        return testedUsersList;
    }


    @Test
    void testCalculateAdvStatistics_withOneThousandPosts() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(1000);                             // Posts number
        when(statisticsMock.usersNames()).thenReturn(fillUsersList(10));   // Users number
        when(statisticsMock.commentsCount()).thenReturn(100);                          // Comments number
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        double averagePostsPerUser = statisticsCalculator.getAveragePostsPerUser();
        double averageCommentsPerUser = statisticsCalculator.getAverageCommentsPerUser();
        double averageCommentsPerPost = statisticsCalculator.getAverageCommentsPerPost();

        //Then
        statisticsCalculator.showStatistics();

        Assertions.assertEquals(100, averagePostsPerUser);
        Assertions.assertEquals(10, averageCommentsPerUser);
        Assertions.assertEquals(0.1, averageCommentsPerPost);
    }

    @Test
    void testCalculateAdvStatistics_withZeroPosts() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);                                // Posts number
        when(statisticsMock.usersNames()).thenReturn(fillUsersList(10));   // Users number
        when(statisticsMock.commentsCount()).thenReturn(0);                            // Comments number
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        double averagePostsPerUser = statisticsCalculator.getAveragePostsPerUser();
        double averageCommentsPerUser = statisticsCalculator.getAverageCommentsPerUser();
        double averageCommentsPerPost = statisticsCalculator.getAverageCommentsPerPost();

        //Then
        statisticsCalculator.showStatistics();

        Assertions.assertEquals(0, averagePostsPerUser);
        Assertions.assertEquals(0, averageCommentsPerUser);
        Assertions.assertEquals(0, averageCommentsPerPost);
    }

    @Test
    void testCalculateAdvStatistics_withZeroComments() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(100);                              // Posts number
        when(statisticsMock.usersNames()).thenReturn(fillUsersList(10));   // Users number
        when(statisticsMock.commentsCount()).thenReturn(0);                             // Comments number
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        double averagePostsPerUser = statisticsCalculator.getAveragePostsPerUser();
        double averageCommentsPerUser = statisticsCalculator.getAverageCommentsPerUser();
        double averageCommentsPerPost = statisticsCalculator.getAverageCommentsPerPost();

        //Then
        statisticsCalculator.showStatistics();

        Assertions.assertEquals(10, averagePostsPerUser);
        Assertions.assertEquals(0, averageCommentsPerUser);
        Assertions.assertEquals(0, averageCommentsPerPost);
    }

    @Test
    void testCalculateAdvStatistics_withCommentsMoreThanPostsCondition() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(10);                             // Posts number
        when(statisticsMock.usersNames()).thenReturn(fillUsersList(5));   // Users number
        when(statisticsMock.commentsCount()).thenReturn(50);                          // Comments number
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        double averagePostsPerUser = statisticsCalculator.getAveragePostsPerUser();
        double averageCommentsPerUser = statisticsCalculator.getAverageCommentsPerUser();
        double averageCommentsPerPost = statisticsCalculator.getAverageCommentsPerPost();

        //Then
        statisticsCalculator.showStatistics();

        Assertions.assertEquals(2, averagePostsPerUser);
        Assertions.assertEquals(10, averageCommentsPerUser);
        Assertions.assertEquals(5, averageCommentsPerPost);
    }

    @Test
    void testCalculateAdvStatistics_withCommentsLessThanPostsCondition() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(100);                             // Posts number
        when(statisticsMock.usersNames()).thenReturn(fillUsersList(5));   // Users number
        when(statisticsMock.commentsCount()).thenReturn(50);                          // Comments number
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        double averagePostsPerUser = statisticsCalculator.getAveragePostsPerUser();
        double averageCommentsPerUser = statisticsCalculator.getAverageCommentsPerUser();
        double averageCommentsPerPost = statisticsCalculator.getAverageCommentsPerPost();

        //Then
        statisticsCalculator.showStatistics();

        Assertions.assertEquals(20, averagePostsPerUser);
        Assertions.assertEquals(10, averageCommentsPerUser);
        Assertions.assertEquals(0.5, averageCommentsPerPost);
    }

    @Test
    void testCalculateAdvStatistics_withZeroUsers() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);                               // Posts number
        when(statisticsMock.usersNames()).thenReturn(fillUsersList(0));   // Users number
        when(statisticsMock.commentsCount()).thenReturn(0);                            // Comments number
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        double averagePostsPerUser = statisticsCalculator.getAveragePostsPerUser();
        double averageCommentsPerUser = statisticsCalculator.getAverageCommentsPerUser();
        double averageCommentsPerPost = statisticsCalculator.getAverageCommentsPerPost();

        //Then
        statisticsCalculator.showStatistics();

        Assertions.assertEquals(0, averagePostsPerUser);
        Assertions.assertEquals(0, averageCommentsPerUser);
        Assertions.assertEquals(0, averageCommentsPerPost);
    }

    @Test
    void testCalculateAdvStatistics_withOneHundredUsers() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(25);                                // Posts number
        when(statisticsMock.usersNames()).thenReturn(fillUsersList(100));   // Users number
        when(statisticsMock.commentsCount()).thenReturn(50);                             // Comments number
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        double averagePostsPerUser = statisticsCalculator.getAveragePostsPerUser();
        double averageCommentsPerUser = statisticsCalculator.getAverageCommentsPerUser();
        double averageCommentsPerPost = statisticsCalculator.getAverageCommentsPerPost();

        //Then
        statisticsCalculator.showStatistics();

        Assertions.assertEquals(0.25, averagePostsPerUser);
        Assertions.assertEquals(0.5, averageCommentsPerUser);
        Assertions.assertEquals(2, averageCommentsPerPost);
    }
}
