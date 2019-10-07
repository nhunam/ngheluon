package saola.com.ngheluon.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO<T> {
  @Builder.Default
  private Integer status = 200;
  @Builder.Default
  private String message = "Success!";
  private T body;
}