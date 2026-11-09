package app.dto;

import app.entity.TaskStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime updated;
    private LocalDateTime created;
    private TaskStatus status;
}
