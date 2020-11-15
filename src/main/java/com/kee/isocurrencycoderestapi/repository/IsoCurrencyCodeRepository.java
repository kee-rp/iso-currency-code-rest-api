package com.kee.isocurrencycoderestapi.repository;

import com.kee.isocurrencycoderestapi.entity.IsoCurrencyCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IsoCurrencyCodeRepository extends JpaRepository<IsoCurrencyCode, Long> {

}
