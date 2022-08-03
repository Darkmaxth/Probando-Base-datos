package firebase.app.operaciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.activity_agregar.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.list_item.*
import java.util.jar.Attributes

class VerActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var userArrayList : ArrayList<User>
    private lateinit var myAdapter : MyAdapter
    private lateinit var db : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        userArrayList = arrayListOf()

        myAdapter = MyAdapter(userArrayList)

        recyclerView.adapter = myAdapter

        EventChangeListener()



    }

    private fun EventChangeListener(){


        db = FirebaseFirestore.getInstance()
        db.collection("Pacientes").

                addSnapshotListener(object : EventListener<QuerySnapshot>{

                    override fun onEvent(
                        value: QuerySnapshot?,
                        error: FirebaseFirestoreException?
                    ) {
                        if(error != null){

                            Log.e("Firestore Error", error.message.toString())
                            return
                        }

                        for(dc : DocumentChange in value?.documentChanges!!){

                            if(dc.type == DocumentChange.Type.ADDED){

                                userArrayList.add(dc.document.toObject(User::class.java))
                            }


                        }

                        myAdapter.notifyDataSetChanged()
                    }



                })



//la parte de hacer click
        myAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{

            override fun onItemClick(position: Int) {


                //Toast.makeText(this@VerActivity, "You clicked on item no ${position} ",Toast.LENGTH_LONG).show()

                val intent = Intent(this@VerActivity , NewsActivity::class.java)
                intent.putExtra("nombre",userArrayList[position].Nombre)
                intent.putExtra("dni",userArrayList[position].DNI)
                intent.putExtra("enfermedad",userArrayList[position].Enfermedad)
                startActivity(intent)





            }




        })
    }
}