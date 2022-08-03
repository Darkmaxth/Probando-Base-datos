package firebase.app.operaciones

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val userList: ArrayList<User>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListener = listener


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder{

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
            parent,false)

        return  MyViewHolder(itemView, mListener)


    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int){
        val user : User = userList[position]
        holder.nombre.text = user.Nombre
        holder.dni.text =user.DNI
        holder.enfermedad.text =user.Enfermedad





    }

    override fun getItemCount(): Int {
        return userList.size
    }

    public class MyViewHolder(itemView : View , listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val nombre : TextView = itemView.findViewById(R.id.tvname)
        val dni : TextView = itemView.findViewById(R.id.tvdni)
        val enfermedad : TextView = itemView.findViewById(R.id.tvenfermedad)

        init {
            itemView.setOnClickListener{

                listener.onItemClick(adapterPosition)
            }
        }





    }
}