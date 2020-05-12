package io.chetan.dao;

import org.springframework.data.repository.CrudRepository;

import io.chetan.model.Pg;


public interface PgDao extends CrudRepository<Pg, Long>
{

}
