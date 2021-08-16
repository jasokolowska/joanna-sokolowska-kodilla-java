package com.kodilla.testing.forum.statistics;

public class CalculateStatistics {
    private Statistics statistics;

    private int usersQuantity;
    private int postQuantity;
    private int commentsQuantity;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public CalculateStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAvgStatistics(Statistics statistics){
        this.usersQuantity = statistics.usersNames().size();
        this.postQuantity = statistics.postsCount();
        this.commentsQuantity = statistics.commentsCount();
        this.averagePostsPerUser = (usersQuantity == 0) ? 0 : (double) postQuantity/usersQuantity;
        this.averageCommentsPerPost = (postQuantity == 0) ? 0 : (double) commentsQuantity/postQuantity;
        this.averageCommentsPerUser = (usersQuantity == 0) ? 0 :(double) commentsQuantity/usersQuantity;
    }

    public void showStatistics() {
        System.out.println("Average post per User: " + this.averagePostsPerUser
                        + "\nAverage comments per post: " + this.averageCommentsPerPost
                        + "\nAverage comments per User: " + this.averageCommentsPerUser);
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
