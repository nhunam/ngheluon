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
@Entity(name = "chapters")
@Table(name = "chapters")
public class Chapter extends BaseModel {
  private static final long serialVersionUID = 1L;
  private String synopsis;
  private String content;
  private String file;
  private String order;
  private long book_id;
}