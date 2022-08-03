package firebase.app.operaciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_agregar.*

class AgregarActivity : AppCompatActivity() {
    var db= FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar)

    buttonGuardar.setOnClickListener {
        val nNombre = textNombre.text.toString()
        val nDNI = textDNI.text.toString()
        val nEnfermedad = textEnfermedad.text.toString()
        guardarDatos(nNombre,nDNI,nEnfermedad)
    }


    }


    private fun guardarDatos(nNombre: String, nDNI: String, nEnfermedad: String) {



        var datosinsertar = hashMapOf(
            "Nombre" to nNombre,
            "DNI"   to nDNI,
            "Enfermedad" to nEnfermedad
        )

        db.collection("Pacientes").document().set(datosinsertar)
            .addOnSuccessListener {
                Toast.makeText(this,"Se agrego correctamente", Toast.LENGTH_LONG).show()
                textNombre.setText("")
                textDNI.setText("")
                textEnfermedad.setText("")
            }

    }
}