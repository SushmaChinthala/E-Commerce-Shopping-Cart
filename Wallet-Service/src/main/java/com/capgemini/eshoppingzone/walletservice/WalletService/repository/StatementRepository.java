package com.capgemini.eshoppingzone.walletservice.WalletService.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.eshoppingzone.walletservice.WalletService.models.Statement;

@Repository
public interface StatementRepository  extends MongoRepository<Statement,Integer>
{
List<Statement> findByStatementId(int profileId);


}
