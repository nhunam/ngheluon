package saola.com.ngheluon.dataset;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@Table(name = "users")
public class User extends BaseModel<UUID> {
  private static final long serialVersionUID = 1L;
  private String phone;
  private String username;
  @Column(name = "chargebee_id")
  private String chargebeeId;
  @Column(name = "time_expired")
  private Timestamp timeExpired;
  private String token;
}