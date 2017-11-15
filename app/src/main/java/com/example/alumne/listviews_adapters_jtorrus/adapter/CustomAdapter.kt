package com.example.alumne.listviews_adapters_jtorrus.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.alumne.listviews_adapters_jtorrus.model.ItemModel
import kotlinx.android.synthetic.main.list_item.view.*

class CustomAdapter (activity: Activity, val data: List<ItemModel>, val item_layout: Int): BaseAdapter() {
    private var inflater: LayoutInflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView

        if (view == null) {
            view = inflater.inflate(item_layout, null)
        }

        view?.image_of_item?.setImageResource(data[position].image)
        view?.name_of_item?.text = data[position].name
        view?.stock_of_item?.text = data[position].stock.toString()

        return view!!
    }

    override fun getItem(position: Int): Any {
        return data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }

}