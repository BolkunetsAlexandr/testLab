package com.senla.bolkunets.virtualtestlab.domain.dao;

import java.util.List;

public interface GenericDao<PKey, Entity> {
    Entity create(Entity entity);

    Entity read(PKey id);

    void update(Entity entity);

    void delete(Entity entity);

    List<Entity> readAll();

}
