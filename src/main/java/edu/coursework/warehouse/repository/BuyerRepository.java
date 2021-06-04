package edu.coursework.warehouse.repository;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    PersonRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.warehouse.model.Buyer;
import edu.coursework.warehouse.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends MongoRepository<Buyer, String> {

}
