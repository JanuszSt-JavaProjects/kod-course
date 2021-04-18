package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int identifier;
    private final String username;
    private final char sex;
    private final LocalDate birthday;
    private final int numberOfPosts;

    public ForumUser(final int identifier, final String username, final char sex, final LocalDate birthday, final int numberOfPosts) {
        this.identifier = identifier;
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.numberOfPosts = numberOfPosts;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    @Override
    public String toString() {
        return " ForumUser{" +
                "identifier=" + identifier +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", numberOfPosts=" + numberOfPosts +
                '}';
    }
}
