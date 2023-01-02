package com.capgemini.eshoppingzone.walletservice.WalletService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.eshoppingzone.walletservice.WalletService.models.Ewallet;

@Repository
public interface EwalletRepository extends MongoRepository<Ewallet, Integer>
{
   public Ewallet findByProfileId(int profileId);
}
