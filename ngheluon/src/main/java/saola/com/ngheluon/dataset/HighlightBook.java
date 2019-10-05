package saola.com.ngheluon.dataset;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "highlight_books")
@Table(name = "highlight_books")
public class HighlightBook extends BaseModel<Integer> {
  private static final long serialVersionUID = 1L;
  private UUID highlight_id;
  private UUID book_id;
}