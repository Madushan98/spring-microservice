package clients.records;

import clients.records.dtos.RecordRequest;
import clients.records.dtos.RecordResponse;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("RECORD-SERVICE")
public interface RecordClient {

    @PostMapping(path = "api/v1/record")
    @LoadBalanced
    RecordResponse createRecord(RecordRequest request);

}
