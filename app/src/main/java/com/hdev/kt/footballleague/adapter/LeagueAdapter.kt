package com.hdev.kt.footballleague.adapter

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.hdev.kt.footballleague.R
import com.hdev.kt.footballleague.model.League
import com.hdev.kt.footballleague.ui.ItemUI
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class LeagueAdapter(private var leagueList: List<League>, private val listener: (League) -> Unit) :
    RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) =
        ViewHolder(ItemUI().createView(AnkoContext.Companion.create(parent.context, parent)))

    override fun getItemCount() = leagueList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(leagueList[position], listener)
    }

    //
    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        private val itemLinearLayout = itemView.findViewById<LinearLayout>(ItemUI.linear_layout)
        private val itemLogo = itemView.findViewById<ImageView>(ItemUI.league_logo)
        private val itemName = itemView.findViewById<TextView>(ItemUI.league_name)

        fun bind(league: League, listener: (League) -> Unit) {
            league.logo.let {
                Picasso.get().load(Uri.parse(it))
                    .placeholder(R.drawable.ic_broken_image)
                    .error(R.drawable.ic_broken_image)
                    .into(itemLogo)
            }
            itemName.text = league.name
            itemLinearLayout.setOnClickListener {
                listener(league)
            }
        }
    }
}