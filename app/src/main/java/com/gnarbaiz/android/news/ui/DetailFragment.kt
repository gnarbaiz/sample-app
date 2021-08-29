package com.gnarbaiz.android.news.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.postDelayed
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import com.gnarbaiz.android.news.R
import com.gnarbaiz.android.news.databinding.FragmentDetailBinding
import com.gnarbaiz.android.news.util.fromHtml

class DetailFragment : Fragment() {

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val args = DetailFragmentArgs.fromBundle(arguments!!)
        val binding = FragmentDetailBinding.inflate(inflater, container, false).apply {
            article = args.article
        }

        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(R.transition.move)

        with(binding) {
            toolbar.apply {
                setNavigationOnClickListener { findNavController().navigateUp() }
            }
            content.text = TextUtils.expandTemplate(getText(R.string.content), args.article.url).toString().fromHtml()
            content.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(args.article.url))
                startActivity(intent)
            }
        }

        // Make sure we don't wait longer than a second for the Picasso image
        handler.postDelayed(1000) {
            startPostponedEnterTransition()
        }
        postponeEnterTransition()

        return binding.root
    }
}