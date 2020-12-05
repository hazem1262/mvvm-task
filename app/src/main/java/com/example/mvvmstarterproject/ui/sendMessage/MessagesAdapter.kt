package com.example.mvvmstarterproject.ui.sendMessage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmstarterproject.R
import com.example.mvvmstarterproject.data.Message
import kotlinx.android.synthetic.main.message_row_item.view.*

class MessagesAdapter: ListAdapter<Message, RecyclerView.ViewHolder>(diffCallBack) {
    companion object {
        val diffCallBack = object : DiffUtil.ItemCallback<Message>() {
            override fun areItemsTheSame(
                oldItem: Message,
                newItem: Message
            ): Boolean = newItem == oldItem

            override fun areContentsTheSame(
                oldItem: Message,
                newItem: Message
            ): Boolean = oldItem.id == newItem.id && oldItem.isSelected == newItem.isSelected

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.message_row_item, parent, false)

        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MessageViewHolder).bind(currentList[position])
    }

    override fun submitList(list: List<Message>?) {
        super.submitList(list?.let { ArrayList(it) })
    }

    inner class MessageViewHolder(private var view: View):
        RecyclerView.ViewHolder(view){
        fun bind(item:Message){
            view.messageHeader.text = item.header
            view.messageSubHeader.text = item.subHeader
            view.messagePrice.text = "Message Id: ${item.id}"
            view.message_radio_button.isChecked = item.isSelected
            view.message_radio_button.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked){
                    item.isSelected = true
                    currentList.forEach {
                        if (it?.id != item.id){
                            it.isSelected = false
                            notifyItemChanged(currentList.indexOf(it))
                        }
                    }
                    view.post {
                        submitList(currentList)
                    }
                }
            }
        }
    }
}