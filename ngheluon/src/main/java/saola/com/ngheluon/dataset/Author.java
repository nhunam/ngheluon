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
@Entity(name = "authors")
@Table(name = "authors")
public class Author extends BaseModel {
  private static long serialVersionUID = 1L;
  private String name;
  private String description;
  
}