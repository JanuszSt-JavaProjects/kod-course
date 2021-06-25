package com.kodilla.spring.library.reader;

import com.kodilla.spring.reader.Reader;
import com.kodilla.spring.reader.ReaderConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ReaderTestSuite {

    @Test
    void testRead() {
        //Given
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ReaderConfig.class);

        Reader reader = context.getBean(Reader.class);

        //When & Then

        reader.read();
    }

    @Test
    void testConditional() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);
        //When
        boolean book2Exists = context.containsBean("book2");
        //Then
        System.out.println("Bean book2 was found in the container: " + book2Exists);
    }


}
