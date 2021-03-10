package com.zet.superchat.ui.fragments.chatsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zet.superchat.databinding.FragmentMainChatListBinding
import com.zet.superchat.ui.adapters.ChatsAdapter
import com.zet.superchat.utils.BounceEdgeEffectFactory
import com.zet.superchat.utils.ViewBindingHolder
import com.zet.superchat.utils.ViewBindingHolderImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatListFragment : Fragment(),
    ViewBindingHolder<FragmentMainChatListBinding> by ViewBindingHolderImpl() {

    private val viewModel by viewModels<ChatListViewModel>()
    private val chatsAdapter by lazy { ChatsAdapter().also { it.differ.submitList(generateListInt()) } }

    private fun generateListInt(): List<Int> {
        val list = mutableListOf<Int>()
        for (i in 0 .. 20) {
            list.add(i)
        }
        return list
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = initBinding(
        FragmentMainChatListBinding.inflate(layoutInflater, container, false),
        this@ChatListFragment
    ) {  }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initChatsAdapter()
    }

    private fun initChatsAdapter() = requireBinding().rvChats.apply {
        layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        adapter = chatsAdapter
        edgeEffectFactory = BounceEdgeEffectFactory()
    }
}