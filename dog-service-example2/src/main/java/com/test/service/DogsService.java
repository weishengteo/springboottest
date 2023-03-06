package com.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.exception.DogNotFoundException;
import com.test.model.DogDto;
import com.test.repository.Dog;
import com.test.repository.DogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DogsService {
	
	@Autowired DogRepository repository;
	
	public void add(DogDto dto) {
		repository.save(toEntity(dto));
	}
	
	public void delete(long id) {
		repository.deleteById(id);
	}
	
	public List<Dog> getDogs() {
		return (List<Dog>) repository.findAll();
	}
	
	public Dog getDogById(long id) {
		Optional<Dog> optionalDog = repository.findById(id);
		return optionalDog.orElseThrow(() -> new DogNotFoundException("Couldn't find a Dog with id: " + id));
	}
	
	private Dog toEntity(DogDto dto) {
		Dog entity = new Dog();
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		return entity;
	}
}
