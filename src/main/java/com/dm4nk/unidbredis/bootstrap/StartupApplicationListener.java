package com.dm4nk.unidbredis.bootstrap;

import com.dm4nk.unidbredis.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private final StudentRepository studentRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent ignored) {
//        Student student = Student.builder()
//                .id("123123")
//                .gender(Gender.MALE)
//                .name("Boba")
//                .grade(1)
//                .build();
//
//        studentRepository.save(student);
//
//        Student retrievedStudent = studentRepository.findById("123123").get();
//
//        log.debug(retrievedStudent.toString());
    }
}
