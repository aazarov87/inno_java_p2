package ru.inno.edu.exampleJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestComponent {
    /*public TestComponent(TestRepo testRepo) {
        this.testRepo = testRepo;
    }*/

    @Autowired
    TestRepo testRepo;

    void meth (){
        System.out.println("meth testRepo = " + testRepo);
    }

    public TestComponent() {
    }
}
