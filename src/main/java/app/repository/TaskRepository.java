package app.repository;

import app.entity.Task;
import app.entity.TaskStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class TaskRepository implements CRUDRepository<Task> {
    private final JdbcTemplate jdbc;

    @Override
    public Task create(Task task) {
        log.info("Save task");
        String sql = "INSERT INTO task (title, description, created_at, updated_at)" +
                " VALUES (?, ?, ?, ?)";
        LocalDateTime now = LocalDateTime.now();
        task.setCreate(now);
        task.setUpdate(now);
        int result = jdbc.update(sql, task.getTitle(), task.getDescription(), task.getCreate(), task.getUpdate());
        return result > 1 ? task : null;
    }

    @Override
    public Task findById(Long id) {
        log.info("Get by Id");
        String sql = "SELECT * FROM task WHERE id = ?";
        return jdbc.queryForObject(
                sql,
                TASK_ROW_MAPPER,
                id
        );
    }

    @Override
    public List<Task> findAll() {
        log.info("Get all");
        String sql = "SELECT * FROM task";
        return jdbc.query(
                sql,
                TASK_ROW_MAPPER
        );
    }

    @Override
    public Task update(Task task) {
        log.info("Update Task");
        String sql = "UPDATE task SET title = ?, description = ?, updated_at = ?, status = ?::task_status WHERE id = ?";
        task.setUpdate(LocalDateTime.now());
        int result = jdbc.update(
                sql,
                task.getTitle(),
                task.getDescription(),
                task.getUpdate(),
                task.getStatus().name(),
                task.getId()
        );
        return result > 1 ? task : null;
    }

    @Override
    public void delete(Long id) {
        log.info("Delete Task");
        String sql = "DELETE task WHERE id = ?";
        jdbc.update(sql,id);
    }

    private static final RowMapper<Task> TASK_ROW_MAPPER = (rs, rowNum) -> {
        Task task = new Task();
        task.setId(rs.getLong("id"));
        task.setTitle(rs.getString("title"));
        task.setDescription(rs.getString("description"));
        task.setStatus(TaskStatus.customValueOf(rs.getString("status")));
        task.setCreate(rs.getObject("created_at", LocalDateTime.class));
        task.setUpdate(rs.getObject("updated_at", LocalDateTime.class));
        return task;
    };
}


