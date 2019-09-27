package saola.com.ngheluon.dataset;

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
public class User extends BaseModel {
  private static final long serialVersionUID = 1L;
  private String phone;
  private String name;
  private String chargebee_id;
  private long time_expired;
  private String sub_id;
  private String token;
}