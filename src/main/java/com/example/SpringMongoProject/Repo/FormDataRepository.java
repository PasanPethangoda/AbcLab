package com.example.SpringMongoProject.Repo;

import com.example.SpringMongoProject.Entity.FormData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FormDataRepository extends MongoRepository<FormData,String> {
    List<FormData> findByPatientNIC(String patientNIC);

}
