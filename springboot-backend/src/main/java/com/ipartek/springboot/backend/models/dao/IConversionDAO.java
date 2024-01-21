package com.ipartek.springboot.backend.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ipartek.springboot.backend.models.entity.Conversion;

@Repository
public interface IConversionDAO extends CrudRepository<Conversion, Long> {

}
