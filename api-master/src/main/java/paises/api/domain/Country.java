package paises.api.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import paises.api.service.CountryServiceImpl;

//JPA representação do obj Pais como tabela na bd

@Table(name="paises")
@Entity(name="Pais")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of="id")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Country
{
     @Id @GeneratedValue (strategy=GenerationType.IDENTITY)
     private Long id;
     private String name;
     private String capital;
     private String region;
     private String subregion;
     private String area;
}