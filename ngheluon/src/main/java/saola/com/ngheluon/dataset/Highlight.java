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
@Entity(name = "highlights")
@Table(name = "highlights")
public class Highlight extends BaseModel {
  private static final long serialVersionUID = 1L;
  private String title;
  private String description;
  private String thumb;
  private Integer totalBook;
}