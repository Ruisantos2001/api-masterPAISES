package paises.api.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.io.*;
@AllArgsConstructor
@Getter
@Setter
public class CreateCountryCommand {
    private String name;
    private String capital;
    private String region;
    private String subregion;
    private String area;

}
