package com.senla.bolkunets.virtualtestlab.dao;

import java.util.List;

public interface GenericDao<PKey, Entity> {
    void create(Entity entity);

    Entity read(PKey id);

    void update(Entity entity);

    void delete(Entity entity);

    List<Entity> readAll();

}
