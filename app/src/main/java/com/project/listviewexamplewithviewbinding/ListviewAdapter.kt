package com.project.listviewexamplewithviewbinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.project.listviewexamplewithviewbinding.databinding.BoardListBinding
import com.project.myapplication.clear
import com.project.myapplication.load

class ListviewAdapter(
    private val items: List<Model>
) : BaseAdapter() {

    override fun getCount(): Int = items.size
    override fun getItem(position: Int): Any = items[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding = if (convertView == null) {
            val tempBinding = BoardListBinding.inflate(LayoutInflater.from(parent?.context))
            tempBinding.root.tag = tempBinding
            tempBinding

        } else {
            convertView.tag

        } as BoardListBinding

        bind(binding, items[position])

        return binding.root
    }

    private fun bind(binding: BoardListBinding, data: Model) = with(binding) {
        thumbnail.clear()
        titleText.text = data.title
        contentText.text = data.content
        thumbnail.load(data.imageurl, 16f)
    }
}