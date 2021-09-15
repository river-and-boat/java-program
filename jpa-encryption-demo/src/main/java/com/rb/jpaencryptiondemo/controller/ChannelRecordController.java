package com.rb.jpaencryptiondemo.controller;

import com.rb.jpaencryptiondemo.entity.ChannelRecord;
import com.rb.jpaencryptiondemo.service.ChannelRecordService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ChannelRecordController {
    private final ChannelRecordService channelRecordService;

    @GetMapping("records")
    public List<ChannelRecord> getChannelRecords() {
        return channelRecordService.getRecords();
    }

    @PostMapping("records/{param}")
    public void saveChannelRecord(@PathVariable final String param) {
        channelRecordService.saveRecord(param);
    }
}
