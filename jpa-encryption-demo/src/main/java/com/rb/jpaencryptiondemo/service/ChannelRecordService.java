package com.rb.jpaencryptiondemo.service;

import com.rb.jpaencryptiondemo.entity.ChannelRecord;
import com.rb.jpaencryptiondemo.repository.ChannelRecordRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChannelRecordService {
    private final ChannelRecordRepository channelRecordRepository;

    public List<ChannelRecord> getRecords() {
        return channelRecordRepository.findAll();
    }

    public void saveRecord(String requestParam) {
        channelRecordRepository.save(
                new ChannelRecord(UUID.randomUUID().toString(), requestParam)
        );
    }
}
