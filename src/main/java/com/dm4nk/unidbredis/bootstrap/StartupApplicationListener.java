package com.dm4nk.unidbredis.bootstrap;

import com.dm4nk.unidbredis.model.Classroom;
import com.dm4nk.unidbredis.model.Gender;
import com.dm4nk.unidbredis.model.Student;
import com.dm4nk.unidbredis.model.Teacher;
import com.dm4nk.unidbredis.repository.ClassroomRepository;
import com.dm4nk.unidbredis.repository.StudentRepository;
import com.dm4nk.unidbredis.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final ClassroomRepository classroomRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent ignored) {
        Student student = Student.builder()
                .id("123123")
                .gender(Gender.MALE)
                .name("Boba")
                .grade(1)
                .build();

        studentRepository.push(student);

        Teacher teacher = Teacher.builder()
                .name("teacher")
                .students(List.of(student))
                .build();

        teacherRepository.put(teacher);

        Classroom classroom = Classroom.builder()
                .locationName("14k")
                .number(510)
                .build();

        classroomRepository.add(classroom);
    }
}
