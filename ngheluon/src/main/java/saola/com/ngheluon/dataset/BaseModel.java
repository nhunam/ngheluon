package saola.com.ngheluon.dataset;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseModel implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;
  private Long created;
  private Long updated;

  @PrePersist
  protected void prePersist() {
    long currentTime = System.currentTimeMillis();
    if (null == this.created) {
      setCreated(currentTime);
    }
    if (null == this.updated) {
      setUpdated(currentTime);
    }
  }

  @PreUpdate
  protected void preUpdate() {
    long currentTime = System.currentTimeMillis();
    setUpdated(currentTime);
  }
}