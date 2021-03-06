package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void findById_basic() {
        Student student = entityManager.find(Student.class, 20001L);

        Assert.assertNotNull(student);
        Assert.assertNotNull(student.getPassport());
    }

    @Test
    @Transactional
    public void someTest() {
        someDummyOperation();
    }

    private void someDummyOperation() {
        Student student = entityManager.find(Student.class, 20001L);

        Passport passport = student.getPassport();

        passport.setNumber("E123457");
        student.setName("Ranga - updated");
    }

}
