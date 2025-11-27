package com.chandan.userapp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chandan.userapp.R
import com.chandan.userapp.model.User

class UserAdapter(
    private val users: List<User>,
    private val onItemClick: (User) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val container: View = itemView.findViewById(R.id.containerUserRow)
        private val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        private val textViewEmail: TextView = itemView.findViewById(R.id.textViewEmail)
        private val textViewAvatar: TextView = itemView.findViewById(R.id.textViewAvatar)

        fun bind(user: User) {
            textViewName.text = user.name
            textViewEmail.text = user.email
            textViewAvatar.text = user.name.firstOrNull()?.uppercaseChar()?.toString() ?: "?"

            container.setOnClickListener { onItemClick(user) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size
}
