package com.example.applemarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.applemarket.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ITEM: String = "extra_item"
    }

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val itemItem = intent.getParcelableExtra<Item>(EXTRA_ITEM)

        binding.detailTitle.text = itemItem!!.title
        binding.detailIntroduce.text = itemItem.introduce
        binding.detailPlace.text = itemItem.place
        binding.detailPrice.text = itemItem.price.toString()
        binding.detailSeller.text = itemItem.seller
        binding.detailImage.setImageResource(itemItem.image)


        //디테일 페이지에서 뒤로가기 버튼 눌렀을 때
        binding.detailBackBtn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}