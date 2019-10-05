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
@Entity(name = "category_books")
@Table(name = "category_books")
public class CategoryBook extends BaseModel<Integer> {
  private static final long serialVersionUID = 1L;
  private UUID category_id;
  private UUID book_id;
  
//  @ManyToOne
//  @JoinColumn(name = "category_id")
//  private Category category;
  
}