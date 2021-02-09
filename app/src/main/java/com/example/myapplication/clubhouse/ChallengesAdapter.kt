package com.example.myapplication.clubhouse

import com.example.myapplication.models.Challenge
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.utils.Variables
import kotlinx.android.synthetic.main.challenges_info_qreq.view.*


class ChallengesAdapter (
    var Challenges: MutableList<Challenge>,
    val listener: OnItemClickListener
) : RecyclerView.Adapter<ChallengesAdapter.ChallengesViewHolder>() {

    inner class ChallengesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init{
            itemView.btnReject.setOnClickListener{
                val position: Int = adapterPosition
                if (position != RecyclerView.NO_POSITION){
                    listener.onReject(position)
                }
            }
            itemView.btnAccept.setOnClickListener{
                val position: Int = adapterPosition
                if (position != RecyclerView.NO_POSITION){
                    listener.onAccept(position)
                }
            }
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.challenges_info_qreq, parent, false)
        return ChallengesViewHolder(view)
    }
    override fun getItemCount(): Int {
        return Challenges.size
    }
    override fun onBindViewHolder(holder: ChallengesViewHolder, position: Int) {
        holder.itemView.apply {
            if (Challenges[position].to==Variables.id) {
                tvName.text = Challenges[position].fromName
            }
            else{
                tvName.text = Challenges[position].toName
            }
            tvCourt.text = Challenges[position].court
            tvDay.text = Challenges[position].date
            tvHour.text = Challenges[position].hour
        }
    }
    interface OnItemClickListener{
        fun onAccept(position: Int)
        fun onReject(position: Int)
    }
}