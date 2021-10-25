package gustitodecasa.com.GustitoDeCasa_version_10.custom;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {

    //Codificación
    @Override
    public String encode( CharSequence plainTextPassword ) {
        return BCrypt.hashpw( plainTextPassword.toString(),BCrypt.gensalt(8) );
    }

    //Coincidencias
    @Override
    public boolean matches( CharSequence plainTextPassword, String passwordInDatabase ) {
        return BCrypt.checkpw( plainTextPassword.toString(), passwordInDatabase );
    }
}
