package app.gkuroda.nptrialapplication.ui.fragment.poker

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.gkuroda.nptrialapplication.databinding.ViewHrBinding
import app.gkuroda.nptrialapplication.databinding.ViewPokerItemCellBinding

class PokerHandRequestRecyclerViewAdapter(
    context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var orderSize: Int = 1

    var itemList: List<Pair<PokerHandViewType, Int>> = emptyList()

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (PokerHandViewType.typeToViewType(viewType)) {
            PokerHandViewType.ITEM_CELL -> PokerItemViewHolder(
                ViewPokerItemCellBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            PokerHandViewType.HR_CELL -> HrItemViewHolder(
                ViewHrBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].first.type
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PokerItemViewHolder -> {
                holder.bind(itemList[position].second)
            }
            is HrItemViewHolder -> holder.bind()
        }
    }

    override fun getItemCount(): Int = itemList.size

    fun setPokerItemList() {
        val baseList = mutableListOf<Pair<PokerHandViewType, Int>>()
        for (i in 1..orderSize) {
            for (count in 1..5) {
                baseList.add(Pair(PokerHandViewType.ITEM_CELL, count))
            }
            baseList.add(Pair(PokerHandViewType.HR_CELL, 0))
        }
        itemList = baseList
    }

    enum class PokerHandViewType(val type: Int) {
        ITEM_CELL(1),
        HR_CELL(2);

        companion object {
            fun typeToViewType(type: Int): PokerHandViewType {
                return values().first { it.type == type }
            }
        }
    }

    class PokerItemViewHolder(
        val binding: ViewPokerItemCellBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cardNumber: Int) {
            binding.apply {
                itemNumber = cardNumber
                itemNumberText = "値$cardNumber"
            }
        }

        fun getCardValue(): Pair<Int, String> {
            return Pair(binding.itemNumber, binding.pokerCardValueEditText.text.toString())
        }
    }

    class HrItemViewHolder(
        val binding: ViewHrBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {

        }
    }
}