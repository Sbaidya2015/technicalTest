package coding.assignment.domain.sample;

import coding.assignment.domain.CommonAuditBase;
import lombok.Data;


import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Data
@NamedNativeQueries(@NamedNativeQuery(name = "SampleTable.sampleTable",
        query = "select S_SAMPLE_ID from   {h-schema}sample_table  where sample_table.S_SAMPLE_ID= :sampleId"))
@Entity
@Table(name = "sample_table")
@AttributeOverride(name = "id", column = @Column(name = SampleTable.S_SAMPLE_ID))
public class SampleTable extends CommonAuditBase {

    public static final String S_SAMPLE_ID = "S_SAMPLE_ID";
    public static final String S_SAMPLE_TEXT = "S_SAMPLE_TEXT";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = S_SAMPLE_ID, nullable = false)
    private Long id;
    @Column(name = S_SAMPLE_TEXT, nullable = true)
    private String sampleText;


}
