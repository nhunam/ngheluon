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
@Entity(name = "authors")
@Table(name = "authors")
public class Author extends BaseModel<UUID> {
  private static final long serialVersionUID = 1L;
  private String name;
  private String description;
  private Boolean active = true;
}