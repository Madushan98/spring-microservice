package record.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import record.dtos.RecordRequest;
import record.dtos.RecordResponse;
import record.model.QrRecord;
import record.repository.RecordRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RecordService {

    private final RecordRepository repository;

    public RecordResponse createRecord(RecordRequest request) {
        QrRecord record = QrRecord.builder()
                .userId(request.userId())
                .checkoutTime(LocalDateTime.now())
                .build();
        repository.saveAndFlush(record);

        return new RecordResponse("user Created Successfully");
    }

}
