package app.mapper;

import app.dto.TaskDto;
import app.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface TaskMapper {

    @Mapping(source = "create", target = "created")
    @Mapping(source = "update", target = "updated")
    TaskDto toDto(Task task);
    Task toEntity(TaskDto dto);
}
