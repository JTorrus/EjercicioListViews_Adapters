package com.example.alumne.listviews_adapters_jtorrus.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.alumne.listviews_adapters_jtorrus.model.ItemModel
import kotlinx.android.synthetic.main.list_item.view.*

/**
 * Created by Alumne on 08/11/2017.
 */

class CustomAdapter (activity: Activity, val data: List<ItemModel>, private val item_layout: Int): BaseAdapter() {
    private var inflater: LayoutInflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = p1

        if (p1 == null) {
            view = inflater.inflate(item_layout, null)
        }

        p1?.image_of_item?.setImageResource(data[p0].image)
        p1?.name_of_item?.text = data[p0].name
        p1?.stock_of_item?.text = data[p0].stock.toString()

        return p1!!
    }

    override fun getItem(p0: Int): Any {
        return data.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }

}