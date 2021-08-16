package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.library.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;

    @BeforeEach
    public void prepareData() {
        List<String> usersList = new ArrayList<>();
        usersList.add("Adam");
        usersList.add("Bartek");
        usersList.add("Oskar");
        usersList.add("Asia");
        usersList.add("Maja");
        when(statisticsMock.usersNames()).thenReturn(usersList);
    }

    @Test
    void testCalculateStatisticsAvgZeroPosts () {
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        when(statisticsMock.commentsCount()).thenReturn(250);

        //When
        calculateStatistics.calculateAvgStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(0, calculateStatistics.getAveragePostsPerUser()); //average posts per user
        Assertions.assertEquals(50, calculateStatistics.getAverageCommentsPerUser()); //average comments per user
        Assertions.assertEquals(0, calculateStatistics.getAverageCommentsPerPost()); //average comments per post
    }

    @Test
    void testCalculateStatisticsAvgThousandPosts () {
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(250);

        //When
        calculateStatistics.calculateAvgStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(200, calculateStatistics.getAveragePostsPerUser()); //average posts per user
        Assertions.assertEquals(50, calculateStatistics.getAverageCommentsPerUser()); //average comments per user
        Assertions.assertEquals(0.25, calculateStatistics.getAverageCommentsPerPost()); //average comments per post
    }

    @Test
    void testCalculateStatisticsAvgZeroComments () {
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        calculateStatistics.calculateAvgStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(20, calculateStatistics.getAveragePostsPerUser()); //average posts per user
        Assertions.assertEquals(0, calculateStatistics.getAverageCommentsPerUser()); //average comments per user
        Assertions.assertEquals(0, calculateStatistics.getAverageCommentsPerPost()); //average comments per post
    }

    @Test
    void testCalculateStatisticsAvgLessCommentsThenPosts () {
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(50);

        //When
        calculateStatistics.calculateAvgStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(20, calculateStatistics.getAveragePostsPerUser()); //average posts per user
        Assertions.assertEquals(10, calculateStatistics.getAverageCommentsPerUser()); //average comments per user
        Assertions.assertEquals(0.5, calculateStatistics.getAverageCommentsPerPost()); //average comments per post
    }

    @Test
    void testCalculateStatisticsAvgLessPostsThenComments () {
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(250);

        //When
        calculateStatistics.calculateAvgStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(20, calculateStatistics.getAveragePostsPerUser()); //average posts per user
        Assertions.assertEquals(50, calculateStatistics.getAverageCommentsPerUser()); //average comments per user
        Assertions.assertEquals(2.5, calculateStatistics.getAverageCommentsPerPost()); //average comments per post
    }

    @Test
    void testCalculateStatisticsAvgZeroUsers () {
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        List<String> usersList = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(250);

        //When
        calculateStatistics.calculateAvgStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(0, calculateStatistics.getAveragePostsPerUser()); //average posts per user
        Assertions.assertEquals(0, calculateStatistics.getAverageCommentsPerUser()); //average comments per user
        Assertions.assertEquals(2.5, calculateStatistics.getAverageCommentsPerPost()); //average comments per post
    }

    @Test
    void testCalculateStatisticsAvgHundredUsers () {
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        when(statisticsMock.usersNames()).thenReturn(generateUsers(100));
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(250);

        //When
        calculateStatistics.calculateAvgStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(1, calculateStatistics.getAveragePostsPerUser()); //average posts per user
        Assertions.assertEquals(2.5, calculateStatistics.getAverageCommentsPerUser()); //average comments per user
        Assertions.assertEquals(2.5, calculateStatistics.getAverageCommentsPerPost()); //average comments per post
    }

    List<String> generateUsers(int numberOfUsers) {
        List<String> usersList = new ArrayList<>();

        for (int i = 0; i < numberOfUsers; i++) {
            usersList.add(i + " User");
        }
        return usersList;
    }
}
