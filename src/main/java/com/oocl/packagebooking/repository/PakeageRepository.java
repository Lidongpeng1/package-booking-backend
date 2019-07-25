
package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.entity.Pakeage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PakeageRepository extends JpaRepository<Pakeage, String> {

    List<Pakeage> findByState(String state);
}
