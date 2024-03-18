package com.example.SpringMongoProject.Repo;

import com.example.SpringMongoProject.Entity.FileDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FileRepository extends MongoRepository<FileDocument,String> {
    List<FileDocument> findByPatientNIC(String patientNIC);

}
