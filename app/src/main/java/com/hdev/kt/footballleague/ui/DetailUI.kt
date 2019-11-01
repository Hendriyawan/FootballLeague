package com.hdev.kt.footballleague.ui

import android.graphics.Color
import android.net.Uri
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.hdev.kt.footballleague.R
import com.hdev.kt.footballleague.activity.DetailLeagueActivity
import com.hdev.kt.footballleague.model.League
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.support.v4.nestedScrollView

class DetailUI(private val league: League) : AnkoComponent<DetailLeagueActivity> {

    override fun createView(ui: AnkoContext<DetailLeagueActivity>) = with(ui) {
        //NestedScrollView
        nestedScrollView {
            //CardView
            cardView {
                cardElevation = dip(2).toFloat()
                radius = dip(4).toFloat()
                layoutParams = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                ).apply { margin = dip(16) }

                //LinearLayout
                verticalLayout {
                    orientation = LinearLayout.VERTICAL
                    backgroundResource = attr(R.attr.selectableItemBackground).resourceId
                    isClickable = true

                    //ImageView league logo
                    imageView {
                        Picasso.get()
                            .load(Uri.parse(league.logo))
                            .placeholder(resources.getDrawable(R.drawable.ic_broken_image))
                            .error(resources.getDrawable(R.drawable.ic_broken_image))
                            .into(this)
                    }.lparams(matchParent, matchParent) { gravity = Gravity.CENTER_HORIZONTAL }

                    //TextView league name
                    textView {
                        gravity = Gravity.CENTER
                        textSize = sp(12).toFloat()
                        textColor = Color.BLACK
                        text = league.name

                    }.lparams(wrapContent, wrapContent) {
                        gravity = Gravity.CENTER_HORIZONTAL
                        margin = dip(8)
                    }

                    //TextView league description
                    textView {
                        text = league.description
                        padding = 5
                        gravity = Gravity.CENTER_HORIZONTAL
                    }.lparams(wrapContent, wrapContent)
                }
            }
        }
    }
}
