package paises.api.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModifiyCountryCommand {
    private String capital;
    private String area;

}