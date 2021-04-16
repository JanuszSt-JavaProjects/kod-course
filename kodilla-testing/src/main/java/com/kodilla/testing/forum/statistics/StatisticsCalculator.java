package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {

    private int usersTotal;
    private int postsTotal;
    private int commentsTotal;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    void calculateAdvStatistics(Statistics statistics) {
        usersTotal = statistics.usersNames().size();
        postsTotal = statistics.postsCount();
        commentsTotal = statistics.commentsCount();
        averagePostsPerUser = calculateAveragePostPerUser(postsTotal, usersTotal);
        averageCommentsPerUser = calculateAverageCommentsPerUser(commentsTotal, usersTotal);
        averageCommentsPerPost = calculateAverageCommentsPerPost(commentsTotal, postsTotal);
    }

    double calculateAveragePostPerUser(int numberOfPosts, int numberOfUsers) {
        if (usersTotal == 0) {
            return 0;
        } else {
            return (double) numberOfPosts / (double) numberOfUsers;
        }

    }

    double calculateAverageCommentsPerUser(int numberOfComments, int numberOfUsers) {
        if (usersTotal == 0) {
            return 0;
        } else {
            return (double) numberOfComments / (double) numberOfUsers;
        }
    }

    double calculateAverageCommentsPerPost(int numberOfComments, int numberOfPosts) {
        if (postsTotal == 0) {
            return 0;
        } else {
            return (double) numberOfComments / (double) numberOfPosts;
        }
    }

    void showStatistics() {
        System.out.println("Advanced statistics:\r\n" +
                "Total Users: " + usersTotal + "\r\n" +
                "Total Posts: " + postsTotal + "\r\n" +
                "Total Comments: " + commentsTotal + "\r\n" +
                "Average Posts Per User:  " + getAveragePostsPerUser() + "\r\n" +
                "Average Comments Per User:  " + getAverageCommentsPerUser() + "\r\n" +
                "Average Comments Per Post:  " + getAverageCommentsPerPost() + "\r\n");
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }
}