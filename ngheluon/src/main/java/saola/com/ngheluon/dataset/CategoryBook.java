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
@Entity(name = "category_books")
@Table(name = "category_books")
public class CategoryBook extends BaseModel {
  private static final long serialVersionUID = 1L;
  private long topic_id;
  private long book_id;
}