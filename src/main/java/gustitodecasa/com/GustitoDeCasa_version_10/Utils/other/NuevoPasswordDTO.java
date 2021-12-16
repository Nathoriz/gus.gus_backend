package gustitodecasa.com.GustitoDeCasa_version_10.Utils.other;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NuevoPasswordDTO {
    private Long id;
    private String password;
    private String confirmpassword;
}
