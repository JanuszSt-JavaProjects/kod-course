package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    List<ForumUser> usersList = new ArrayList<>();

    public Forum() {
        usersList.add(new ForumUser(1, "John Smith", 'M', LocalDate.of(1995, 7, 2), 0));
        usersList.add(new ForumUser(2, "Antonio Banderas", 'M', LocalDate.of(2005, 6, 19), 0));
        usersList.add(new ForumUser(3, "Jane Blond", 'F', LocalDate.of(2000, 5, 29), 20));
        usersList.add(new ForumUser(4, "Manfred Black", 'M', LocalDate.of(1980, 4, 4), 20));
        usersList.add(new ForumUser(5, "Quentin Woodman", 'M', LocalDate.of(1975, 3, 26), 11));
        usersList.add(new ForumUser(6, "Marry  MacTrent", 'F', LocalDate.of(1963, 2, 5), 200));
        usersList.add(new ForumUser(7, "Betty Sunny", 'F', LocalDate.of(2002, 1, 18), 5));
        usersList.add(new ForumUser(8, "Miranda Noir", 'F', LocalDate.of(2000, 12, 12), 0));
        usersList.add(new ForumUser(9, "Victor McGregor", 'M', LocalDate.of(1955, 11, 27), 0));
        usersList.add(new ForumUser(10, "Joanna Wild", 'F', LocalDate.of(1998, 10, 17), 36));
        usersList.add(new ForumUser(11, "Zygfryd von Nov", 'M', LocalDate.of(2000, 9, 7), 97));
    }

    public List<ForumUser> getUsersList() {

        return new ArrayList<>(usersList);
    }

}
