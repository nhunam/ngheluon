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
@Entity(name = "libraries")
@Table(name = "libraries")
public class Library extends BaseModel<String> {
  private static final long serialVersionUID = 1L;
  private long user_id;
  private long book_id;
  private String status;
  private Integer process;
}