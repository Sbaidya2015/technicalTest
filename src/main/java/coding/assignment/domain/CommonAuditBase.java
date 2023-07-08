package coding.assignment.domain;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class CommonAuditBase{

    @CreatedDate @Column(name = "d_created") private LocalDateTime createdDate;

    @CreatedBy @Column(name = "t_createdby", length = 50) private String createdBy;

    @LastModifiedDate @Column(name = "d_updated") private LocalDateTime lastUpdatedDate;

    @LastModifiedBy @Column(name = "t_updatedby", length = 50) private String lastUpdatedBy;


}

