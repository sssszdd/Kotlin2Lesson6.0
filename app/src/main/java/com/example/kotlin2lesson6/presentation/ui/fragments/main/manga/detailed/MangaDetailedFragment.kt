package com.example.kotlin2lesson6.presentation.ui.fragments.main.manga.detailed

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin2lesson6.R
import com.example.kotlin2lesson6.base.BaseFragment
import com.example.kotlin2lesson6.databinding.FragmentMangaDetailedBinding
import com.example.kotlin2lesson6.presentation.extentions.loadImageWithGlide
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MangaDetailedFragment :
    BaseFragment<FragmentMangaDetailedBinding, MangaDetailedViewModel>(R.layout.fragment_manga_detailed) {
    override val binding by viewBinding(FragmentMangaDetailedBinding::bind)
    override val viewModel: MangaDetailedViewModel by viewModels()
    private val args: MangaDetailedFragmentArgs by navArgs()

    override fun establishRequest() {
        viewModel.fetchDetailedManga(args.mangaId)
    }

    override fun launchObservers() {
        subscribeToDetailedManga()
    }

    private fun subscribeToDetailedManga() {
        viewModel.mangaDetailedState.spectateUiState(
            success = {
                binding.apply {
                    it.apply {
                        imCover.loadImageWithGlide(data.mangaDto.coverImage?.original)
                        imPoster.loadImageWithGlide(data.mangaDto.posterImage.medium)
                        tvSubtype.text = data.mangaDto.subtype.uppercase()
                        tvYear.text = data.mangaDto.createdAt
                        tvTitle.text = data.mangaDto.titles.en
                        tvSynopsis.text = data.mangaDto.synopsis
                        tvAverageRating.text = "${data.mangaDto.averageRating}%"
                        tvRating.text = "Rank #${data.mangaDto.ratingRank}"
                        tvPopularity.text = "Rank #${data.mangaDto.popularityRank}"

                    }
                }

            } , error = { Log.e("tag", it) }
        )

    }

}