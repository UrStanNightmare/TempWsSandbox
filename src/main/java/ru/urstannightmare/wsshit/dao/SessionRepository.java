package ru.urstannightmare.wsshit.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.urstannightmare.wsshit.entity.Session;

@Repository
public interface SessionRepository extends CrudRepository<Session, String> {

}
