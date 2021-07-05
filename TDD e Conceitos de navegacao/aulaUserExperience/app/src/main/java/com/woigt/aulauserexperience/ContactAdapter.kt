package com.woigt.aulauserexperience

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Responsavel por gerenciar o Recycler View
                                            // V Passar o viewHolder como tipo
class ContactAdapter(var listener: ClickItemContactListener) :
    RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    private val list: MutableList<Contact> = mutableListOf()

    // Responsavel por criar cada item visual da tela
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)  // Dizer quem é o layout
        return ContactAdapterViewHolder(view, list, listener)
    }

    // Quantidade de itens da lista que passamos
    override fun getItemCount(): Int {
        return list.size
    }
    // Metodo publico que acessa o adapter para passar a lista pra dentro
    fun updateList(list: List<Contact>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()  // Notifica o adapter que a lista foi motificada
    }

    // Responsavel por rodar em cada item e preencher ele na tela (popular o item)
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }




    // Responsavel por gerenciar cada item
    class ContactAdapterViewHolder(itemView: View, var list: List<Contact>, var listener: ClickItemContactListener):
        RecyclerView.ViewHolder(itemView) {
        private var tvName: TextView = itemView.findViewById(R.id.tv_name)  // Referencia os itens do Layout
        private var tvPhone: TextView = itemView.findViewById(R.id.tv_phone)
        private var ivPhotograph: ImageView = itemView.findViewById(R.id.iv_photograph)

        init {
            itemView.setOnClickListener{
                listener.clickItemContact(list[adapterPosition])
            }

        }

        // Define o conteudo dos itens
        fun bind(contact: Contact) {
            tvName.text = contact.name
            tvPhone.text = contact.phone


        }
    }

}