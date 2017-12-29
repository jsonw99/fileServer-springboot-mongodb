package com.jw.mongodbfileserver.repository;

import com.jw.mongodbfileserver.domain.File;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * the file repository
 */
public interface FileRepository extends MongoRepository<File, String>{
}
