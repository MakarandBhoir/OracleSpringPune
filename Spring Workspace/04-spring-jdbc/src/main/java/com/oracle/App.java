package com.oracle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.oracle.config.AppConfig;
import com.oracle.dao.StudentDao;
import com.oracle.model.Student;

public class App {
    public static void main(String[] args) {
    	var context = new AnnotationConfigApplicationContext(AppConfig.class);

        StudentDao dao = context.getBean(StudentDao.class);
        dao.init();
        
        dao.findAll().forEach(System.out::println);

        dao.save(new Student(3, "Charlie", 24));

        System.out.println("After insert:");
        dao.findAll().forEach(System.out::println);
        
        dao.destroy();
        context.close();
    }
}
