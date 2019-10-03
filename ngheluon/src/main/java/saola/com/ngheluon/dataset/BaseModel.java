package saola.com.ngheluon.dataset;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class BaseModel<T> implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  private T id;
  @Column(name = "created_at")
  private Timestamp createdAt;
  @Column(name = "updated_at")
  private Timestamp updatedAt;
  private Boolean active;

  @PrePersist
  protected void prePersist() {
    long currentTime = System.currentTimeMillis();
    Timestamp curr = new Timestamp(currentTime);
    if (id instanceof String && (null == this.id || "".equals(this.id))) {
      this.id = (T) UUID.randomUUID().toString();
    }
    if (null == this.createdAt) {
      setCreatedAt(curr);
    }
    if (null == this.updatedAt) {
      setUpdatedAt(curr);
    }
    if (null == this.active) {
      setActive(true);
    }
  }

  @PreUpdate
  protected void preUpdate() {
    long currentTime = System.currentTimeMillis();
    Timestamp curr = new Timestamp(currentTime);
    if (null == this.createdAt) {
      setCreatedAt(curr);
    }
    setUpdatedAt(curr);
  }
}