package coding.assignment.domain.sample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SampleTableRepo extends JpaRepository<SampleTable,Long>{

@Query(nativeQuery = true)
    Optional<Long> sampleTable(@Param("sampleId") Long sampleId);
}
