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
@Entity(name = "categories")
@Table(name = "categories")
public class Category extends BaseModel<UUID> {
  private static final long serialVersionUID = 1L;
  private String title;
  private String description;
  private String icon;
  private String slug;
  private String thumb;
  private Boolean active;
}