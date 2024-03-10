package com.example.Sem5HomeWork5.services;

import com.example.Sem5HomeWork5.models.Task;
import com.example.Sem5HomeWork5.repositories.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import static com.example.Sem5HomeWork5.models.TaskStatus.IN_PROGRESS;
import static com.example.Sem5HomeWork5.models.TaskStatus.NOT_STARTED;


@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock
    public TaskRepository taskRepository;
    @InjectMocks
    public TaskService taskService;

    @Test
    @DisplayName("updateTest")
    public void updateTaskTest(){

        // Предпосылка
        Task task1 = new Task();
        task1.setId(1L);
        task1.setStatus(NOT_STARTED);

        Task task2 = new Task();
        task2.setId(2L);
        task2.setStatus(IN_PROGRESS);

        given(taskRepository.findById(task1.getId())).willReturn(Optional.of(task1));
//        given(taskRepository.findById(task2.getId())).willReturn(Optional.of(task2));

        // Вызов
        taskService.updateTaskStatus(1L);

        // Проверка
        verify(taskRepository).findById(1L);
        verify(taskRepository).save(task1);
    }

}