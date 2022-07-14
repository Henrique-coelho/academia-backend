package basePackage.models.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
public class MedidasDTO {
    private double peso;

    private double altura;
}
