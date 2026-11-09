package app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name="created_at", nullable = false)
    private LocalDateTime create;

    @Column(name="updated_at", nullable = false)
    private LocalDateTime update;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;
}


