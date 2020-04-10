package sys.auth.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties
        (value = {"createdAt","updatedAt"},allowGetters = true)

public abstract class Audit implements Serializable {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreatedOn", nullable = false, updatable = false)
    @CreatedDate
    private Date createdOn;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ModifiedOn", nullable = false)
    @LastModifiedDate
    private Date updatedOn;
    public Date getCreatedOn() {
        return createdOn;
    }
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }


}
