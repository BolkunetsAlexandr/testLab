package com.senla.bolkunets.virtualtestlab.dao;

import java.util.List;

public interface GenericDao<PKey, Entity> {
    Entity create(Entity entity);

    Entity update(Entity entity);

    Entity delete(Entity entity);

    List<Entity> readAll();

    Entity findById(PKey id);
}
