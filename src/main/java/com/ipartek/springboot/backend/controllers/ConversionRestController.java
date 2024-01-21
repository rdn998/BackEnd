package com.ipartek.springboot.backend.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ipartek.springboot.backend.models.entity.Conversion;
import com.ipartek.springboot.backend.models.services.IConversionService;

@RestController
@RequestMapping("/api")
public class ConversionRestController {

	@Autowired
	private IConversionService conversionService;
	private final String VAR = "Conversion";

	@CrossOrigin(origins = { "http://localhost:4200" })
	@GetMapping("/unity")
	public ResponseEntity<?> findAll() {
		Map<String, Object> response = new HashMap<>();
		List<Conversion> cons = new ArrayList<>();
		try {
			cons = conversionService.findAll();
		} catch (DataAccessException ex) {
			response.put("Message", "Data Error On DB, Error On Find All " + VAR);
			response.put("Error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (cons.isEmpty()) {
			response.put("Message", "Data Has Not Found On Find All " + VAR);
			response.put("Error", "Data Not Found");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Conversion>>(cons, HttpStatus.OK);
	}

	@CrossOrigin(origins = { "http://localhost:4200" })
	@PostMapping("/unity")
	public ResponseEntity<?> create(@RequestBody Conversion i) {
		Map<String, Object> response = new HashMap<>();
		Conversion con = null;
		try {
			con = conversionService.save(i);
		} catch (DataAccessException ex) {
			response.put("Message", "Data Error On DB, Error On Create " + VAR);
			response.put("Error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("Message", VAR + " Succesfully Created");
		response.put(VAR, con);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@CrossOrigin(origins = { "http://localhost:4200" })
	@DeleteMapping("/unity/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			conversionService.deleteById(id);
		} catch (DataAccessException ex) {
			response.put("Message", "Data Error On DB, Error On Delete " + VAR);
			response.put("Error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("Message", VAR + " Succesfully Deleted");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
