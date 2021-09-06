package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class HomeworkTestSuite {

    @Test
    void HomeworkTest() {
        // Given
        Mentor mentor1 = new Mentor(1, "TheBestMentor_D");
        Mentor mentor2 = new Mentor(2, "EveryOtherWeakMentor");

        Homework homework1 = new Homework(new Student(1, "FirstStudent"));
        Homework homework2 = new Homework(new Student(2, "SecondStudent"));
        Homework homework3 = new Homework(new Student(3, "ThirdStudent"));


        //When
        homework1.registerMentor(mentor1);
        homework2.registerMentor(mentor1);
        homework3.registerMentor(mentor2);

        homework1.addHomework("FirstHomework");
        homework2.addHomework("SecondHomework");
        homework3.addHomework("thirdHomework");

        //THen
        Assertions.assertEquals(2,mentor1.getHomeworksList().size());
        Assertions.assertEquals(1,mentor2.getHomeworksList().size());
    }
}