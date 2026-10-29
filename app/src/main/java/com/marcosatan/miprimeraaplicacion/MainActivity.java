package com.marcosatan.miprimeraaplicacion;

import android.os.Bundle; // Importa la clase Bundle para guardar estados
import android.util.Log; // Importa Log para mostrar mensajes en la consola (Logcat)
import android.widget.Button; // Importa el componente Botón
import android.widget.EditText; // Importa el componente de entrada de texto
import android.widget.TextView; // Importa el componente de texto visible
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity; // Importa la actividad base de Android
// Importa Toast para mensajes emergentes cortos

public class MainActivity extends AppCompatActivity { // Clase principal que hereda de AppCompatActivity

    private EditText edtNum1; // Declara variable para el primer campo de texto
    private EditText edtNum2; // Declara variable para el segundo campo de texto
    private Button btnSumar; // Declara variable para el botón de acción
    private TextView txtResultado; // Declara variable para mostrar el resultado

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Método que se ejecuta al iniciar la app
        super.onCreate(savedInstanceState); // Llama al constructor de la clase padre
        setContentView(R.layout.activity_main); // Asigna el diseño XML a esta actividad

        edtNum1 = findViewById(R.id.edtNum1); // Conecta la variable Java con el ID del XML
        edtNum2 = findViewById(R.id.edtNum2); // Conecta la variable Java con el ID del XML
        btnSumar = findViewById(R.id.btnSumar); // Conecta la variable Java con el ID del XML
        txtResultado = findViewById(R.id.txtResultado); // Conecta la variable Java con el ID del XML

        btnSumar.setOnClickListener(v -> { // Registra el evento click en el botón
            Log.d("APP", "sumar() inicio"); // Muestra mensaje en Logcat indicando inicio

            String s1 = edtNum1.getText().toString().trim(); // Obtiene texto del primer campo y quita espacios
            String s2 = edtNum2.getText().toString().trim(); // Obtiene texto del segundo campo y quita espacios

            if (s1.isEmpty()) { // Valida si el primer campo está vacío
                edtNum1.setError(getString(R.string.msg_error_vacio)); // Muestra error visual en el campo
                return; // Detiene la ejecución si hay error
            }

            if (s2.isEmpty()) { // Valida si el segundo campo está vacío
                edtNum2.setError(getString(R.string.msg_error_vacio)); // Muestra error visual en el campo
                return; // Detiene la ejecución si hay error
            }

            try { // Inicia bloque de prueba para manejar errores de conversión
                int n1 = Integer.parseInt(s1); // Convierte texto a número entero (primer valor)
                Log.d("APP", "n1= " + n1); // Muestra el primer número en Logcat

                int n2 = Integer.parseInt(s2); // Convierte texto a número entero (segundo valor)
                Log.d("APP", "n2= " + n2); // Muestra el segundo número en Logcat

                int suma = n1 + n2; // Realiza la operación matemática de suma
                Log.d("APP", "resultado= " + suma); // Muestra el resultado en Logcat

                txtResultado.setText("Resultado: " + suma); // Muestra el resultado en el TextView
                Toast.makeText(this, getString(R.string.msg_exito), Toast.LENGTH_SHORT).show(); // Muestra mensaje emergente de éxito

            } catch (NumberFormatException e) { // Captura error si el usuario escribe letras
                Toast.makeText(this, getString(R.string.msg_error_numero), Toast.LENGTH_LONG).show(); // Avisa al usuario del error
            }
        });
    }
}