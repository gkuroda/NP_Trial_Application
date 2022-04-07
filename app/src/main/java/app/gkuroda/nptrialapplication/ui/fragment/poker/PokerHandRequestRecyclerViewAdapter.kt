package app.gkuroda.nptrialapplication.ui.fragment.poker

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.gkuroda.nptrialapplication.databinding.ViewHrBinding
import app.gkuroda.nptrialapplication.databinding.ViewPokerItemCellBinding
import app.gkuroda.nptrialapplication.model.PokerCardSetItem

class PokerHandRequestRecyclerViewAdapter(
    context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), PokerItemEvent {
    var orderSize: Int = 1

    var itemList: List<Triple<PokerHandViewType, Int, Int>> = emptyList()
    var orderList: MutableList<PokerCardSetItem> = mutableListOf()

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
                val item = itemList[position]
                holder.bind(item.second, item.third, this)
            }
            is HrItemViewHolder -> holder.bind()
        }
    }

    override fun getItemCount(): Int = itemList.size

    fun setPokerItemList() {
        val baseList = mutableListOf<Triple<PokerHandViewType, Int, Int>>()

        for (count in 1..5) {
            baseList.add(Triple(PokerHandViewType.ITEM_CELL, count, orderSize))
        }
        baseList.add(Triple(PokerHandViewType.HR_CELL, 0, orderSize))

        orderList.add(PokerCardSetItem(orderSize))

        itemList = baseList
    }

    fun addOrder() {
        orderSize++
        setPokerItemList()
    }

    override fun onTextChange(orderNumber: Int, cardNumber: Int, cardValue: CharSequence) {
        orderList = orderList.map {
            if (it.orderNumber == orderNumber) {
                it.setCard(cardNumber, cardValue.toString())
            } else {
                it
            }
        }.toMutableList()
        orderList
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
        fun bind(cardNumber: Int, orderNumber: Int, pokerItemEvent: PokerItemEvent) {
            binding.apply {
                itemNumber = cardNumber
                itemNumberText = "値$cardNumber"
                itemOrderNumber = orderNumber
                event = pokerItemEvent
            }
        }

    }

    class HrItemViewHolder(
        val binding: ViewHrBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {

        }
    }
}