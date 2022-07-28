package record.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import record.dtos.RecordRequest;
import record.dtos.RecordResponse;
import record.service.RecordService;


@Slf4j
@RestController
@RequestMapping("api/v1/record")
public class RecordController {

    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }


    @PostMapping
    public RecordResponse qrRecord(@RequestBody RecordRequest recordRequest) {
        log.info("new Record Created {}", recordRequest);

        return   recordService.createRecord(recordRequest);
    }


}
