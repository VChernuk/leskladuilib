class DeliveryNotesAdapter(
    private val deliveryNotes: List<DeliveryNote>,
    private val onItemClick: (DeliveryNote) -> Unit
) : RecyclerView.Adapter<DeliveryNotesAdapter.DeliveryNoteViewHolder>() {

    inner class DeliveryNoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val numberTextView: TextView = itemView.findViewById(R.id.tvDeliveryNoteNumber)
        private val dateTextView: TextView = itemView.findViewById(R.id.tvDeliveryNoteDate)
        private val departmentTextView: TextView = itemView.findViewById(R.id.tvDeliveryNoteDepartment)
        private val signatoryTextView: TextView = itemView.findViewById(R.id.tvDeliveryNoteSignatory)

        fun bind(deliveryNote: DeliveryNote) {
            numberTextView.text = deliveryNote.number
            dateTextView.text = deliveryNote.date
            departmentTextView.text = deliveryNote.department
            signatoryTextView.text = deliveryNote.signatory
            itemView.setOnClickListener { onItemClick(deliveryNote) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryNoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_delivery_note_item, parent, false)
        return DeliveryNoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeliveryNoteViewHolder, position: Int) {
        holder.bind(deliveryNotes[position])
    }

    override fun getItemCount(): Int = deliveryNotes.size
}
