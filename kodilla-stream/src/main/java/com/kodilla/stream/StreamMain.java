package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        Forum listOfUsers = new Forum();

        Map<Integer, ForumUser> filteredListOfUsers = listOfUsers.getUsersList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> user.getBirthday().getYear() >= 20)
                .filter(user -> user.getNumberOfPosts() > 0)
                .collect(Collectors.toMap(ForumUser::getIdentifier, user -> user));


        filteredListOfUsers.entrySet().stream()
                .map(entry -> " Identifier: " + entry.getKey() + ",  value:" + entry.getValue())
                .forEach(System.out::println);
    }
}