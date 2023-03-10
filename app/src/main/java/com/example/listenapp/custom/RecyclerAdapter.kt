package com.example.listenapp.custom

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.listenapp.custom.adapter.ItemViewBuilder
import com.example.listenapp.custom.adapter.RecyclerViewHolder



abstract class RecyclerAdapter<Type : RecyclerView.ViewHolder>(var collection: Collection<*>) :
        RecyclerView.Adapter<Type>() {

    abstract var onTarget: () -> Unit

    abstract fun getTarget(): Int
}

inline fun <reified Builder : ItemViewBuilder<*, *>> recyclerAdapter(collection: Collection<*>) =
        object : RecyclerAdapter<RecyclerViewHolder>(collection) {

            override var onTarget: () -> Unit = {}

            override fun getTarget() = collection.size - 10

            override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
                    Builder::class.java.newInstance().run {
                        init(viewGroup, collection)
                        RecyclerViewHolder(this)
                    }

            override fun getItemCount() = collection.size

            override fun onBindViewHolder(viewHolder: RecyclerViewHolder, position: Int) {
                if (position == getTarget()) {
                    onTarget()
                }
                viewHolder.builder.onBind(position)
            }
        }