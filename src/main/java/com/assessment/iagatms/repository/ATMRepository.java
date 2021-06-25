package com.assessment.iagatms.repository;

import com.assessment.iagatms.dto.ATM;
import com.mongodb.client.result.UpdateResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class ATMRepository {
    @Autowired
    private  MongoTemplate mongoTemplate;

    public ATM save(ATM atm) {
       return mongoTemplate.save(atm);
    }

    public ATM upsert(ATM atm) {
        final UpdateResult updateResult = update(atm);
        if(updateResult.getMatchedCount() > 0) {
            return atm;
        }
        return save(atm);
    }

    public UpdateResult update(ATM atm) {
        Query query = new Query();
        query.addCriteria(Criteria.where("address").is(atm.getAddress()));
        Update update = new Update();
        update.set("address", atm.getAddress());
        update.set("distance", atm.getDistance());
        update.set("openingHours", atm.getOpeningHours());
        update.set("functionality", atm.getFunctionality());
        update.set("type", atm.getType());
        return mongoTemplate.upsert(query, update, ATM.class);

    }

    public List<ATM> findAll() {
        return mongoTemplate.findAll(ATM.class);
    }
}
