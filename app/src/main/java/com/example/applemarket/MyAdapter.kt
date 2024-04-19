package com.example.applemarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ItemLayoutBinding
import java.text.DecimalFormat

class MyAdapter(private val onClick: (Item) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var itemList = listOf<Item>()

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = itemList[position]
        val myholder = holder as Holder
        myholder.bind(currentItem)
        holder.itemView.setOnClickListener {
            onClick(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    //더보기
    fun setViewMore(contentTextView: TextView, viewMoreTextView: TextView) {
        contentTextView.post {
            val lineCount = contentTextView.layout.lineCount
            if (lineCount > 0) {
                if (contentTextView.layout.getEllipsisCount(lineCount - 1) > 0) {
                    viewMoreTextView.visibility = View.VISIBLE
                    viewMoreTextView.setOnClickListener {
                        contentTextView.maxLines = Int.MAX_VALUE
                        viewMoreTextView.visibility = View.GONE
                    }
                }
            }
        }
    }
    inner class Holder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val dec = DecimalFormat("#,###")
        fun bind(item: Item) {
            binding.apply {
                binding.ivItem.setImageResource(item.image)
                binding.title.text = item.title
                binding.place.text = item.place
                binding.chatN.text = item.chatN.toString()
                binding.goodN.text = item.goodN.toString()
                binding.price.text = dec.format(item.price).toString()

            }
        }
    }
}