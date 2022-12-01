package es.gabrielzafra.tarea21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UserDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        //Extraemos el objeto usuario con los datos de registro del Intent
        User user = (User) getIntent().getSerializableExtra("userData");
        //Actualizamos el contenido del TextView para mostrar el mensaje de confirmación
        //del registro
        ((TextView) findViewById(R.id.showInfo)).setText(formatWelcomeMsg(user));
    }

    /**
     * Dado un usuario utiliza los datos para dar formato a un mensaje de bienvenida
     *
     * @param user con los datos de registro
     * @return mensaje de bienvenida
     */
    private String formatWelcomeMsg(User user) {
        return user.getName() + " " + user.getSurnames() + " "
                + getString(R.string.welcome_msg) + " "
                + (user.isOnline() ? getString(R.string.online) : getString(R.string.presencial))
                + ".\n" + getString(R.string.email) + ": " + user.getEmail()
                + "\n" + getString(R.string.telefono) + ": " + user.getPhone();
    }
}