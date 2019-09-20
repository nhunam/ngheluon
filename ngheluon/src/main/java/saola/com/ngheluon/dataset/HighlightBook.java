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
@Entity(name = "highlight_books")
@Table(name = "highlight_books")
public class HighlightBook extends BaseModel {
  private static final long serialVersionUID = 1L;
  /* TODO */
  private long highlight_id;
  private long book_id;
}