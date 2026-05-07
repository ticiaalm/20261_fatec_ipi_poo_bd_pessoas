import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Builder
@Getter
@Setter
@ToString

public class Pessoa {
    private int codigo;
    private String nome;
    private String fone;
    private String email;
}