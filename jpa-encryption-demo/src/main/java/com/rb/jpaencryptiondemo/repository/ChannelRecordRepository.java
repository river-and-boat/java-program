package com.rb.jpaencryptiondemo.repository;

import com.rb.jpaencryptiondemo.entity.ChannelRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRecordRepository extends JpaRepository<ChannelRecord, String> {
}
