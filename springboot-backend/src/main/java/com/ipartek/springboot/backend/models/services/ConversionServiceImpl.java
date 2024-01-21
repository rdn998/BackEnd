package com.ipartek.springboot.backend.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ipartek.springboot.backend.models.dao.IConversionDAO;
import com.ipartek.springboot.backend.models.entity.Conversion;

@Service
public class ConversionServiceImpl implements IConversionService {

	@Autowired
	private IConversionDAO conversionDAO;

	@Override
	public List<Conversion> findAll() {
		return (List<Conversion>) conversionDAO.findAll();
	}

	@Override
	public Conversion save(Conversion u) {
		return conversionDAO.save(u);
	}

	@Override
	public void deleteById(Long id) {
		conversionDAO.deleteById(id);
	}

}
