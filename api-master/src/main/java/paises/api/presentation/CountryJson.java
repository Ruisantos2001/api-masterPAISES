package paises.api.presentation;
import lombok.Data;

@Data
public class CountryJson
{
    private Long id;
    private String name;
    private String capital;
    private String region;
    private String subregion;
    private String area;
}
