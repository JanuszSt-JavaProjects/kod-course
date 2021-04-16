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
    Statistics statisticsMock;
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
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.usersNames()).thenReturn(fillUsersList(10));
        when(statisticsMock.commentsCount()).thenReturn(100);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(100, statisticsCalculator.getAveragePostsPerUser());
        Assertions.assertEquals(10, statisticsCalculator.getAverageCommentsPerUser());
        Assertions.assertEquals(0.1, statisticsCalculator.getAverageCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatistics_withZeroPosts() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(fillUsersList(10));
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(0, statisticsCalculator.getAveragePostsPerUser());
        Assertions.assertEquals(0, statisticsCalculator.getAverageCommentsPerUser());
        Assertions.assertEquals(0, statisticsCalculator.getAverageCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatistics_withZeroComments() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.usersNames()).thenReturn(fillUsersList(10));
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(10, statisticsCalculator.getAveragePostsPerUser());
        Assertions.assertEquals(0, statisticsCalculator.getAverageCommentsPerUser());
        Assertions.assertEquals(0, statisticsCalculator.getAverageCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatistics_withCommentsMoreThanPostsCondition() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.usersNames()).thenReturn(fillUsersList(5));
        when(statisticsMock.commentsCount()).thenReturn(50);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(2, statisticsCalculator.getAveragePostsPerUser());
        Assertions.assertEquals(10, statisticsCalculator.getAverageCommentsPerUser());
        Assertions.assertEquals(5, statisticsCalculator.getAverageCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatistics_withCommentsLessThanPostsCondition() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.usersNames()).thenReturn(fillUsersList(5));
        when(statisticsMock.commentsCount()).thenReturn(50);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(20, statisticsCalculator.getAveragePostsPerUser());
        Assertions.assertEquals(10, statisticsCalculator.getAverageCommentsPerUser());
        Assertions.assertEquals(0.5, statisticsCalculator.getAverageCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatistics_withZeroUsers() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(fillUsersList(0));
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(0, statisticsCalculator.getAveragePostsPerUser());
        Assertions.assertEquals(0, statisticsCalculator.getAverageCommentsPerUser());
        Assertions.assertEquals(0, statisticsCalculator.getAverageCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatistics_withOneHundredUsers() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(25);
        when(statisticsMock.usersNames()).thenReturn(fillUsersList(100));
        when(statisticsMock.commentsCount()).thenReturn(50);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(0.25, statisticsCalculator.getAveragePostsPerUser());
        Assertions.assertEquals(0.5, statisticsCalculator.getAverageCommentsPerUser());
        Assertions.assertEquals(2, statisticsCalculator.getAverageCommentsPerPost());
    }
}
