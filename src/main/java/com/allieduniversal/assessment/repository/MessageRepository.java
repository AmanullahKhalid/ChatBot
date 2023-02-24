package com.allieduniversal.assessment.repository;

import com.allieduniversal.assessment.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("select m from Message m where m.order = :odr and (upper(m.choice) = upper(:choice) or m.choice is NULL)")
    Optional<Message> findByOrderAndChoice(@Param("odr") int order, @Param("choice") @Nullable String choice);

}