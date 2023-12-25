package ru.urstannightmare.wsshit.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@RedisHash(value = "Session")
@AllArgsConstructor
@Getter
@Setter
public class Session implements Serializable {
    @Id
    @AccessType(AccessType.Type.PROPERTY)
    private String id;
    private List<String> sessions;
}
