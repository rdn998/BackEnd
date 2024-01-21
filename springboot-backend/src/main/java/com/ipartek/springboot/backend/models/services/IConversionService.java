package com.ipartek.springboot.backend.models.services;

import java.util.List;
import com.ipartek.springboot.backend.models.entity.Conversion;

public interface IConversionService {

	List<Conversion> findAll();

	Conversion save(Conversion u);

	void deleteById(Long id);

}
