package saola.com.ngheluon.dataset;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseModel implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  private String id;
  private Long created;
  private Long updated;
  private Boolean disabled;

  @PrePersist
  protected void prePersist() {
    long currentTime = System.currentTimeMillis();
    if (null == this.id || "".equals(this.id)) {
      this.id = UUID.randomUUID().toString();
    }
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