package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgresql") PersonDao personDao){
        this.personDao = personDao;
    }
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }

    public int deletePersonById(UUID id){
        return personDao.deletePersonById(id);
    }
    public int updatePersonById(UUID id, Person newPerson){
        return personDao.updatePersonById(id, newPerson);
    }
}
