package record.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import record.model.QrRecord;

@Repository
public interface RecordRepository extends JpaRepository<QrRecord, Integer> {
}
