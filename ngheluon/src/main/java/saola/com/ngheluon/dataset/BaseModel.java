package saola.com.ngheluon.dataset;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import lombok.Data;

@Data
@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class BaseModel<T> implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(generator = "UUID")
  // @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Generated(GenerationTime.INSERT)
  private T id;
  @Column(name = "created_at")
  private Timestamp createdAt;
  @Column(name = "updated_at")
  private Timestamp updatedAt;
  //private Boolean active = true;

  @PrePersist
  protected void prePersist() {
    long currentTime = System.currentTimeMillis();
    Timestamp curr = new Timestamp(currentTime);
    if (null == this.createdAt) {
      setCreatedAt(curr);
    }
    if (null == this.updatedAt) {
      setUpdatedAt(curr);
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