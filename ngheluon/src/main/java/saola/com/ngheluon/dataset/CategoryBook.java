package saola.com.ngheluon.dataset;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
  private static long serialVersionUID = 1L;
  private String category_id;
  private String book_id;
  
//  @ManyToOne
//  @JoinColumn(name = "category_id")
//  private Category category;
  
}