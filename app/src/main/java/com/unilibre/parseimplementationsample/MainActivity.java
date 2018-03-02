package com.unilibre.parseimplementationsample;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class MainActivity extends AppCompatActivity {

    private TextView messageTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos las vistas en código
        Button parseButton = findViewById(R.id.parseButton);
        messageTv = findViewById(R.id.meesageTv);

        // Asignamos el listener al botón para detectar cuando se haga click en el
        parseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Hacemos un ParseQuery para obtener el mensaje que se mostrará.
                ParseQuery<ParseObject> query = ParseQuery.getQuery("TestClass");
                query.getFirstInBackground(new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {

                        // Validamos que no ocurrió un error al hacer la query
                        if(e == null)
                        {
                            String message = object.getString("message");
                            if(!message.isEmpty())
                                messageTv.setText(message);
                            else {
                                messageTv.setText("");
                                Toast.makeText(MainActivity.this, "El texto está vacío", Toast.LENGTH_SHORT).show();
                            }

                            showAnimation(messageTv);
                        }
                        else
                        {
                            messageTv.setText("");
                            showErrorDialog();
                        }
                    }
                });
            }
        });

    }

    void showErrorDialog()
    {
        messageTv.setVisibility(View.GONE);
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle("Error al conectarse con Parse");
        builder1.setMessage("Por favor revisa que los datos de la aplicación esten correctos e intenta de nuevo.");
        builder1.setCancelable(true);

        builder1.setNeutralButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    void showAnimation(View view)
    {
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        fadeInAnimation.setFillAfter(true);
        view.startAnimation(fadeInAnimation);
    }
}
