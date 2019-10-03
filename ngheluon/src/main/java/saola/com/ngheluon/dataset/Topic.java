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
@Entity(name = "topics")
@Table(name = "topics")
public class Topic extends BaseModel<String> {
  private static final long serialVersionUID = 1L;
  private String title;
  private String slug;
  private String description;
}

