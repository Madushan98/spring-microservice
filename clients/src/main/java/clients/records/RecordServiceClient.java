package clients.records;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
    value = "Record",
    path = "api/v1/record"   )
public interface RecordServiceClient {

}
